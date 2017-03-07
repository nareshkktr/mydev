/*
 * 
 */
package com.kasisripriyawebapps.myindia.dao;

import com.kasisripriyawebapps.myindia.entity.Problem;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Interface ProblemDao.
 */
public interface ProblemDao {

	Long saveProblem(Problem problem) throws InternalServerException;

}
