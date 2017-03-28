package com.kasisripriyawebapps.myindia.serviceimpl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.dao.ProblemDao;
import com.kasisripriyawebapps.myindia.entity.CommentImage;
import com.kasisripriyawebapps.myindia.entity.EventImage;
import com.kasisripriyawebapps.myindia.entity.LocationImage;
import com.kasisripriyawebapps.myindia.entity.PartyImage;
import com.kasisripriyawebapps.myindia.entity.PoliticianImage;
import com.kasisripriyawebapps.myindia.entity.PostImage;
import com.kasisripriyawebapps.myindia.entity.Problem;
import com.kasisripriyawebapps.myindia.entity.ProblemImage;
import com.kasisripriyawebapps.myindia.entity.UserImage;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.PreConditionFailedException;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateImageRequest;
import com.kasisripriyawebapps.myindia.service.ImageService;
import com.kasisripriyawebapps.myindia.util.AmazonS3Util;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private Environment env;

	@Autowired
	ProblemDao problemDao;

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
}
