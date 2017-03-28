/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import java.util.List;

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

	List<ProblemResponse> retreiveProblemsByType(Long problemTypeGuid, LoggedInUserDetails loggedInUserDetails) throws InternalServerException;

	List<ProblemResponse> retreiveProblemsByTypeCategory(String problemTypeCategory,
			LoggedInUserDetails loggedInUserDetails) throws InternalServerException;

	List<ProblemResponse> filterProblems(String tokenizedString, Integer pageNo, Integer pageLimit) throws InternalServerException;

}
