/*
 * 
 */
package com.kasisripriyawebapps.myindia.endpoints;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
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
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateAccountRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.LoginRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.SaveOrUpdateDeleteObjectResponse;
import com.kasisripriyawebapps.myindia.service.AccountService;
import com.kasisripriyawebapps.myindia.service.OAuthService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(EndPointConstants.ACCOUNT_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.ACCOUNT_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.ACCOUNT_ENDPOINT_API_TAGS }, description = EndPointConstants.ACCOUNT_ENDPOINT_API_DESCRIPTION)
public class AccountEndPoint {

	@Autowired
	AccountService accountService;
	@Autowired
	OAuthService oAuthService;

	@POST
	@ApiOperation(value = EndPointConstants.CREATE_ACCOUNT_API_VALUE, nickname = EndPointConstants.CREATE_ACCOUNT_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.CREATE_ACCOUNT_API_DESCRIPTION)
	@Path(EndPointConstants.CREATE_ACCOUNT_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createAccount(CreateAccountRequest createAccountRequest) throws PreConditionFailedException,
			PreConditionRequiredException, InternalServerException, ConflictException, RecordNotFoundException {
		Long accountId = null;
		if (validateCreateAccountRequest(createAccountRequest)
				&& !validateDuplicateAccountByUserNameRequest(createAccountRequest.getLoginUserName())) {
			accountId = accountService.createAccount(createAccountRequest);
		}
		JSONObject authTokenInfo = null;
		Account account = accountService.getAccountByUserName(createAccountRequest.getLoginUserName());
		if (account != null) {
			authTokenInfo = oAuthService.getAuthTokenInfo(account.getUserName(), account.getPassword());
		}
		String accessToken;
		try {
			accessToken = authTokenInfo.getString("access_token");
		} catch (JSONException e) {
			throw new InternalServerException(e.getMessage());
		}
		NewCookie accessTokenCookie = new NewCookie("access_token", accessToken);
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(accountId);
		return Response.status(Status.OK).entity(saveObjResponse).cookie(accessTokenCookie).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.LOGIN_ACCOUNT_API_VALUE, nickname = EndPointConstants.LOGIN_ACCOUNT_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.LOGIN_ACCOUNT_API_DESCRIPTION)
	@Path(EndPointConstants.LOGIN_ACCOUNT_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(LoginRequest loginRequest) throws InternalServerException, RecordNotFoundException,
			PreConditionFailedException, PreConditionRequiredException {
		Account account = null;
		JSONObject authTokenInfo = null;
		if (validateLoginRequest(loginRequest)) {
			account = accountService.login(loginRequest);
		}
		if (account != null) {
			authTokenInfo = oAuthService.getAuthTokenInfo(account.getUserName(), account.getPassword());
		}
		String accessToken;
		try {
			accessToken = authTokenInfo.getString("access_token");
		} catch (JSONException e) {
			throw new InternalServerException(e.getMessage());
		}
		NewCookie accessTokenCookie = new NewCookie("access_token", accessToken);
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(account.getGuid());
		return Response.status(Status.OK).entity(saveObjResponse).cookie(accessTokenCookie).build();
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

	private Boolean validateLoginRequest(LoginRequest loginRequest)
			throws PreConditionFailedException, PreConditionRequiredException {
		Boolean isValidRequest = Boolean.TRUE;
		if (loginRequest == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		} else if (loginRequest.getLoginUserName() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.LOGIN_USER_NAME_REQUIRED);
		} else if (loginRequest.getPassword() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.PASSWORD_REQUIRED);
		} else if (loginRequest.getLoginUserName().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.LOGIN_USER_NAME_NOT_EMPTY);
		} else if (loginRequest.getPassword().isEmpty()) {
			throw new PreConditionFailedException(ExceptionConstants.PASSWORD_NOT_EMPTY);
		}
		return isValidRequest;
	}

}
