/*
 * 
 */
package com.kasisripriyawebapps.myindia.endpoints;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.PreConditionFailedException;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GetUserByPropertyRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GetUserByPropertyResponse;
import com.kasisripriyawebapps.myindia.service.UserService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(value = EndPointConstants.USER_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.USER_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.USER_ENDPOINT_API_TAGS }, description = EndPointConstants.USER_ENDPOINT_API_DESCRIPTION)
public class UserEndPoint {

	@Autowired
	UserService userService;

	@POST
	@ApiOperation(value = EndPointConstants.GET_USER_BY_VOTER_ID_NAME_API_VALUE, nickname = EndPointConstants.GET_USER_BY_VOTER_ID_NAME_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.GET_USER_BY_VOTER_ID_NAME_API_DESCRIPTION)
	@Path(EndPointConstants.GET_USER_BY_VOTER_ID_NAME_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByVoterIdName(
			final GetUserByPropertyRequest getUserByPropertyRequest) throws InternalServerException,
			PreConditionFailedException, PreConditionRequiredException, RecordNotFoundException {
		GetUserByPropertyResponse saveObjResponse = null;
		if (validateGetUserByVoterIdName(getUserByPropertyRequest)) {
			saveObjResponse = userService.getUserByVoterIdName(getUserByPropertyRequest);
		}
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.GET_USER_BY_VOTER_ID_NAME_REFERENCE_API_VALUE, nickname = EndPointConstants.GET_USER_BY_VOTER_ID_NAME_REFERENCE_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.GET_USER_BY_VOTER_ID_NAME_REFERENCE_API_DESCRIPTION)
	@Path(EndPointConstants.GET_USER_BY_VOTER_ID_NAME_REFERENCE_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByVoterIdNameAndReference(
			final GetUserByPropertyRequest getUserByPropertyRequest) throws InternalServerException,
			PreConditionFailedException, PreConditionRequiredException, RecordNotFoundException {
		GetUserByPropertyResponse saveObjResponse = null;
		if (validateGetUserByVoterIdName(getUserByPropertyRequest)
				&& validateGetUserByVoterIdNameReference(getUserByPropertyRequest)) {
			saveObjResponse = userService.getUserByVoterIdNameAndReference(getUserByPropertyRequest);
		}
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}

	private boolean validateGetUserByVoterIdName(GetUserByPropertyRequest getUserByPropertyRequest)
			throws PreConditionFailedException, PreConditionRequiredException {
		if (getUserByPropertyRequest == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		} else if (getUserByPropertyRequest.getIdCardType() == null) {
			throw new PreConditionFailedException(ExceptionConstants.IDENTITY_CARD_TYPE_REQUIRED);
		} else if (getUserByPropertyRequest.getIdCardNo() == null) {
			throw new PreConditionFailedException(ExceptionConstants.IDENTITY_CARD_NO_REQUIRED);
		} else if (getUserByPropertyRequest.getUserName() == null) {
			throw new PreConditionFailedException(ExceptionConstants.NAME_REQUIRED);
		} else if (getUserByPropertyRequest.getIdCardType().isEmpty()) {
			throw new PreConditionRequiredException(ExceptionConstants.IDENTITY_CARD_TYPE_NOT_EMPTY);
		} else if (getUserByPropertyRequest.getIdCardNo().isEmpty()) {
			throw new PreConditionRequiredException(ExceptionConstants.IDENTITY_CARD_NO_NOT_EMPTY);
		} else if (getUserByPropertyRequest.getUserName().isEmpty()) {
			throw new PreConditionRequiredException(ExceptionConstants.NAME_NOT_EMPTY);
		} else if (!CommonUtil.isValueExistInList(getUserByPropertyRequest.getIdCardType(), CommonUtil.idCardTypes)) {
			throw new PreConditionFailedException(ExceptionConstants.IDENTITY_CARD_TYPE_NOT_VALID);
		}
		return true;
	}

	private boolean validateGetUserByVoterIdNameReference(GetUserByPropertyRequest getUserByPropertyRequest)
			throws PreConditionFailedException, PreConditionRequiredException {
		if (getUserByPropertyRequest.getReferenceType() == null) {
			throw new PreConditionFailedException(ExceptionConstants.REFERENCCE_TYPE_REQUIRED);
		} else if (getUserByPropertyRequest.getReferenceName() == null) {
			throw new PreConditionFailedException(ExceptionConstants.REFERENCE_NAME_REQUIRED);
		} else if (getUserByPropertyRequest.getReferenceType().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.REFERENCCE_TYPE_SHOULD_NOT_BE_EMPTY);
		} else if (getUserByPropertyRequest.getReferenceName().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.REFERENCE_NAME_SHOULD_NOT_BE_EMPTY);
		}
		return true;
	}
}
