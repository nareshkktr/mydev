/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateProblemRequest;

/**
 * The Interface ProblemService.
 */
public interface ProblemService {


	Long create(CreateProblemRequest problem, LoggedInUserDetails loggedInUserDetails) throws InternalServerException;

}
