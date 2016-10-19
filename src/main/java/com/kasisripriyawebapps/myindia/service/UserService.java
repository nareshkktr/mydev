/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GetUserByPropertyRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GetUserByPropertyResponse;

public interface UserService {

	void uploadAllUsers() throws InternalServerException;

	GetUserByPropertyResponse getUserByVoterIdName(GetUserByPropertyRequest getUserByPropertyRequest)
			throws InternalServerException, RecordNotFoundException;

	GetUserByPropertyResponse getUserByVoterIdNameAndReference(GetUserByPropertyRequest getUserByPropertyRequest)
			throws InternalServerException, RecordNotFoundException;

}
