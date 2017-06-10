/*
 * 
 */
package com.kasisripriyawebapps.myindia.dao;

import java.util.List;
import java.util.Set;

import com.kasisripriyawebapps.myindia.entity.Problem;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Interface ProblemDao.
 */
public interface ProblemDao {

	Long saveProblem(Problem problem) throws InternalServerException;

	Problem getProblemByGuid(Long problemGuid) throws InternalServerException;

	void updateProblem(Problem problem) throws InternalServerException;

	List<Problem> filterProblems(Set<String> tokens, Integer pageNo, Integer pageLimit)
			throws InternalServerException;

}
