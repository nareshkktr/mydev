/*
 * 
 */
package com.kasisripriyawebapps.myindia.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.exception.ConflictException;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.PreConditionFailedException;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.SaveOrUpdateDeleteObjectResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ThumbsUpDownRequest;
import com.kasisripriyawebapps.myindia.service.ThumbsUpDownService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * The Class ThumbsUpDownEndPoint.
 */
@Path(value = EndPointConstants.THUMBS_UP_DOWN_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.THUMBS_UP_DOWN_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.THUMBS_UP_DOWN_ENDPOINT_API_TAGS }, description = EndPointConstants.THUMBS_UP_DOWN_ENDPOINT_API_DESCRIPTION)
public class ThumbsUpDownEndPoint extends BaseEndPoint{

	/** The thumbs up down service. */
	@Autowired
	ThumbsUpDownService thumbsUpDownService;
	
	@POST
	@ApiOperation(value = EndPointConstants.THUMBS_UP_DOWN_API_VALUE, nickname = EndPointConstants.THUMBS_UP_DOWN_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.THUMBS_UP_DOWN_API_DESCRIPTION)
	@Path(EndPointConstants.THUMBS_UP_DOWN_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEvent(final ThumbsUpDownRequest request) throws InternalServerException, PreConditionFailedException,
			PreConditionRequiredException, ConflictException {

		LoggedInUserDetails loggedInUserDetails = getLoggedInUserDetails();
		Long requestId = null;
		if (validateCreateUpdateDeleteThumbsUpDown(request)) {
			requestId = thumbsUpDownService.createThumbsUpDown(request, loggedInUserDetails);
		}
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(requestId);
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}

	@GET
	@ApiOperation(value = EndPointConstants.GET_ALL_THUMBS_UP_DOWN_OBJECTS_API_VALUE, nickname = EndPointConstants.GET_ALL_THUMBS_UP_DOWN_OBJECTS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_ALL_THUMBS_UP_DOWN_OBJECTS_API_DESCRIPTION)
	@Path(EndPointConstants.GET_ALL_THUMBS_UP_DOWN_OBJECTS_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllThumbsUpDownObjects() throws InternalServerException {
		return Response.status(Status.OK).entity(null).build();
	}
	
	private boolean validateCreateUpdateDeleteThumbsUpDown(ThumbsUpDownRequest request)
			throws PreConditionFailedException, PreConditionRequiredException {
		if (request == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		}
		return true; 
	}
}
