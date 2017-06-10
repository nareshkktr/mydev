package com.kasisripriyawebapps.myindia.service;

import java.util.List;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.PreConditionFailedException;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.AddPhotoRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.AddPhotoToAlbumRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.AlbumResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CommonGetObjectsRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateAlbumRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateImageRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.PhotoResponse;

public interface ImageService {

	void addImages(List<CreateUpdateImageRequest> createUpdateImageRequest, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException, PreConditionRequiredException, PreConditionFailedException;

	String addImageToLocalDrive(String objectType, Long objectId, String imageData, String imageName)
			throws InternalServerException;

	boolean addImage(CreateUpdateImageRequest createUpdateImageRequest, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException, PreConditionRequiredException, PreConditionFailedException;

	List<AlbumResponse> getAlbumsByObject(CommonGetObjectsRequest commonGetObjectsRequest)
			throws InternalServerException, RecordNotFoundException;

	Long createUpdateAlbum(CreateUpdateAlbumRequest createUpdateAlbumRequest, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException;

	Long addPhotosToAlbum(List<AddPhotoToAlbumRequest> addPhotoToAlbumRequest, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException;

	List<PhotoResponse> getPhotosByObject(CommonGetObjectsRequest commonGetObjectsRequest)
			throws InternalServerException, RecordNotFoundException;

	Long addPhotos(List<AddPhotoRequest> addPhotoRequest, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException, RecordNotFoundException;

	List<PhotoResponse> getAlbumPhotosByObject(CommonGetObjectsRequest commonGetObjectsRequest)
			throws InternalServerException, RecordNotFoundException;
}
