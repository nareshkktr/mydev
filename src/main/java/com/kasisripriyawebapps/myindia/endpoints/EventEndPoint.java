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
import com.kasisripriyawebapps.myindia.service.EventService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// TODO: Auto-generated Javadoc
/**
 * The Class EventEndPoint.
 */

@Path(value = EndPointConstants.EVENT_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.EVENT_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.EVENT_ENDPOINT_API_TAGS }, description = EndPointConstants.EVENT_ENDPOINT_API_DESCRIPTION)
public class EventEndPoint {

	/** The event service. */
	@Autowired
	EventService eventService;

	@GET
	@ApiOperation(value = EndPointConstants.GET_ALL_EVENTS_API_VALUE, nickname = EndPointConstants.GET_ALL_EVENTS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_ALL_EVENTS_API_DESCRIPTION)
	@Path(EndPointConstants.GET_ALL_EVENTS_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEvents() throws InternalServerException {
		return Response.status(Status.OK).entity(null).build();
	}
}
