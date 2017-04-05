/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;


import java.util.List;
import java.util.Set;

import org.codehaus.jettison.json.JSONObject;

import com.kasisripriyawebapps.myindia.entity.Account;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.BaseUserInformation;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateAccountRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.LoginRequest;

public interface AccountService {

	Account createAccount(CreateAccountRequest createAccountRequest)
			throws InternalServerException, RecordNotFoundException;

	Account getAccountByUserName(String userName) throws InternalServerException;

	BaseUserInformation login(LoginRequest loginRequest) throws InternalServerException, RecordNotFoundException;

	BaseUserInformation prepareLoggedInUserInfo(String userName) throws InternalServerException, RecordNotFoundException;

	JSONObject refreshAccessToken(String refreshToken) throws InternalServerException;

	BaseUserInformation getAccountByGuid(Long accountId) throws InternalServerException, RecordNotFoundException;

	List<BaseUserInformation> getAccountsByIds(Set<Long> accountIds) throws InternalServerException, RecordNotFoundException;

	BaseUserInformation prepareBasicSecondaryBaseUserInformation(Account account)
			throws InternalServerException, RecordNotFoundException;

	BaseUserInformation prepareBasicPrimaryBaseUserInformation(Account account)
			throws InternalServerException, RecordNotFoundException;

	BaseUserInformation prepareBaseUserInformation(Account account)
			throws InternalServerException, RecordNotFoundException;
	
}
