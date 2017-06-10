package com.kasisripriyawebapps.myindia.serviceimpl;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.dao.ProblemAlbumDao;
import com.kasisripriyawebapps.myindia.dao.ProblemDao;
import com.kasisripriyawebapps.myindia.dao.ProblemImageDao;
import com.kasisripriyawebapps.myindia.entity.CommentImage;
import com.kasisripriyawebapps.myindia.entity.EventImage;
import com.kasisripriyawebapps.myindia.entity.LocationImage;
import com.kasisripriyawebapps.myindia.entity.PartyImage;
import com.kasisripriyawebapps.myindia.entity.PoliticianImage;
import com.kasisripriyawebapps.myindia.entity.PostImage;
import com.kasisripriyawebapps.myindia.entity.Problem;
import com.kasisripriyawebapps.myindia.entity.ProblemAlbum;
import com.kasisripriyawebapps.myindia.entity.ProblemImage;
import com.kasisripriyawebapps.myindia.entity.UserImage;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.PreConditionFailedException;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ActivityRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.AddPhotoRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.AddPhotoToAlbumRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.AlbumResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.BaseUserInformation;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CommonGetObjectsRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateAlbumRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateImageRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.PhotoResponse;
import com.kasisripriyawebapps.myindia.service.AccountService;
import com.kasisripriyawebapps.myindia.service.ActivityService;
import com.kasisripriyawebapps.myindia.service.ImageService;
import com.kasisripriyawebapps.myindia.util.AmazonS3Util;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private Environment env;

	@Autowired
	ProblemDao problemDao;

	@Autowired
	ProblemAlbumDao problemAlbumDao;

	@Autowired
	ProblemImageDao problemImageDao;

	@Autowired
	ActivityService activityService;

	@Autowired
	AccountService accountService;

	private static final String SUFFIX = "/";

	@Override
	@Transactional
	public void addImages(List<CreateUpdateImageRequest> createUpdateImageRequest,
			LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException, PreConditionRequiredException, PreConditionFailedException {
		for (CreateUpdateImageRequest eachImageRequest : createUpdateImageRequest) {
			addImage(eachImageRequest, loggedInUserDetails);
		}
	}

	@Override
	public String addImageToLocalDrive(String objectType, Long objectId, String fileData, String fileName)
			throws InternalServerException {

		String bucketName = objectType.equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_PROBLEM)
				? env.getProperty("amazon.s3.problem.bucket.name") : "";
		String folderName = objectType.equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_PROBLEM)
				? env.getProperty("amazon.s3.problem.problems.folder.name") : "";

		fileData = fileData.split(",")[1];
		byte[] decodedBytes = Base64.getDecoder().decode(fileData.getBytes(StandardCharsets.UTF_8));
		fileName = folderName + SUFFIX + objectId.toString() + SUFFIX + fileName;
		try {
			AmazonS3Util.createFile(bucketName, folderName, decodedBytes, fileName);
			fileName = env.getProperty("amazon.s3.host.name") + bucketName + SUFFIX + fileName;
		} catch (InternalServerException e) {
			throw e;
		}

		return fileName;
	}

	@Override
	@Transactional
	public boolean addImage(CreateUpdateImageRequest createUpdateImageRequest, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException, PreConditionRequiredException, PreConditionFailedException {
		if (validateAddImageRequest(createUpdateImageRequest)) {
			String fileUrl = addImageToLocalDrive(createUpdateImageRequest.getObjectType(),
					createUpdateImageRequest.getObjectId(), createUpdateImageRequest.getImageData(),
					createUpdateImageRequest.getImageName());
			if (fileUrl != null && !fileUrl.isEmpty()) {
				prepareImageEntityData(createUpdateImageRequest, fileUrl, loggedInUserDetails);
			}
		}
		return true;
	}

	private void prepareImageEntityData(CreateUpdateImageRequest createUpdateImageRequest, String fileUrl,
			LoggedInUserDetails loggedInUserDetails) throws InternalServerException {

		if (createUpdateImageRequest.getObjectType().equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_COMMENT)) {
			CommentImage imageEntity = new CommentImage();
			imageEntity.setImageName(createUpdateImageRequest.getImageName());
			imageEntity.setImageURL(fileUrl);
			imageEntity.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());

		} else if (createUpdateImageRequest.getObjectType().equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_EVENT)) {
			EventImage imageEntity = new EventImage();
			imageEntity.setImageName(createUpdateImageRequest.getImageName());
			imageEntity.setImageURL(fileUrl);
			imageEntity.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());

		} else if (createUpdateImageRequest.getObjectType()
				.equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_LOCATION)) {
			LocationImage imageEntity = new LocationImage();
			imageEntity.setImageName(createUpdateImageRequest.getImageName());
			imageEntity.setImageURL(fileUrl);
			imageEntity.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());

		} else if (createUpdateImageRequest.getObjectType().equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_PARTY)) {
			PartyImage imageEntity = new PartyImage();
			imageEntity.setImageName(createUpdateImageRequest.getImageName());
			imageEntity.setImageURL(fileUrl);
			imageEntity.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());

		} else if (createUpdateImageRequest.getObjectType()
				.equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_POLTIICIAN)) {
			PoliticianImage imageEntity = new PoliticianImage();
			imageEntity.setImageName(createUpdateImageRequest.getImageName());
			imageEntity.setImageURL(fileUrl);
			imageEntity.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());

		} else if (createUpdateImageRequest.getObjectType().equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_POST)) {
			PostImage imageEntity = new PostImage();
			imageEntity.setImageName(createUpdateImageRequest.getImageName());
			imageEntity.setImageURL(fileUrl);

		} else if (createUpdateImageRequest.getObjectType()
				.equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_PROBLEM)) {

			Problem problem = problemDao.getProblemByGuid(createUpdateImageRequest.getObjectId());

			if (createUpdateImageRequest.getIsMainPhotoURL()) {
				problem.setPhotoURL(fileUrl);
				problemDao.updateProblem(problem);

			} else {

				ProblemImage imageEntity = new ProblemImage();
				imageEntity.setImageName(createUpdateImageRequest.getImageName());
				imageEntity.setImageURL(fileUrl);
				imageEntity.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
				imageEntity.setCreatedBy(loggedInUserDetails.getGuid());
				imageEntity.setCategory(createUpdateImageRequest.getCategory());
				imageEntity.setProblem(problem);
			}

		} else if (createUpdateImageRequest.getObjectType().equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_USER)) {
			UserImage imageEntity = new UserImage();
			imageEntity.setImageName(createUpdateImageRequest.getImageName());
			imageEntity.setImageURL(fileUrl);
			imageEntity.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());

		}
	}

	private boolean validateAddImageRequest(CreateUpdateImageRequest createUpdateImageRequest)
			throws PreConditionRequiredException, PreConditionFailedException {
		if (createUpdateImageRequest.getImageName() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.IMAGE_NAME_REQUIRED);
		} else if (createUpdateImageRequest.getImageData() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.IMAGE_REQUIRED);
		} else if (createUpdateImageRequest.getObjectType() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.OBJECT_TYPE_REQUIRED);
		} else if (createUpdateImageRequest.getObjectId() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.OBJECT_ID_REQUIRED);
		} else if (createUpdateImageRequest.getImageName().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.IMAGE_NAME_NOT_FOUND);
		} else if (createUpdateImageRequest.getImageData().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.IMAGE_NOT_FOUND);
		} else if (createUpdateImageRequest.getObjectType().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.OBJECT_TYPE_NOT_FOUND);
		} else if (createUpdateImageRequest.getObjectId().equals((Long.valueOf(0)))) {
			throw new PreConditionFailedException(ExceptionConstants.OBJECT_ID_NOT_FOUND);
		} else if (!CommonUtil.isValueExistInList(createUpdateImageRequest.getObjectType(), CommonUtil.objectTypes)) {
			throw new PreConditionFailedException(ExceptionConstants.INVALID_OBECT_TYPE);
		}
		return true;
	}

	@Override
	@Transactional
	public List<AlbumResponse> getAlbumsByObject(CommonGetObjectsRequest commonGetObjectsRequest)
			throws InternalServerException, RecordNotFoundException {

		List<AlbumResponse> problemAlbumsResponse = new ArrayList<AlbumResponse>();
		if (commonGetObjectsRequest.getObjectType() != null
				&& commonGetObjectsRequest.getObjectType().equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_PROBLEM)) {
			List<ProblemAlbum> problemAlbums = problemAlbumDao.getAllAlbumsByGuid(
					commonGetObjectsRequest.getObjectGuid(), commonGetObjectsRequest.getPageLimit(),
					commonGetObjectsRequest.getPageOffset());
			if (CommonUtil.isListNotNullAndNotEmpty(problemAlbums)) {
				problemAlbumsResponse = prepareAlbumsResponse(problemAlbums);
			}
		}
		return problemAlbumsResponse;
	}

	private List<AlbumResponse> prepareAlbumsResponse(List<ProblemAlbum> problemAlbums)
			throws InternalServerException, RecordNotFoundException {

		List<AlbumResponse> problemAlbumsResponse = new ArrayList<AlbumResponse>();

		Set<Long> accountIds = problemAlbums.stream().map(ProblemAlbum::getCreatedBy).collect(Collectors.toSet());

		List<BaseUserInformation> usersInfo = accountService.getAccountsByIds(accountIds);

		final Map<Long, List<BaseUserInformation>> usersInfoMap = usersInfo.stream()
				.collect(Collectors.groupingBy(usersInfoObj -> usersInfoObj.getAccountGuid()));

		for (ProblemAlbum problemAlbum : problemAlbums) {
			AlbumResponse albumResponse = new AlbumResponse();
			albumResponse.setCommentsCount(problemAlbum.getCommentsCount().longValue());
			albumResponse.setCreatedTimeStamp(problemAlbum.getCreatedTimeStamp());
			albumResponse.setCreator(usersInfoMap.get(problemAlbum.getCreatedBy()).get(0));
			albumResponse.setGuid(problemAlbum.getGuid());
			albumResponse.setImageUrl(problemAlbum.getImageURL());
			albumResponse.setName(problemAlbum.getAlbumName());
			albumResponse.setNoOfPhotos(problemAlbum.getImagesCount());
			albumResponse.setReportAbuseCount(problemAlbum.getReportAbuseCount().longValue());
			albumResponse.setShareCount(problemAlbum.getShareCount().longValue());
			albumResponse.setThumbsDownCount(problemAlbum.getThumbsDownCount().longValue());
			albumResponse.setThumbsUpCount(problemAlbum.getThumbsUpCount().longValue());
			albumResponse.setUpdatedTimeStamp(problemAlbum.getUpdatedTimeStamp());
			problemAlbumsResponse.add(albumResponse);
		}
		return problemAlbumsResponse;
	}

	@Override
	@Transactional
	public Long createUpdateAlbum(CreateUpdateAlbumRequest createUpdateAlbumRequest,
			LoggedInUserDetails loggedInUserDetails) throws InternalServerException {

		ProblemAlbum problemAlbum = null;
		Long problemAlbumGuid = createUpdateAlbumRequest.getAlbumGuid();

		if (problemAlbumGuid != null) {
			if (createUpdateAlbumRequest.getObjectType() != null && createUpdateAlbumRequest.getObjectType()
					.equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_PROBLEM)) {
				problemAlbum = problemAlbumDao.getProblemAlbumByGuid(problemAlbumGuid);
			}
		} else {
			problemAlbum = new ProblemAlbum();
			problemAlbum.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			problemAlbum.setCreatedBy(loggedInUserDetails.getGuid());
			Problem problem = problemDao.getProblemByGuid(createUpdateAlbumRequest.getObjectGuId());
			problemAlbum.setProblem(problem);

		}
		problemAlbum.setAlbumName(createUpdateAlbumRequest.getAlbumName());
		problemAlbum.setUpdatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
		problemAlbum.setUpdatedBy(loggedInUserDetails.getGuid());

		if (problemAlbumGuid != null) {
			problemAlbumDao.updateProblemAlbum(problemAlbum);

		} else {
			problemAlbumGuid = problemAlbumDao.saveProblemAlbum(problemAlbum);
			problemAlbum = problemAlbumDao.getProblemAlbumByGuid(problemAlbumGuid);
		}

		String albumImageURL = addImageToS3(createUpdateAlbumRequest.getObjectType(),
				createUpdateAlbumRequest.getObjectGuId(), createUpdateAlbumRequest.getImageData(),
				createUpdateAlbumRequest.getImageName(), ApplicationConstants.ALBUM + SUFFIX + problemAlbumGuid);
		problemAlbum.setImageURL(albumImageURL);

		problemAlbumDao.mergeProblemAlbum(problemAlbum);

		if (createUpdateAlbumRequest.getAlbumGuid() == null) {
			ActivityRequest activityReq = preapreActivityRequestForCreateUpdateAlbum(problemAlbum);
			activityService.saveActivity(activityReq);
		}
		return problemAlbumGuid;

	}

	private String addImageToS3(String objectType, Long objectId, String fileData, String fileName,
			String subFolderName) throws InternalServerException {

		String bucketName = objectType.equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_PROBLEM)
				? env.getProperty("amazon.s3.problem.bucket.name") : "";
		String folderName = objectType.equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_PROBLEM)
				? env.getProperty("amazon.s3.problem.problems.folder.name") : "";

		fileData = fileData.split(",")[1];
		byte[] decodedBytes = Base64.getDecoder().decode(fileData.getBytes(StandardCharsets.UTF_8));
		fileName = folderName + SUFFIX + objectId.toString() + SUFFIX + subFolderName + SUFFIX + fileName;
		try {
			AmazonS3Util.createFile(bucketName, folderName, decodedBytes, fileName);
			fileName = env.getProperty("amazon.s3.host.name") + bucketName + SUFFIX + fileName;
		} catch (InternalServerException e) {
			throw e;
		}

		return fileName;
	}

	private ActivityRequest preapreActivityRequestForCreateUpdateAlbum(ProblemAlbum problemAlbum) {

		ActivityRequest activityRequest = new ActivityRequest();

		activityRequest.setActivityContent(problemAlbum.getImageURL());
		activityRequest.setActivityName(ApplicationConstants.ADDED_ALBUM);
		activityRequest.setActivityObjectGuid(problemAlbum.getGuid());
		activityRequest.setActivityObjectType(ApplicationConstants.OBJECT_TYPE_ALBUM);
		activityRequest.setOnObjectGuid(problemAlbum.getProblem().getGuid());
		activityRequest.setOnObjectType(ApplicationConstants.OBJECT_TYPE_PROBLEM);
		activityRequest.setCreatedBy(problemAlbum.getCreatedBy());
		activityRequest.setCreatedTimeStamp(problemAlbum.getCreatedTimeStamp());

		return activityRequest;
	}

	@Override
	@Transactional
	public Long addPhotosToAlbum(List<AddPhotoToAlbumRequest> addPhotoTosAlbumRequest,
			LoggedInUserDetails loggedInUserDetails) throws InternalServerException {

		Long problemImageGuid = null;

		if (CommonUtil.isListNotNullAndNotEmpty(addPhotoTosAlbumRequest)) {

			for (AddPhotoToAlbumRequest addPhotoToAlbumRequest : addPhotoTosAlbumRequest) {

				ProblemImage problemImage = new ProblemImage();

				Long problemAlbumGuid = addPhotoToAlbumRequest.getAlbumGuid();
				ProblemAlbum problemAlbum = null;
				if (problemAlbumGuid != null) {
					problemAlbum = problemAlbumDao.getProblemAlbumByGuid(problemAlbumGuid);
					problemImage.setProblemAlbum(problemAlbum);
				}

				problemImage.setImageName(addPhotoToAlbumRequest.getImageName());
				problemImage.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
				problemImage.setCreatedBy(loggedInUserDetails.getGuid());

				Problem problem = problemDao.getProblemByGuid(addPhotoToAlbumRequest.getObjectGuId());
				problemImage.setProblem(problem);

				String subFolder = "";
				if (problemAlbum != null) {
					subFolder = ApplicationConstants.ALBUM + SUFFIX + problemAlbumGuid;
				} else {
					subFolder = ApplicationConstants.PHOTOS;
				}
				String albumImageURL = addImageToS3(addPhotoToAlbumRequest.getObjectType(),
						addPhotoToAlbumRequest.getObjectGuId(), addPhotoToAlbumRequest.getImageData(),
						addPhotoToAlbumRequest.getImageName(), subFolder);
				problemImage.setImageURL(albumImageURL);

				problemImageGuid = problemImageDao.saveProblemImage(problemImage);

				ActivityRequest activityReq = preapreActivityRequestForCreateImage(problemImage);
				activityService.saveActivity(activityReq);

				if (problemAlbumGuid != null) {
					problemAlbum.setImagesCount(problemAlbum.getImagesCount() + 1);
					problemAlbumDao.updateProblemAlbum(problemAlbum);
				}
			}
		}

		return problemImageGuid;
	}

	private ActivityRequest preapreActivityRequestForCreateImage(ProblemImage problemImage) {

		ActivityRequest activityRequest = new ActivityRequest();

		activityRequest.setActivityContent(problemImage.getImageURL());
		activityRequest.setActivityName(ApplicationConstants.ADDED_PHOTO);
		activityRequest.setActivityObjectGuid(problemImage.getGuid());
		activityRequest.setActivityObjectType(ApplicationConstants.OBJECT_TYPE_PHOTO);
		activityRequest.setOnObjectGuid(problemImage.getProblem().getGuid());
		activityRequest.setOnObjectType(ApplicationConstants.OBJECT_TYPE_PROBLEM);
		activityRequest.setCreatedBy(problemImage.getCreatedBy());
		activityRequest.setCreatedTimeStamp(problemImage.getCreatedTimeStamp());

		return activityRequest;

	}

	@Override
	@Transactional
	public List<PhotoResponse> getPhotosByObject(CommonGetObjectsRequest commonGetObjectsRequest)
			throws InternalServerException, RecordNotFoundException {

		List<PhotoResponse> problemPhotosResponse = new ArrayList<PhotoResponse>();
		if (commonGetObjectsRequest.getObjectType() != null
				&& commonGetObjectsRequest.getObjectType().equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_PROBLEM)) {
			List<ProblemImage> problemImages = problemImageDao.getAllPhotosByGuid(
					commonGetObjectsRequest.getObjectGuid(), commonGetObjectsRequest.getPageLimit(),
					commonGetObjectsRequest.getPageOffset());
			if (CommonUtil.isListNotNullAndNotEmpty(problemImages)) {
				problemPhotosResponse = preparePhotosResponse(problemImages);
			}
		}
		return problemPhotosResponse;
	}

	private List<PhotoResponse> preparePhotosResponse(List<ProblemImage> problemImages)
			throws InternalServerException, RecordNotFoundException {

		List<PhotoResponse> problemPhotosResponse = new ArrayList<PhotoResponse>();

		Set<Long> accountIds = problemImages.stream().map(ProblemImage::getCreatedBy).collect(Collectors.toSet());

		List<BaseUserInformation> usersInfo = accountService.getAccountsByIds(accountIds);

		final Map<Long, List<BaseUserInformation>> usersInfoMap = usersInfo.stream()
				.collect(Collectors.groupingBy(usersInfoObj -> usersInfoObj.getAccountGuid()));

		for (ProblemImage problemImage : problemImages) {
			PhotoResponse photoResponse = new PhotoResponse();
			photoResponse.setCommentsCount(problemImage.getCommentsCount().longValue());
			photoResponse.setCreatedTimeStamp(problemImage.getCreatedTimeStamp());
			photoResponse.setCreator(usersInfoMap.get(problemImage.getCreatedBy()).get(0));
			photoResponse.setGuid(problemImage.getGuid());
			photoResponse.setImageUrl(problemImage.getImageURL());
			photoResponse.setReportAbuseCount(problemImage.getReportAbuseCount().longValue());
			photoResponse.setShareCount(problemImage.getShareCount().longValue());
			photoResponse.setThumbsDownCount(problemImage.getThumbsDownCount().longValue());
			photoResponse.setThumbsUpCount(problemImage.getThumbsUpCount().longValue());
			photoResponse.setName(problemImage.getImageName());
			problemPhotosResponse.add(photoResponse);
		}
		return problemPhotosResponse;
	}

	@Override
	@Transactional
	public Long addPhotos(List<AddPhotoRequest> addPhotoRequest, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException, RecordNotFoundException {

		Long problemImageGuid = null;

		if (CommonUtil.isListNotNullAndNotEmpty(addPhotoRequest)) {

			for (AddPhotoRequest addEachPhotoRequest : addPhotoRequest) {

				ProblemImage problemImage = new ProblemImage();

				problemImage.setImageName(addEachPhotoRequest.getImageName());
				problemImage.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
				problemImage.setCreatedBy(loggedInUserDetails.getGuid());

				Problem problem = problemDao.getProblemByGuid(addEachPhotoRequest.getObjectGuId());
				problemImage.setProblem(problem);

				String subFolder = ApplicationConstants.PHOTOS;

				String albumImageURL = addImageToS3(addEachPhotoRequest.getObjectType(),
						addEachPhotoRequest.getObjectGuId(), addEachPhotoRequest.getImageData(),
						addEachPhotoRequest.getImageName(), subFolder);
				problemImage.setImageURL(albumImageURL);

				problemImageGuid = problemImageDao.saveProblemImage(problemImage);

				ActivityRequest activityReq = preapreActivityRequestForCreateImage(problemImage);
				activityService.saveActivity(activityReq);

			}
		}

		return problemImageGuid;
	}

	@Override
	@Transactional
	public List<PhotoResponse> getAlbumPhotosByObject(CommonGetObjectsRequest commonGetObjectsRequest)
			throws InternalServerException, RecordNotFoundException {

		List<PhotoResponse> problemPhotosResponse = new ArrayList<PhotoResponse>();
		if (commonGetObjectsRequest.getObjectType() != null
				&& commonGetObjectsRequest.getObjectType().equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_PROBLEM)) {
			List<ProblemImage> problemImages = problemImageDao.getAlbumPhotosByGuid(
					commonGetObjectsRequest.getSubObjectGuid(), commonGetObjectsRequest.getObjectGuid(),
					commonGetObjectsRequest.getPageLimit(), commonGetObjectsRequest.getPageOffset());
			if (CommonUtil.isListNotNullAndNotEmpty(problemImages)) {
				problemPhotosResponse = preparePhotosResponse(problemImages);
			}
		}
		return problemPhotosResponse;
	}
}
