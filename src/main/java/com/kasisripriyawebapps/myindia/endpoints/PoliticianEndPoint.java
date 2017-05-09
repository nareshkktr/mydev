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
import com.kasisripriyawebapps.myindia.requestresponsemodel.PoliticianRequest;
import com.kasisripriyawebapps.myindia.service.PoliticianService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * The Class PoliticianEndPoint.
 */
@Path(value = EndPointConstants.POLITICIAN_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.POLITICIAN_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.POLITICIAN_ENDPOINT_API_TAGS }, description = EndPointConstants.PARTY_ENDPOINT_API_DESCRIPTION)
public class PoliticianEndPoint {

	/** The politician service. */
	@Autowired
	PoliticianService politicianService;

	@GET
	@ApiOperation(value = EndPointConstants.GET_ALL_POLITICIANS_API_VALUE, nickname = EndPointConstants.GET_ALL_POLITICIANS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_ALL_POLITICIANS_API_DESCRIPTION)
	@Path(EndPointConstants.GET_ALL_POLITICIANS_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPoliticians() throws InternalServerException {
		return Response.status(Status.OK).entity(null).build();
	}
	
	@POST
	@ApiOperation(value = EndPointConstants.DEACTIVATE_ALL_POLITICIANS_API_VALUE, nickname = EndPointConstants.DEACTIVATE_ALL_POLITICIANS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.DEACTIVATE_ALL_POLITICIANS_API_DESCRIPTION)
	@Path(EndPointConstants.DEACTIVATE_ALL_POLITICIANS_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deactivateAllPoliticians(PoliticianRequest politicianRequest) throws InternalServerException {
		
		politicianService.deactivatePoliticians(politicianRequest);
		
		return Response.status(Status.OK).entity(null).build();
	}
}
