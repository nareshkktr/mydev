/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import java.util.List;
import java.util.Set;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.BaseUserInformation;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateProblemRequestData;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ProblemResponse;

/**
 * The Interface ProblemService.
 */
public interface ProblemService {

	Long createProblem(CreateUpdateProblemRequestData createUpdateProblemRequestData,
			LoggedInUserDetails loggedInUserDetails) throws InternalServerException;

	ProblemResponse retreiveProblem(Long problemGuid) throws InternalServerException, RecordNotFoundException;

	List<ProblemResponse> retreiveProblemsByType(Long problemTypeGuid, LoggedInUserDetails loggedInUserDetails) throws InternalServerException, RecordNotFoundException;

	List<ProblemResponse> retreiveProblemsByTypeCategory(String problemTypeCategory,
			LoggedInUserDetails loggedInUserDetails) throws InternalServerException, RecordNotFoundException;

	List<ProblemResponse> filterProblems(Set<String> tagTokens, Integer pageNo, Integer pageLimit) throws InternalServerException, RecordNotFoundException;

	List<BaseUserInformation> retreiveProblemContributorsByGuid(Long problemGuid) throws InternalServerException, RecordNotFoundException;

	ProblemResponse retreiveProblemBaseInfo(Long problemGuid) throws InternalServerException, RecordNotFoundException;

}
