/*
 * 
 */
package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.Problem;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ProblemResponse;

/**
 * The Interface ProblemDao.
 */
public interface ProblemDao {

	Long saveProblem(Problem problem) throws InternalServerException;

	Problem getProblemByGuid(Long problemGuid) throws InternalServerException;

	void updateProblem(Problem problem) throws InternalServerException;

	List<Problem> filterProblems(String tokenizedString, Integer pageNo, Integer pageLimit)
			throws InternalServerException;

}
