package com.kasisripriyawebapps.myindia.service;

import java.util.List;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.PreConditionFailedException;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateImageRequest;

public interface ImageService {

	void addImages(List<CreateUpdateImageRequest> createUpdateImageRequest)
			throws InternalServerException, PreConditionRequiredException, PreConditionFailedException;

	String addImageToLocalDrive(String objectType, String objectId, String imageData, String imageName)
			throws InternalServerException;

	boolean addImage(CreateUpdateImageRequest createUpdateImageRequest)
			throws InternalServerException, PreConditionRequiredException, PreConditionFailedException;
}
