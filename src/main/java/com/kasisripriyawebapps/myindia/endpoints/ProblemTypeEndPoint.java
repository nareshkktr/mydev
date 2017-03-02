package com.kasisripriyawebapps.myindia.endpoints;

import java.util.List;

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

import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.entity.ProblemType;
import com.kasisripriyawebapps.myindia.exception.ConflictException;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.PreConditionFailedException;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateDeleteProblemTypeRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.SaveOrUpdateDeleteObjectResponse;
import com.kasisripriyawebapps.myindia.service.ProblemTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(value = EndPointConstants.PROBLEM_TYPE_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.PROBLEM_TYPE_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.PROBLEM_TYPE_ENDPOINT_API_TAGS }, description = EndPointConstants.PROBLEM_TYPE_ENDPOINT_API_DESCRIPTION)
public class ProblemTypeEndPoint {

	@Autowired
	ProblemTypeService problemTypeService;

	@POST
	@ApiOperation(value = EndPointConstants.CREATE_PROBLEM_TYPE_API_VALUE, nickname = EndPointConstants.CREATE_PROBLEM_TYPE_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.CREATE_PROBLEM_TYPE_API_DESCRIPTION)
	@Path(EndPointConstants.CREATE_PROBLEM_TYPE_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProblemType(final CreateUpdateDeleteProblemTypeRequest createUpdateDeleteProblemTypeRequest)
			throws InternalServerException, PreConditionFailedException, PreConditionRequiredException,
			ConflictException {
		Long accountId = null;
		if (validateCreateUpdateProblemTypeRequest(createUpdateDeleteProblemTypeRequest)) {
			accountId = problemTypeService.createProblemType(createUpdateDeleteProblemTypeRequest);
		}
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(accountId);
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}

	@PUT
	@ApiOperation(value = EndPointConstants.UPDATE_PROBLEM_TYPE_API_VALUE, nickname = EndPointConstants.UPDATE_PROBLEM_TYPE_API_NICKNAME, httpMethod = EndPointConstants.HTTP_PUT, notes = EndPointConstants.UPDATE_PROBLEM_TYPE_API_DESCRIPTION)
	@Path(EndPointConstants.UPDATE_PROBLEM_TYPE_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProblemType(final CreateUpdateDeleteProblemTypeRequest createUpdateDeleteProblemTypeRequest)
			throws InternalServerException, PreConditionFailedException, PreConditionRequiredException,
			ConflictException, RecordNotFoundException {
		Long accountId = null;
		if (validateCreateUpdateProblemTypeRequest(createUpdateDeleteProblemTypeRequest)
				&& validateUpdateDeleteProblemTypeRequest(createUpdateDeleteProblemTypeRequest)) {
			accountId = problemTypeService.updateProblemType(createUpdateDeleteProblemTypeRequest);
		}
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(accountId);
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}

	@DELETE
	@ApiOperation(value = EndPointConstants.DELETE_PROBLEM_TYPE_API_VALUE, nickname = EndPointConstants.DELETE_PROBLEM_TYPE_API_NICKNAME, httpMethod = EndPointConstants.HTTP_DELETE, notes = EndPointConstants.DELETE_PROBLEM_TYPE_API_DESCRIPTION)
	@Path(EndPointConstants.DELETE_PROBLEM_TYPE_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUserType(final CreateUpdateDeleteProblemTypeRequest createUpdateDeleteProblemTypeRequest)
			throws InternalServerException, PreConditionFailedException, PreConditionRequiredException,
			RecordNotFoundException {
		Long accountId = null;
		if (validateUpdateDeleteProblemTypeRequest(createUpdateDeleteProblemTypeRequest)) {
			accountId = problemTypeService.deleteProblemType(createUpdateDeleteProblemTypeRequest.getProblemTypeId());
		}
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(accountId);
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}

	@GET
	@ApiOperation(value = EndPointConstants.GET_PROBLEM_TYPES_API_VALUE, nickname = EndPointConstants.GET_PROBLEM_TYPES_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_PROBLEM_TYPES_API_DESCRIPTION)
	@Path(EndPointConstants.GET_PROBLEM_TYPES_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProblemTypes(@PathParam("offset") final Integer offset, @PathParam("limit") final Integer limit)
			throws InternalServerException {
		List<ProblemType> problemTypes = null;
		problemTypes = problemTypeService.getAllProblemTypes(offset, limit);
		return Response.status(Status.OK).entity(problemTypes).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.IMPORT_ALL_PROBLEM_TYPE_API_VALUE, nickname = EndPointConstants.IMPORT_ALL_PROBLEM_TYPE_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.IMPORT_ALL_PROBLEM_TYPE_API_DESCRIPTION)
	@Path(EndPointConstants.IMPORT_ALL_PROBLEM_TYPE_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response importAllProblemTypes() throws InternalServerException {
		problemTypeService.importAllProblemTypes();
		return Response.status(Status.OK).entity(null).build();
	}

	@GET
	@ApiOperation(value = EndPointConstants.GET_ALL_PROBLEM_TYPES_API_VALUE, nickname = EndPointConstants.GET_ALL_PROBLEM_TYPES_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_ALL_PROBLEM_TYPES_API_DESCRIPTION)
	@Path(EndPointConstants.GET_ALL_PROBLEM_TYPES_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProblemTypes() throws InternalServerException {
		List<ProblemType> problemTypes = null;
		problemTypes = problemTypeService.getAllProblemTypes();
		return Response.status(Status.OK).entity(problemTypes).build();
	}

	private boolean validateCreateUpdateProblemTypeRequest(
			CreateUpdateDeleteProblemTypeRequest createUpdateDeleteProblemTypeRequest)
			throws PreConditionFailedException, PreConditionRequiredException {
		if (createUpdateDeleteProblemTypeRequest == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		} else if (createUpdateDeleteProblemTypeRequest.getProblemTypeName() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.PROBLEM_TYPE_REQUIRED);
		} else if (createUpdateDeleteProblemTypeRequest.getProblemTypePhoto() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.PROBLEM_TYPE_IMAGE_REQUIRED);
		} else if (createUpdateDeleteProblemTypeRequest.getProblemTypeName().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.PROBLEM_TYPE_SHOULD_NOT_BE_EMPTY);
		} else if (createUpdateDeleteProblemTypeRequest.getProblemTypePhoto().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.PROBLEM_TYPE_IMAGE_SHOULD_NOT_BE_EMPTY);
		}
		return true;
	}

	private boolean validateUpdateDeleteProblemTypeRequest(
			CreateUpdateDeleteProblemTypeRequest createUpdateDeleteProblemTypeRequest)
			throws PreConditionFailedException, PreConditionRequiredException {
		if (createUpdateDeleteProblemTypeRequest == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		} else if (createUpdateDeleteProblemTypeRequest.getProblemTypeId() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.PROBLEM_TYPE_REQUIRED);
		}
		return true;
	}
}
