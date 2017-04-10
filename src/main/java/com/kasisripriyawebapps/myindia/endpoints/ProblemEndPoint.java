/*
 * 
 */
package com.kasisripriyawebapps.myindia.endpoints;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
import com.kasisripriyawebapps.myindia.requestresponsemodel.BaseUserInformation;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateProblemRequestData;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ProblemResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.SaveOrUpdateDeleteObjectResponse;
import com.kasisripriyawebapps.myindia.service.ProblemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * The Class ProblemEndPoint.
 */
@Path(value = EndPointConstants.PROBLEM_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.PROBLEM_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.PROBLEM_ENDPOINT_API_TAGS }, description = EndPointConstants.PROBLEM_ENDPOINT_API_DESCRIPTION)
public class ProblemEndPoint extends BaseEndPoint {

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
			problemGuid = problemService.createProblem(createUpdateProblemRequestData, loggedInUserDetails);
		}
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(problemGuid);
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}
	
	@GET
	@ApiOperation(value = EndPointConstants.GET_PROBLEM_BY_ID_API_VALUE, nickname = EndPointConstants.GET_PROBLEM_BY_ID_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_PROBLEM_BY_ID_API_DESCRIPTION)
	@Path(EndPointConstants.GET_PROBLEM_BY_ID_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProblemByGuid(@QueryParam("problemGuid") Long problemGuid)
			throws InternalServerException, PreConditionRequiredException,
			ConflictException, RecordNotFoundException {

		ProblemResponse problem = null;
		
		if (problemGuid != null) {	
			problem = problemService.retreiveProblem(problemGuid);
		}else{
			throw new PreConditionRequiredException(ExceptionConstants.REQUEST_NOT_NULL);
		}
		
		return Response.status(Status.OK).entity(problem).build();
	}
	
	@GET
	@ApiOperation(value = EndPointConstants.GET_PROBLEMS_BY_TYPE_API_VALUE, nickname = EndPointConstants.GET_PROBLEMS_BY_TYPE_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_PROBLEMS_BY_TYPE_API_DESCRIPTION)
	@Path(EndPointConstants.GET_PROBLEMS_BY_TYPE_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProblemsByProblemType(@QueryParam("problemTypeGuid") Long problemTypeGuid)
			throws InternalServerException, PreConditionRequiredException,
			ConflictException, RecordNotFoundException {
		
		LoggedInUserDetails loggedInUserDetails = getLoggedInUserDetails();
		List<ProblemResponse> problems = null;
		
		if (problemTypeGuid != null) {
			problems = problemService.retreiveProblemsByType(problemTypeGuid, loggedInUserDetails);
		}else{
			throw new PreConditionRequiredException(ExceptionConstants.REQUEST_NOT_NULL);
		}
		
		return Response.status(Status.OK).entity(problems).build();
	}
	
	@GET
	@ApiOperation(value = EndPointConstants.GET_PROBLEMS_BY_PROBLEM_CATEGORY_API_VALUE, nickname = EndPointConstants.GET_PROBLEMS_BY_PROBLEM_CATEGORY_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_PROBLEMS_BY_PROBLEM_CATEGORY_API_DESCRIPTION)
	@Path(EndPointConstants.GET_PROBLEMS_BY_PROBLEM_CATEGORY_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProblemsByProblemCategory(@QueryParam("problemTypeCategory") String problemTypeCategory)
			throws InternalServerException, PreConditionRequiredException,
			ConflictException, RecordNotFoundException {
		
		LoggedInUserDetails loggedInUserDetails = getLoggedInUserDetails();
		List<ProblemResponse> problems = null;
		
		if (problemTypeCategory != null) {
			problems = problemService.retreiveProblemsByTypeCategory(problemTypeCategory, loggedInUserDetails);
		}else{
			throw new PreConditionRequiredException(ExceptionConstants.REQUEST_NOT_NULL);
		}
		
		return Response.status(Status.OK).entity(problems).build();
	}
	
	@GET
	@ApiOperation(value = EndPointConstants.GET_PROBLEM_CONTRIBUTORS_BY_PROBLEM_ID_API_VALUE, nickname = EndPointConstants.GET_PROBLEM_CONTRIBUTORS_BY_PROBLEM_ID_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_PROBLEM_CONTRIBUTORS_BY_PROBLEM_ID_API_DESCRIPTION)
	@Path(EndPointConstants.GET_PROBLEM_CONTRIBUTORS_BY_PROBLEM_ID_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProblemContributorsByProblemGuid(@QueryParam("problemGuid") Long problemGuid)
			throws InternalServerException, PreConditionRequiredException,
			ConflictException, RecordNotFoundException {

		List<BaseUserInformation> contributors = null;
		
		if (problemGuid != null) {
			contributors = problemService.retreiveProblemContributorsByGuid(problemGuid);
		}else{
			throw new PreConditionRequiredException(ExceptionConstants.REQUEST_NOT_NULL);
		}
		
		return Response.status(Status.OK).entity(contributors).build();
	}

	private boolean validateCreateUpdateProblemRequest(CreateUpdateProblemRequestData createUpdateProblemRequestData)
			throws PreConditionFailedException, PreConditionRequiredException {
		if (createUpdateProblemRequestData == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		} else if (createUpdateProblemRequestData.getProblemName() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.PROBLEM_NAME_REQUIRED);
		} else if (createUpdateProblemRequestData.getProblemDesc() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.PROBLEM_DESCRIPTION_REQUIRED);
		} else if (createUpdateProblemRequestData.getProblemName().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.PROBLEM_NAME_SHOULD_NOT_BE_EMPTY);
		} else if (createUpdateProblemRequestData.getProblemDesc().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.PROBLEM_DESCRIPTION_SHOULD_NOT_BE_EMPTY);
		} else if (createUpdateProblemRequestData.getProblemType() == null
				|| createUpdateProblemRequestData.getProblemType().getGuid() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.PROBLEM_TYPE_REQUIRED);
		} else if (createUpdateProblemRequestData.getProblemLocation() == null
				|| createUpdateProblemRequestData.getProblemLocation().getLocationGuid() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.PROBLEM_LOCATION_REQUIRED);
		}
		return true;
	}
}
