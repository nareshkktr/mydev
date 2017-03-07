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
import com.kasisripriyawebapps.myindia.exception.ConflictException;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.PreConditionFailedException;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateProblemRequestData;
import com.kasisripriyawebapps.myindia.requestresponsemodel.SaveOrUpdateDeleteObjectResponse;
import com.kasisripriyawebapps.myindia.service.ProblemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * The Class ProblemEndPoint.
 */
@Path(value = EndPointConstants.POLITICIAN_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.POLITICIAN_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.POLITICIAN_ENDPOINT_API_TAGS }, description = EndPointConstants.PARTY_ENDPOINT_API_DESCRIPTION)
public class ProblemEndPoint extends BaseEndPoint{

	@Autowired
	ProblemService problemService;

	@GET
	@ApiOperation(value = EndPointConstants.GET_ALL_PROBLEMS_API_VALUE, nickname = EndPointConstants.GET_ALL_PROBLEMS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_ALL_PROBLEMS_API_DESCRIPTION)
	@Path(EndPointConstants.GET_ALL_PROBLEMS_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProblems() throws InternalServerException {
		return Response.status(Status.OK).entity(null).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.CREATE_PROBLEM_API_VALUE, nickname = EndPointConstants.CREATE_PROBLEM_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.CREATE_PROBLEM_API_DESCRIPTION)
	@Path(EndPointConstants.CREATE_PROBLEM_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProblem(final CreateUpdateProblemRequestData createUpdateProblemRequestData)
			throws InternalServerException, PreConditionFailedException, PreConditionRequiredException,
			ConflictException {
		Long problemGuid = null;
		LoggedInUserDetails loggedInUserDetails = getLoggedInUserDetails();
		
		if (validateCreateUpdateProblemRequest(createUpdateProblemRequestData)) {
			problemGuid = problemService.createProblem(createUpdateProblemRequestData,loggedInUserDetails);
		}
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(problemGuid);
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}

	private boolean validateCreateUpdateProblemRequest(CreateUpdateProblemRequestData createUpdateProblemRequestData) {
		// TODO Auto-generated method stub
		return false;
	}
}
