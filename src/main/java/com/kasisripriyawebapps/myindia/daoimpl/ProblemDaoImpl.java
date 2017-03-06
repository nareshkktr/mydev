/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.ProblemDao;
import com.kasisripriyawebapps.myindia.entity.Account;
import com.kasisripriyawebapps.myindia.entity.Problem;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Class ProblemDaoImpl.
 */
@Repository
public class ProblemDaoImpl extends BaseDaoImpl<Long, Problem> implements ProblemDao {
	
	@Override
	public Long createProblem(Problem problem) throws InternalServerException {
		return save(problem);
	}

}
