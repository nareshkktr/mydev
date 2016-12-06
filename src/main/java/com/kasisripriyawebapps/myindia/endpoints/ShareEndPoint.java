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

import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ActionCountResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ShareUnShareRequest;
import com.kasisripriyawebapps.myindia.service.ShareService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * The Class ShareEndPoint.
 */
@Path(value = EndPointConstants.SHARE_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.SHARE_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.SHARE_ENDPOINT_API_TAGS }, description = EndPointConstants.SHARE_ENDPOINT_API_DESCRIPTION)
public class ShareEndPoint {

	/** The share service. */
	@Autowired
	ShareService shareService;

	@GET
	@ApiOperation(value = EndPointConstants.GET_ALL_SHARE_OBJECTS_API_VALUE, nickname = EndPointConstants.GET_ALL_SHARE_OBJECTS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_ALL_SHARE_OBJECTS_API_DESCRIPTION)
	@Path(EndPointConstants.GET_ALL_SHARE_OBJECTS_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllShareObjects() throws InternalServerException {
		return Response.status(Status.OK).entity(null).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.SHARE_OBJECT_API_VALUE, nickname = EndPointConstants.SHARE_OBJECT_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.SHARE_OBJECT_API_DESCRIPTION)
	@Path(EndPointConstants.SHARE_OBJECT_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response shareObject(ShareUnShareRequest shareUnShareRequest) throws InternalServerException {
		Integer shareCount = shareService.shareObject(shareUnShareRequest);
		ActionCountResponse actionCountResponse = new ActionCountResponse(shareCount);
		return Response.status(Status.OK).entity(actionCountResponse).build();
	}
}
