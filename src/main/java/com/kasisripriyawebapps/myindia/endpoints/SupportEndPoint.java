package com.kasisripriyawebapps.myindia.endpoints;

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
import com.kasisripriyawebapps.myindia.requestresponsemodel.SupportUnSupportRequest;
import com.kasisripriyawebapps.myindia.service.SupportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(EndPointConstants.SUPPORT_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.SUPPORT_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.SUPPORT_ENDPOINT_API_TAGS }, description = EndPointConstants.SUPPORT_ENDPOINT_API_DESCRIPTION)
public class SupportEndPoint {

	@Autowired
	SupportService supportService;

	@POST
	@ApiOperation(value = EndPointConstants.SUPPORT_OBJECT_API_VALUE, nickname = EndPointConstants.SUPPORT_OBJECT_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.SUPPORT_OBJECT_API_DESCRIPTION)
	@Path(EndPointConstants.SUPPORT_OBJECT_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response supportObject(SupportUnSupportRequest supportUnSupportRequest) throws InternalServerException {
		Integer shareCount = supportService.supportObject(supportUnSupportRequest);
		ActionCountResponse actionCountResponse = new ActionCountResponse(shareCount);
		return Response.status(Status.OK).entity(actionCountResponse).build();
	}
	@POST
	@ApiOperation(value = EndPointConstants.UNSUPPORT_OBJECT_API_VALUE, nickname = EndPointConstants.UNSUPPORT_OBJECT_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.UNSUPPORT_OBJECT_API_DESCRIPTION)
	@Path(EndPointConstants.UNSUPPORT_OBJECT_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response unSupportObject(SupportUnSupportRequest supportUnSupportRequest) throws InternalServerException {
		Integer shareCount = supportService.unSupportObject(supportUnSupportRequest);
		ActionCountResponse actionCountResponse = new ActionCountResponse(shareCount);
		return Response.status(Status.OK).entity(actionCountResponse).build();
	}
}
