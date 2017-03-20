/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateProblemRequestData;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ProblemResponse;

/**
 * The Interface ProblemService.
 */
public interface ProblemService {

	Long createProblem(CreateUpdateProblemRequestData createUpdateProblemRequestData,
			LoggedInUserDetails loggedInUserDetails) throws InternalServerException;

	ProblemResponse retreiveProblem(Long problemGuid, LoggedInUserDetails loggedInUserDetails) throws InternalServerException;

}
