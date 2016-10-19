/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.entity.Account;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateAccountRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.LoginRequest;

public interface AccountService {

	Long createAccount(CreateAccountRequest createAccountRequest)
			throws InternalServerException, RecordNotFoundException;

	Account getAccountByUserName(String userName) throws InternalServerException;

	Account login(LoginRequest loginRequest) throws InternalServerException, RecordNotFoundException;
}
