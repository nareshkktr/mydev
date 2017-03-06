/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateProblemRequestData;

/**
 * The Interface ProblemService.
 */
public interface ProblemService {

	Long createProblem(CreateUpdateProblemRequestData createUpdateProblemRequestData,
			LoggedInUserDetails loggedInUserDetails) throws InternalServerException;

}
