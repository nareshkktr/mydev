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
import com.kasisripriyawebapps.myindia.service.PartyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * The Class PartyEndpoint.
 */
@Path(value = EndPointConstants.PARTY_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.PARTY_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.PARTY_ENDPOINT_API_TAGS }, description = EndPointConstants.PARTY_ENDPOINT_API_DESCRIPTION)
public class PartyEndpoint {

	/** The party service. */
	@Autowired
	PartyService partyService;

	@GET
	@ApiOperation(value = EndPointConstants.GET_ALL_PARTIES_API_VALUE, nickname = EndPointConstants.GET_ALL_PARTIES_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_ALL_PARTIES_API_DESCRIPTION)
	@Path(EndPointConstants.GET_ALL_PARTIES_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllParties() throws InternalServerException {
		return Response.status(Status.OK).entity(null).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_PARTIES_API_VALUE, nickname = EndPointConstants.IMPORT_PARTIES_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.IMPORT_PARTIES_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_PARTIES_REQUEST_MAPPING)
	public Response importParties() throws InternalServerException {
		partyService.importParties();
		return Response.status(Status.OK).entity(null).build();
	}
}
