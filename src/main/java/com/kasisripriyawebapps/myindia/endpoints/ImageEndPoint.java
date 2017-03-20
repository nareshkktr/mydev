package com.kasisripriyawebapps.myindia.endpoints;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.PreConditionFailedException;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateImageRequest;
import com.kasisripriyawebapps.myindia.service.ImageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(value = EndPointConstants.IMAGE_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.IMAGE_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.IMAGE_ENDPOINT_API_TAGS }, description = EndPointConstants.IMAGE_ENDPOINT_API_DESCRIPTION)
public class ImageEndPoint extends BaseEndPoint {

	@Autowired
	ImageService imageService;

	@POST
	@ApiOperation(value = EndPointConstants.ADD_IMAGES_API_VALUE, nickname = EndPointConstants.ADD_IMAGES_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.ADD_IMAGES_API_DESCRIPTION)
	@Path(EndPointConstants.ADD_IMAGES_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addImages(final List<CreateUpdateImageRequest> createUpdateImageRequest)
			throws InternalServerException, PreConditionFailedException, PreConditionRequiredException {
		LoggedInUserDetails loggedInUserDetails = getLoggedInUserDetails();
		if (validateAddImages(createUpdateImageRequest)) {
			imageService.addImages(createUpdateImageRequest, loggedInUserDetails);
		}
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

	private boolean validateAddImages(List<CreateUpdateImageRequest> createUpdateImageRequest)
			throws PreConditionFailedException {
		if (createUpdateImageRequest == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		} else if (createUpdateImageRequest.isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.LIST_SHOULD_NOT_BE_EMPTY);
		}
		return true;
	}
}
