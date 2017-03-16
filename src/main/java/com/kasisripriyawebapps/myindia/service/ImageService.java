package com.kasisripriyawebapps.myindia.service;

import java.util.List;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.PreConditionFailedException;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateImageRequest;

public interface ImageService {

	void addImages(List<CreateUpdateImageRequest> createUpdateImageRequest, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException, PreConditionRequiredException, PreConditionFailedException;

	String addImageToLocalDrive(String objectType, Long objectId, String imageData, String imageName)
			throws InternalServerException;

	boolean addImage(CreateUpdateImageRequest createUpdateImageRequest, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException, PreConditionRequiredException, PreConditionFailedException;
}
