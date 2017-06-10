package com.kasisripriyawebapps.myindia.endpoints;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.entity.Account;
import com.kasisripriyawebapps.myindia.exception.ConflictException;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.PreConditionFailedException;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.BaseUserInformation;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateAccountRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.LocationReferenceMasterResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.PartyResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ValidateElectorDetailsRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ValidateElectorDetailsResponse;
import com.kasisripriyawebapps.myindia.service.AccountService;
import com.kasisripriyawebapps.myindia.service.LocationService;
import com.kasisripriyawebapps.myindia.service.PartyService;
import com.kasisripriyawebapps.myindia.service.SignUpService;
import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;
import com.kasisripriyawebapps.myindia.solr.entity.SolrPoliticianAuthorityMaster;
import com.kasisripriyawebapps.myindia.solr.entity.SolrPoliticianMaster;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(value = EndPointConstants.SIGNUP_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.SIGNUP_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.SIGNUP_ENDPOINT_API_TAGS }, description = EndPointConstants.SIGNUP_ENDPOINT_API_DESCRIPTION)
public class SignUpEndPoint {

	@Autowired
	SignUpService signUpService;

	@Autowired
	PartyService partyService;

	@Autowired
	LocationService locationService;

	@Autowired
	AccountService accountService;

	@POST
	@ApiOperation(value = EndPointConstants.VALIDATE_ELECTOR_DETAILS_API_VALUE, nickname = EndPointConstants.VALIDATE_ELECTOR_DETAILS_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.VALIDATE_ELECTOR_DETAILS_API_DESCRIPTION)
	@Path(EndPointConstants.VALIDATE_ELECTOR_DETAILS_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response validateElectorDetails(final ValidateElectorDetailsRequest validateElectorDetailsRequest)
			throws InternalServerException, PreConditionFailedException, PreConditionRequiredException,
			RecordNotFoundException {
		ValidateElectorDetailsResponse validateElectorDetailsResponse = null;
		if (validateElectorDetailsRequest(validateElectorDetailsRequest)) {
			validateElectorDetailsResponse = signUpService.validateElectorDetails(validateElectorDetailsRequest);
		}
		return Response.status(Status.OK).entity(validateElectorDetailsResponse).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.VALIDATE_LOCATION_FOR_CONFLICT_API_VALUE, nickname = EndPointConstants.VALIDATE_LOCATION_FOR_CONFLICT_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.VALIDATE_LOCATION_FOR_CONFLICT_API_DESCRIPTION)
	@Path(EndPointConstants.VALIDATE_LOCATION_FOR_CONFLICT_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response validateLocationForConflict(final SolrLocationMaster solrLocationMaster)
			throws InternalServerException, PreConditionFailedException, PreConditionRequiredException,
			RecordNotFoundException {
		LocationReferenceMasterResponse saveObjResponse = null;
		if (validateLocationForConflictRequest(solrLocationMaster)) {
			saveObjResponse = signUpService.getReferenceLocationForMaster(solrLocationMaster);
		}
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}

	@GET
	@ApiOperation(value = EndPointConstants.GET_ALL_PARTIES_API_VALUE, nickname = EndPointConstants.GET_ALL_PARTIES_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_ALL_PARTIES_API_DESCRIPTION)
	@Path(EndPointConstants.GET_ALL_PARTIES_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllParties() throws InternalServerException, RecordNotFoundException {
		List<PartyResponse> partiesList = partyService.getAllParties();
		return Response.status(Status.OK).entity(partiesList).build();
	}

	@GET
	@ApiOperation(value = EndPointConstants.GET_POLITICIANS_BY_NAME_API_VALUE, nickname = EndPointConstants.GET_POLITICIANS_BY_NAME_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_POLITICIANS_BY_NAME_API_DESCRIPTION)
	@Path(EndPointConstants.GET_POLITICIANS_BY_NAME_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPoliticiansByName(@QueryParam("userGuid") Long userGuid)
			throws InternalServerException, RecordNotFoundException {
		List<SolrPoliticianMaster> politicians = signUpService.getPoliticiansByName(userGuid);
		return Response.status(Status.OK).entity(politicians).build();

	}

	@POST
	@ApiOperation(value = EndPointConstants.VALIDATE_POLITICIAN_BY_LOCATION_PARTY_API_VALUE, nickname = EndPointConstants.VALIDATE_POLITICIAN_BY_LOCATION_PARTY_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.VALIDATE_POLITICIAN_BY_LOCATION_PARTY_API_DESCRIPTION)
	@Path(EndPointConstants.VALIDATE_POLITICIAN_BY_LOCATION_PARTY_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response validatePoliticianSelection(final SolrPoliticianAuthorityMaster solrPoliticianAuthorityMaster)
			throws RecordNotFoundException, InternalServerException {
		signUpService.validatePoliticianSelection(solrPoliticianAuthorityMaster);
		return Response.status(Status.OK).entity(solrPoliticianAuthorityMaster).build();
	}

	@GET
	@ApiOperation(value = EndPointConstants.GET_SEARCH_RESULTS_BY_LOCATION_NAME_API_VALUE, nickname = EndPointConstants.GET_SEARCH_RESULTS_BY_LOCATION_NAME_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_SEARCH_RESULTS_BY_LOCATION_NAME_API_DESCRIPTION)
	@Path(EndPointConstants.GET_SEARCH_RESULTS_BY_LOCATION_NAME_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSearchResultsByLocationName(@QueryParam("searchTerm") String searchTerm)
			throws InternalServerException {
		List<SolrLocationMaster> searchResults = locationService.getSearchResultsByLocationName(searchTerm);
		return Response.status(Status.OK).entity(searchResults).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.CREATE_ACCOUNT_API_VALUE, nickname = EndPointConstants.CREATE_ACCOUNT_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.CREATE_ACCOUNT_API_DESCRIPTION)
	@Path(EndPointConstants.CREATE_ACCOUNT_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createAccount(CreateAccountRequest createAccountRequest) throws PreConditionFailedException,
			PreConditionRequiredException, InternalServerException, ConflictException, RecordNotFoundException {
		BaseUserInformation baseUserInfo = null;
		if (validateCreateAccountRequest(createAccountRequest)
				&& !validateDuplicateAccountByUserNameRequest(createAccountRequest.getLoginUserName())) {
			Account account = accountService.createAccount(createAccountRequest);
			baseUserInfo = accountService.prepareBaseUserInformation(account);
		}
		NewCookie accessTokenCookie = new NewCookie("access_token", baseUserInfo.getAccessToken());
		NewCookie refreshTokenCookie = new NewCookie("refresh_token", baseUserInfo.getRefreshToken());

		return Response.status(Status.OK).entity(baseUserInfo).cookie(accessTokenCookie).cookie(refreshTokenCookie)
				.build();
	}

	private boolean validateLocationForConflictRequest(SolrLocationMaster solrLocationMaster)
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

	private boolean validateElectorDetailsRequest(ValidateElectorDetailsRequest validateElectorDetailsRequest)
			throws PreConditionFailedException, PreConditionRequiredException {

		if (validateElectorDetailsRequest.getElectorName() == null) {
			throw new PreConditionFailedException(ExceptionConstants.NAME_REQUIRED);
		} else if (validateElectorDetailsRequest.getElectorName().isEmpty()) {
			throw new PreConditionRequiredException(ExceptionConstants.NAME_NOT_EMPTY);
		} else if (validateElectorDetailsRequest.getIdCardNo() == null) {
			throw new PreConditionFailedException(ExceptionConstants.IDENTITY_CARD_NO_REQUIRED);
		} else if (validateElectorDetailsRequest.getIdCardNo().isEmpty()) {
			throw new PreConditionRequiredException(ExceptionConstants.IDENTITY_CARD_NO_NOT_EMPTY);
		} else if (validateElectorDetailsRequest.getReferenceName() == null) {
			throw new PreConditionFailedException(ExceptionConstants.REFERENCE_NAME_REQUIRED);
		} else if (validateElectorDetailsRequest.getReferenceName().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.REFERENCE_NAME_SHOULD_NOT_BE_EMPTY);
		} else if (validateElectorDetailsRequest.getGender() == null) {
			throw new PreConditionFailedException(ExceptionConstants.GENDER_REQUIRED);
		} else if (validateElectorDetailsRequest.getGender().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.GENDER_SHOULD_NOT_BE_EMPTY);
		} else if (validateElectorDetailsRequest.getYearOfBirth() == null) {
			throw new PreConditionFailedException(ExceptionConstants.YEAR_OF_BIRTH_REQUIRED);
		} else if (validateElectorDetailsRequest.getYearOfBirth().equals(0)) {
			throw new PreConditionFailedException(ExceptionConstants.YEAR_OF_BIRTH_SHOULD_NOT_BE_EMPTY);
		}

		return true;
	}

	private Boolean validateCreateAccountRequest(CreateAccountRequest createAccountRequest)
			throws PreConditionFailedException, PreConditionRequiredException {
		if (createAccountRequest == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		} else if (createAccountRequest.getLoginUserName() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.LOGIN_USER_NAME_REQUIRED);
		} else if (createAccountRequest.getPassword() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.PASSWORD_REQUIRED);
		} else if (createAccountRequest.getUserGuid() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.USER_GUID_REQUIRED);
		} else if (createAccountRequest.getChildLocation().getLocationGuid() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.LOCATION_GUID_REQUIRED);
		} else if (createAccountRequest.getLoginUserName().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.LOGIN_USER_NAME_NOT_EMPTY);
		} else if (createAccountRequest.getPassword().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.PASSWORD_NOT_EMPTY);
		} else if (!CommonUtil.isValidSizeFiled(createAccountRequest.getLoginUserName(),
				ApplicationConstants.MIN_PASSWORD_LENGTH, ApplicationConstants.MAX_PASSWORD_LENGTH)) {
			throw new PreConditionFailedException(ExceptionConstants.LOGIN_USER_NAME_NOT_EMPTY);
		} else if (!CommonUtil.isValidSizeFiled(createAccountRequest.getPassword(),
				ApplicationConstants.MIN_USER_NAME_LENGTH, ApplicationConstants.MAX_USER_NAME_LENGTH)) {
			throw new PreConditionFailedException(ExceptionConstants.LOGIN_USER_NAME_NOT_EMPTY);
		}
		return true;
	}

	private boolean validateDuplicateAccountByUserNameRequest(String userName)
			throws InternalServerException, ConflictException {
		Boolean isDuplicateAccount = Boolean.FALSE;
		if (accountService.getAccountByUserName(userName) != null) {
			throw new ConflictException(ExceptionConstants.ACCOUNT_EXISTS_WITH_USER_NAME);
		}
		return isDuplicateAccount;
	}

}
