/*
 * 
 */
package com.kasisripriyawebapps.myindia.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.PreConditionFailedException;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateProblemRequest;
import com.kasisripriyawebapps.myindia.service.ProblemService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

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
	
	@POST
	@ApiOperation(value = EndPointConstants.CREATE_PROBLEM_API_VALUE, nickname = EndPointConstants.CREATE_PROBLEM_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.CREATE_PROBLEM_API_DESCRIPTION)
	@Path(EndPointConstants.CREATE_PROBLEM_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProblem(CreateProblemRequest problem) throws InternalServerException, RecordNotFoundException,
	PreConditionFailedException, PreConditionRequiredException {
		
		Long problemGuid= null;
		
		//Load logged in user details
		BaseEndPoint bp = new BaseEndPoint();
		
		
		if (validateCreateProblemRequest(problem)) {
			problemGuid = problemService.create(problem,bp.getLoggedInUserDetails());
		}
		return Response.status(Status.OK).entity(problemGuid).build();
	}

	private boolean validateCreateProblemRequest(CreateProblemRequest problem) throws PreConditionFailedException, PreConditionRequiredException {
		// TODO Auto-generated method stub
		if (problem == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		} else if (problem.getProblemShortDescription() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.PROBLEM_DESCRIPTION_REQUIRED);
		} else if (problem.getCreatedLocation() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.PROBLEM_LOCATION_REQUIRED);
		} else if (problem.getProblemType()== null) {
			throw new PreConditionRequiredException(ExceptionConstants.PROBLEM_TYPE_REQUIRED);
		} else if (problem.getAmountInvolved() == null && problem.getNoOfAffectedPeople() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.PROBLEM_IMPACT_REQUIRED);
		} else if (problem.getProblemShortDescription().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.PROBLEM_DESCRIPTION_NOT_EMPTY);
		} 
		return true;
	}
}
