/*
 * 
 */
package com.kasisripriyawebapps.myindia.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.service.ThumbsUpDownService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * The Class ThumbsUpDownEndPoint.
 */
@Path(value = EndPointConstants.SHARE_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.SHARE_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.SHARE_ENDPOINT_API_TAGS }, description = EndPointConstants.SHARE_ENDPOINT_API_DESCRIPTION)
public class ThumbsUpDownEndPoint {

	/** The thumbs up down service. */
	@Autowired
	ThumbsUpDownService thumbsUpDownService;

	@GET
	@ApiOperation(value = EndPointConstants.GET_ALL_THUMBS_UP_DOWN_OBJECTS_API_VALUE, nickname = EndPointConstants.GET_ALL_THUMBS_UP_DOWN_OBJECTS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_ALL_THUMBS_UP_DOWN_OBJECTS_API_DESCRIPTION)
	@Path(EndPointConstants.GET_ALL_THUMBS_UP_DOWN_OBJECTS_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllThumbsUpDownObjects() throws InternalServerException {
		return Response.status(Status.OK).entity(null).build();
	}
}
