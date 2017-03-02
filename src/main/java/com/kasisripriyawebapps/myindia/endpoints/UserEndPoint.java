/*
 * 
 */
package com.kasisripriyawebapps.myindia.endpoints;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.PreConditionFailedException;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GetUserByPropertyRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GetUserByPropertyResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.LocationReferenceMasterResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.UserLocationDetails;
import com.kasisripriyawebapps.myindia.service.UserService;
import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(value = EndPointConstants.USER_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.USER_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.USER_ENDPOINT_API_TAGS }, description = EndPointConstants.USER_ENDPOINT_API_DESCRIPTION)
public class UserEndPoint extends BaseEndPoint {

	@Autowired
	UserService userService;

	private @Autowired HttpServletRequest servletRequest;

	@POST
	@ApiOperation(value = EndPointConstants.GET_USER_BY_VOTER_CARD_DETAILS_API_VALUE, nickname = EndPointConstants.GET_USER_BY_VOTER_CARD_DETAILS_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.GET_USER_BY_VOTER_CARD_DETAILS_API_DESCRIPTION)
	@Path(EndPointConstants.GET_USER_BY_VOTER_CARD_DETAILS_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByVoterCardDetails(final GetUserByPropertyRequest getUserByPropertyRequest)
			throws InternalServerException, PreConditionFailedException, PreConditionRequiredException,
			RecordNotFoundException {
		GetUserByPropertyResponse saveObjResponse = null;
		if (validateGetUserByVoterCardDetails(getUserByPropertyRequest)) {
			saveObjResponse = userService.getUserByVoterCardDetails(getUserByPropertyRequest);
		}
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.GET_USER_BY_VOTER_ID_NAME_API_VALUE, nickname = EndPointConstants.GET_USER_BY_VOTER_ID_NAME_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.GET_USER_BY_VOTER_ID_NAME_API_DESCRIPTION)
	@Path(EndPointConstants.GET_USER_BY_VOTER_ID_NAME_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByVoterIdAndName(final GetUserByPropertyRequest getUserByPropertyRequest)
			throws InternalServerException, PreConditionFailedException, PreConditionRequiredException,
			RecordNotFoundException {
		GetUserByPropertyResponse saveObjResponse = null;
		if (validateGetUserByVoterIdName(getUserByPropertyRequest)) {
			saveObjResponse = userService.getUserByVoterIdAndName(getUserByPropertyRequest);
		}
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.GET_USER_BY_VOTER_ID_NAME_REFERENCE_API_VALUE, nickname = EndPointConstants.GET_USER_BY_VOTER_ID_NAME_REFERENCE_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.GET_USER_BY_VOTER_ID_NAME_REFERENCE_API_DESCRIPTION)
	@Path(EndPointConstants.GET_USER_BY_VOTER_ID_NAME_REFERENCE_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByVoterReferenceAndAge(final GetUserByPropertyRequest getUserByPropertyRequest)
			throws InternalServerException, PreConditionFailedException, PreConditionRequiredException,
			RecordNotFoundException {
		GetUserByPropertyResponse saveObjResponse = null;
		if (validateGetUserByVoterIdNameReference(getUserByPropertyRequest)) {
			saveObjResponse = userService.getUserByVoterReferenceAndAge(getUserByPropertyRequest);
		}
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.GET_REFERENCE_LOCATIONS_API_VALUE, nickname = EndPointConstants.GET_REFERENCE_LOCATIONS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.GET_REFERENCE_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.GET_REFERENCE_LOCATIONS_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReferenceLocationForMaster(final SolrLocationMaster solrLocationMaster)
			throws InternalServerException, PreConditionFailedException, PreConditionRequiredException,
			RecordNotFoundException {
		LocationReferenceMasterResponse saveObjResponse = null;
		if (validateGetReferenceLocationForMaster(solrLocationMaster)) {
			saveObjResponse = userService.getReferenceLocationForMaster(solrLocationMaster);
		}
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}

	@GET
	@ApiOperation(value = EndPointConstants.GET_LOGGED_IN_USER_LOCATION_DETAILS_API_VALUE, nickname = EndPointConstants.GET_LOGGED_IN_USER_LOCATION_DETAILS_DETAILS_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_LOGGED_IN_USER_LOCATION_DETAILS_DETAILS_API_DESCRIPTION)
	@Path(EndPointConstants.GET_LOGGED_IN_USER_LOCATION_DETAILS_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLoggedInUserLocation() throws InternalServerException, RecordNotFoundException {
		LoggedInUserDetails loggedInUserDetails = getLoggedInUserDetails();
		UserLocationDetails userLocationDetails = userService.getLoggedInUserLocation(loggedInUserDetails.getGuid());
		HttpSession session = servletRequest.getSession(true);
		session.setAttribute("userLocationDetails", userLocationDetails);
		return Response.status(Status.OK).entity(userLocationDetails).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.PIN_LOCATION_API_VALUE, nickname = EndPointConstants.PIN_LOCATION_DETAILS_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.PIN_LOCATION_DETAILS_API_DESCRIPTION)
	@Path(EndPointConstants.PIN_LOCATION_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response pinLocation(final SolrLocationMaster solrLocationMaster) {
		UserLocationDetails userLocationDetails = new UserLocationDetails();
		userLocationDetails.setLocationGuid(solrLocationMaster.getLocationGuid());
		userLocationDetails.setLocationName(solrLocationMaster.getLocationName());
		HttpSession session = servletRequest.getSession(true);
		session.setAttribute("userLocationDetails", userLocationDetails);
		return Response.status(Status.OK).entity(solrLocationMaster).build();
	}

	private boolean validateGetUserByVoterCardDetails(GetUserByPropertyRequest getUserByPropertyRequest)
			throws PreConditionFailedException, PreConditionRequiredException {

		if (getUserByPropertyRequest.getUserName() == null) {
			throw new PreConditionFailedException(ExceptionConstants.NAME_REQUIRED);
		} else if (getUserByPropertyRequest.getUserName().isEmpty()) {
			throw new PreConditionRequiredException(ExceptionConstants.NAME_NOT_EMPTY);
		} else if (getUserByPropertyRequest.getIdCardNo() == null) {
			throw new PreConditionFailedException(ExceptionConstants.IDENTITY_CARD_NO_REQUIRED);
		} else if (getUserByPropertyRequest.getIdCardNo().isEmpty()) {
			throw new PreConditionRequiredException(ExceptionConstants.IDENTITY_CARD_NO_NOT_EMPTY);
		} else if (getUserByPropertyRequest.getReferenceName() == null) {
			throw new PreConditionFailedException(ExceptionConstants.REFERENCE_NAME_REQUIRED);
		} else if (getUserByPropertyRequest.getYearOfBirth() == null) {
			throw new PreConditionFailedException(ExceptionConstants.YEAR_OF_BIRTH_REQUIRED);
		} else if (getUserByPropertyRequest.getReferenceName().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.REFERENCE_NAME_SHOULD_NOT_BE_EMPTY);
		} else if (getUserByPropertyRequest.getYearOfBirth().equals(0)) {
			throw new PreConditionFailedException(ExceptionConstants.YEAR_OF_BIRTH_SHOULD_NOT_BE_EMPTY);
		} else if (getUserByPropertyRequest.getGender() == null) {
			throw new PreConditionFailedException(ExceptionConstants.GENDER_REQUIRED);
		} else if (getUserByPropertyRequest.getGender().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.GENDER_SHOULD_NOT_BE_EMPTY);
		}

		return true;
	}

	private boolean validateGetReferenceLocationForMaster(SolrLocationMaster solrLocationMaster)
			throws PreConditionFailedException, PreConditionRequiredException {
		if (solrLocationMaster == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		} else if (solrLocationMaster.getLocationGuid() == null) {
			throw new PreConditionFailedException(ExceptionConstants.LOCATION_GUID_REQUIRED);
		} else if (solrLocationMaster.getLocationType() == null) {
			throw new PreConditionFailedException(ExceptionConstants.LOCATION_TYPE_REQUIRED);
		} else if (solrLocationMaster.getLocationGuid().equals(0)) {
			throw new PreConditionRequiredException(ExceptionConstants.LOCATION_GUID_NOT_EMPTY);
		} else if (solrLocationMaster.getLocationType().isEmpty()) {
			throw new PreConditionRequiredException(ExceptionConstants.LOCATION_TYPE_NOT_EMPTY);
		}
		return true;
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
		if (getUserByPropertyRequest == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		} else if (getUserByPropertyRequest.getReferenceType() == null) {
			throw new PreConditionFailedException(ExceptionConstants.REFERENCCE_TYPE_REQUIRED);
		} else if (getUserByPropertyRequest.getReferenceName() == null) {
			throw new PreConditionFailedException(ExceptionConstants.REFERENCE_NAME_REQUIRED);
		} else if (getUserByPropertyRequest.getYearOfBirth() == null) {
			throw new PreConditionFailedException(ExceptionConstants.YEAR_OF_BIRTH_REQUIRED);
		} else if (getUserByPropertyRequest.getReferenceType().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.REFERENCCE_TYPE_SHOULD_NOT_BE_EMPTY);
		} else if (getUserByPropertyRequest.getReferenceName().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.REFERENCE_NAME_SHOULD_NOT_BE_EMPTY);
		} else if (getUserByPropertyRequest.getYearOfBirth().equals(0)) {
			throw new PreConditionFailedException(ExceptionConstants.YEAR_OF_BIRTH_SHOULD_NOT_BE_EMPTY);
		}
		return true;
	}
}
