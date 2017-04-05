/*
 * 
 */
package com.kasisripriyawebapps.myindia.endpoints;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.EventRecipientRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.EventRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.SaveOrUpdateDeleteObjectResponse;
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
public class EventEndPoint extends BaseEndPoint {

	/** The event service. */
	@Autowired
	EventService eventService;

	@POST
	@ApiOperation(value = EndPointConstants.CREATE_EVENT_API_VALUE, nickname = EndPointConstants.CREATE_EVENT_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.CREATE_EVENT_API_DESCRIPTION)
	@Path(EndPointConstants.CREATE_EVENT_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEvent(final EventRequest event) throws InternalServerException, PreConditionFailedException,
			PreConditionRequiredException, ConflictException {

		LoggedInUserDetails loggedInUserDetails = getLoggedInUserDetails();
		Long eventId = null;
		if (validateCreateUpdateEventRequest(event)) {
			eventId = eventService.createEvent(event, loggedInUserDetails);
		}
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(eventId);
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}

	@PUT
	@ApiOperation(value = EndPointConstants.UPDATE_EVENT_API_VALUE, nickname = EndPointConstants.UPDATE_EVENT_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.UPDATE_EVENT_API_DESCRIPTION)
	@Path(EndPointConstants.UPDATE_EVENT_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEvent(final EventRequest event) throws InternalServerException, PreConditionFailedException,
			PreConditionRequiredException, ConflictException, RecordNotFoundException {
		LoggedInUserDetails loggedInUserDetails = getLoggedInUserDetails();
		Long eventId = null;
		if (validateCreateUpdateEventRequest(event)) {
			eventId = eventService.updateEvent(event, loggedInUserDetails);
		}
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(eventId);
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}

	@GET
	@ApiOperation(value = EndPointConstants.GET_ALL_EVENTS_API_VALUE, nickname = EndPointConstants.GET_ALL_EVENTS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_ALL_EVENTS_API_DESCRIPTION)
	@Path(EndPointConstants.GET_ALL_EVENTS_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEventById(@PathParam(value = "eventGuid") Long eventGuid)
			throws InternalServerException, RecordNotFoundException, PreConditionFailedException {
		EventRequest event = null;
		if (validateUpdateDeleteProblemTypeRequest(eventGuid)) {
			event = eventService.getEventId(eventGuid);
		}
		return Response.status(Status.OK).entity(event).build();
	}

	@DELETE
	@ApiOperation(value = EndPointConstants.DELETE_EVENT_API_VALUE, nickname = EndPointConstants.DELETE_EVENT_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.DELETE_EVENT_API_DESCRIPTION)
	@Path(EndPointConstants.DELETE_EVENT_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEventById(@PathParam(value = "eventGuid") Long eventGuid)
			throws InternalServerException, RecordNotFoundException, PreConditionFailedException {
		Long eventid = null;
		if (validateUpdateDeleteProblemTypeRequest(eventGuid)) {
			eventid = eventService.deleteEventById(eventGuid);
		}
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(eventid);
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}
	@POST
	@ApiOperation(value = EndPointConstants.ADD_EVENT_RECIPIENT_API_VALUE, nickname = EndPointConstants.ADD_EVENT_RECIPIENT_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.ADD_EVENT_RECIPIENT_API_DESCRIPTION)
	@Path(EndPointConstants.ADD_EVENT_RECIPIENT_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEventRecipient(final EventRecipientRequest request) throws InternalServerException, PreConditionFailedException,
			PreConditionRequiredException, ConflictException {

		LoggedInUserDetails loggedInUserDetails = getLoggedInUserDetails();
		Long eventId = null;
		if (validateCreateUpdateEventRecipientRequest(request)) {
			eventId = eventService.addEventRecipient(request, loggedInUserDetails);
		}
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(eventId);
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}
	
	@DELETE
	@ApiOperation(value = EndPointConstants.REMOVE_EVENT_RECIPIENT_API_VALUE, nickname = EndPointConstants.REMOVE_EVENT_RECIPIENT_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.REMOVE_EVENT_RECIPIENT_API_DESCRIPTION)
	@Path(EndPointConstants.REMOVE_EVENT_RECIPIENT_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeEventRecipient(@PathParam(value = "eventGuid") Long eventGuid)
			throws InternalServerException, RecordNotFoundException, PreConditionFailedException {
		Long eventid = null;
		if (validateUpdateDeleteProblemTypeRequest(eventGuid)) {
			eventid = eventService.removeEventRecipientById(eventGuid);
		}
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(eventid);
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}

	private boolean validateCreateUpdateEventRequest(EventRequest eventRequest)
			throws PreConditionFailedException, PreConditionRequiredException {
		if (eventRequest == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		} else if (eventRequest.getEventName() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.EVENT_NAME_REQUIRED);
		} else if (eventRequest.getCreatedLocationGuId() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.EVENT_CREATEDLOCATIONGUID_REQUIRED);
		} else if (eventRequest.getEventTypeGuId() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.EVENT_EVENTTYPEGUID_REQUIRED);
		} else if (eventRequest.getEventDescription() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.EVENT_DESCRIPTION_REQUIRED);
		} else if (eventRequest.getEventLocationDetails() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.EVENT_LOCATIONDETAILS_REQUIRED);
		} else if (eventRequest.getPhotoURL() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.EVENT_PHOTOURL_REQUIRED);
		} else if (eventRequest.getEventName().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.EVENT_NAME_SHOULD_NOT_BE_EMPTY);
		} else if (eventRequest.getEventDescription().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.EVENT_DESCRIPTION_SHOULD_NOT_BE_EMPTY);
		} else if (eventRequest.getEventLocationDetails().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.EVENT_LOCATIONDETAILS_SHOULD_NOT_BE_EMPTY);
		}
		return true;
	}
	private boolean validateCreateUpdateEventRecipientRequest(EventRecipientRequest request)
			throws PreConditionFailedException, PreConditionRequiredException {
		if (request == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		}
		return true; 
	}
	private boolean validateUpdateDeleteProblemTypeRequest(Long eventGuid) throws PreConditionFailedException {
		if (eventGuid == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		}
		return true;
	}
}
