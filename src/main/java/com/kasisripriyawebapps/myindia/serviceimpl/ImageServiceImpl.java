package com.kasisripriyawebapps.myindia.serviceimpl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.dao.ImageDao;
import com.kasisripriyawebapps.myindia.entity.CommentImage;
import com.kasisripriyawebapps.myindia.entity.EventImage;
import com.kasisripriyawebapps.myindia.entity.LocationImage;
import com.kasisripriyawebapps.myindia.entity.PartyImage;
import com.kasisripriyawebapps.myindia.entity.PoliticianImage;
import com.kasisripriyawebapps.myindia.entity.PostImage;
import com.kasisripriyawebapps.myindia.entity.ProblemImage;
import com.kasisripriyawebapps.myindia.entity.UserImage;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.PreConditionFailedException;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateImageRequest;
import com.kasisripriyawebapps.myindia.service.ImageService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	ImageDao imageDao;

	@Override
	@Transactional
	public void addImages(List<CreateUpdateImageRequest> createUpdateImageRequest)
			throws InternalServerException, PreConditionRequiredException, PreConditionFailedException {
		for (CreateUpdateImageRequest eachImageRequest : createUpdateImageRequest) {
			addImage(eachImageRequest);
		}
	}

	@Override
	public String addImageToLocalDrive(String objectType, String objectId, String imageData, String imageName)
			throws InternalServerException {
		String imageSavedLocationRootPath = ApplicationConstants.IMAGE_ROOT_PATH;
		File objectTypeGuidDirectory = new File(
				imageSavedLocationRootPath + File.separator + objectType + File.separator + objectId);
		if (!objectTypeGuidDirectory.exists())
			objectTypeGuidDirectory.mkdirs();
		String fileUrl = CommonUtil.getImageLocation(imageData,
				objectTypeGuidDirectory.getAbsolutePath() + File.separator + imageName);
		return fileUrl;
	}

	@Override
	@Transactional
	public boolean addImage(CreateUpdateImageRequest createUpdateImageRequest)
			throws InternalServerException, PreConditionRequiredException, PreConditionFailedException {
		if (validateAddImageRequest(createUpdateImageRequest)) {
			String fileUrl = addImageToLocalDrive(createUpdateImageRequest.getObjectType(),
					createUpdateImageRequest.getObjectId(), createUpdateImageRequest.getImageData(),
					createUpdateImageRequest.getImageName());
			if (fileUrl != null && !fileUrl.isEmpty()) {
				Object imageEntity = prepareImageEntityData(createUpdateImageRequest, fileUrl);
				if (imageEntity != null) {
					imageDao.addImage(imageEntity);
				}
			}
		}
		return true;
	}

	private Object prepareImageEntityData(CreateUpdateImageRequest createUpdateImageRequest, String fileUrl) {
		Object imageObj = null;
		if (createUpdateImageRequest.getObjectType().equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_COMMENT)) {
			CommentImage imageEntity = new CommentImage();
			imageEntity.setImageName(createUpdateImageRequest.getImageName());
			imageEntity.setImageURL(fileUrl);
			imageEntity.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			imageObj = imageEntity;
		} else if (createUpdateImageRequest.getObjectType().equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_EVENT)) {
			EventImage imageEntity = new EventImage();
			imageEntity.setImageName(createUpdateImageRequest.getImageName());
			imageEntity.setImageURL(fileUrl);
			imageEntity.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			imageObj = imageEntity;
		} else if (createUpdateImageRequest.getObjectType()
				.equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_LOCATION)) {
			LocationImage imageEntity = new LocationImage();
			imageEntity.setImageName(createUpdateImageRequest.getImageName());
			imageEntity.setImageURL(fileUrl);
			imageEntity.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			imageObj = imageEntity;
		} else if (createUpdateImageRequest.getObjectType().equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_PARTY)) {
			PartyImage imageEntity = new PartyImage();
			imageEntity.setImageName(createUpdateImageRequest.getImageName());
			imageEntity.setImageURL(fileUrl);
			imageEntity.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			imageObj = imageEntity;
		} else if (createUpdateImageRequest.getObjectType()
				.equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_POLTIICIAN)) {
			PoliticianImage imageEntity = new PoliticianImage();
			imageEntity.setImageName(createUpdateImageRequest.getImageName());
			imageEntity.setImageURL(fileUrl);
			imageEntity.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			imageObj = imageEntity;
		} else if (createUpdateImageRequest.getObjectType().equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_POST)) {
			PostImage imageEntity = new PostImage();
			imageEntity.setImageName(createUpdateImageRequest.getImageName());
			imageEntity.setImageURL(fileUrl);
			imageObj = imageEntity;
		} else if (createUpdateImageRequest.getObjectType()
				.equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_PROBLEM)) {
			ProblemImage imageEntity = new ProblemImage();
			//imageEntity.setImageName(createUpdateImageRequest.getImageName());
			imageEntity.setImageURL(fileUrl);
			imageEntity.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			imageObj = imageEntity;
		} else if (createUpdateImageRequest.getObjectType().equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_USER)) {
			UserImage imageEntity = new UserImage();
			imageEntity.setImageName(createUpdateImageRequest.getImageName());
			imageEntity.setImageURL(fileUrl);
			imageEntity.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			imageObj = imageEntity;
		}
		return imageObj;
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
		} else if (createUpdateImageRequest.getObjectId().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.OBJECT_ID_NOT_FOUND);
		} else if (!CommonUtil.isValueExistInList(createUpdateImageRequest.getObjectType(), CommonUtil.objectTypes)) {
			throw new PreConditionFailedException(ExceptionConstants.INVALID_OBECT_TYPE);
		}
		return true;
	}
}
