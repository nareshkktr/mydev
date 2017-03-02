/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import javax.servlet.http.HttpServletRequest;

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

	BaseUserInformation login(LoginRequest loginRequest, HttpServletRequest servletRequest) throws InternalServerException, RecordNotFoundException;

	BaseUserInformation prepareBaseUserInformation(Account account, HttpServletRequest servletRequest) throws InternalServerException, RecordNotFoundException;
	
}
