/*
 * 
 */
package com.kasisripriyawebapps.myindia.endpoints;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
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
import com.kasisripriyawebapps.myindia.requestresponsemodel.LoginRequest;
import com.kasisripriyawebapps.myindia.service.AccountService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(EndPointConstants.ACCOUNT_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.ACCOUNT_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.ACCOUNT_ENDPOINT_API_TAGS }, description = EndPointConstants.ACCOUNT_ENDPOINT_API_DESCRIPTION)
public class AccountEndPoint extends BaseEndPoint{

	@Autowired
	AccountService accountService;
	
	private @Autowired HttpServletRequest servletRequest;
	
	private @Autowired HttpServletResponse servletResponse;
	
	@Autowired
	private ConsumerTokenServices defaultTokenServices;

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

		return Response.status(Status.OK).entity(baseUserInfo).cookie(accessTokenCookie).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.LOGIN_ACCOUNT_API_VALUE, nickname = EndPointConstants.LOGIN_ACCOUNT_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.LOGIN_ACCOUNT_API_DESCRIPTION)
	@Path(EndPointConstants.LOGIN_ACCOUNT_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(LoginRequest loginRequest) throws InternalServerException, RecordNotFoundException,
			PreConditionFailedException, PreConditionRequiredException {
		BaseUserInformation baseUserInfo = null;

		if (validateLoginRequest(loginRequest)) {
			baseUserInfo = accountService.login(loginRequest);
		}
		NewCookie accessTokenCookie = new NewCookie("access_token", baseUserInfo.getAccessToken());
		return Response.status(Status.OK).entity(baseUserInfo).cookie(accessTokenCookie).build();
	}

	@GET
	@ApiOperation(value = EndPointConstants.GET_LOGGED_IN_API_VALUE, nickname = EndPointConstants.GET_LOGGED_IN_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_LOGGED_IN_API_DESCRIPTION)
	@Path(EndPointConstants.GET_LOGGED_IN_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLoggedInUserInfo(LoginRequest loginRequest) throws InternalServerException,
			RecordNotFoundException, PreConditionFailedException, PreConditionRequiredException {
		BaseUserInformation baseUserInfo = null;
		LoggedInUserDetails loggedInUserDetails = getLoggedInUserDetails();
		//Account account = accountService.getAccountByUserName(loggedInUserDetails.getUserName());
		baseUserInfo = accountService.prepareLoggedInUserInfo(loggedInUserDetails.getUserName());      ;//prepareBaseUserInformation(account);
		return Response.status(Status.OK).entity(baseUserInfo).build();
	}

	@POST
	@ApiOperation(value = EndPointConstants.LOGOUT_ACCOUNT_API_VALUE, nickname = EndPointConstants.LOGOUT_ACCOUNT_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.LOGOUT_ACCOUNT_API_DESCRIPTION)
	@Path(EndPointConstants.LOGOUT_ACCOUNT_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response logout() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(servletRequest, servletResponse, auth);
		}
		SecurityContextHolder.getContext().setAuthentication(null);	
		auth.setAuthenticated(false);
		defaultTokenServices.revokeToken(servletRequest.getHeader("Authorization").split(" ")[1]);
		
		return Response.status(Status.OK).build();
	}
	
	@POST
	@ApiOperation(value = EndPointConstants.REFRESH_ACCESS_TOKEN_API_VALUE, nickname = EndPointConstants.REFRESH_ACCESS_TOKEN_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.REFRESH_ACCESS_TOKEN_API_DESCRIPTION)
	@Path(EndPointConstants.REFRESH_ACCESS_TOKEN_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response refreshAccessToken(String refreshToken) throws InternalServerException, PreConditionFailedException {
		
		JSONObject tokenInfo = null;
		
		if(validateRefreshAccessTokenRequest(refreshToken))
			tokenInfo = accountService.refreshAccessToken(refreshToken);
		
		return Response.status(Status.OK).entity(tokenInfo).build();
	}
	
	
	private boolean validateRefreshAccessTokenRequest(String refreshToken) throws PreConditionFailedException {
		
		if(refreshToken == null){
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
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
