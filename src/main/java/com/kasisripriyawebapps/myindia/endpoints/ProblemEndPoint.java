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
import com.kasisripriyawebapps.myindia.service.ProblemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * The Class ProblemEndPoint.
 */
@Path(value = EndPointConstants.POLITICIAN_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.POLITICIAN_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.POLITICIAN_ENDPOINT_API_TAGS }, description = EndPointConstants.PARTY_ENDPOINT_API_DESCRIPTION)
public class ProblemEndPoint {


	@Autowired
	ProblemService problemService;

	@GET
	@ApiOperation(value = EndPointConstants.GET_ALL_PROBLEMS_API_VALUE, nickname = EndPointConstants.GET_ALL_PROBLEMS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_ALL_PROBLEMS_API_DESCRIPTION)
	@Path(EndPointConstants.GET_ALL_PROBLEMS_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProblems() throws InternalServerException {
		return Response.status(Status.OK).entity(null).build();
	}
}
