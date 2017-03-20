/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.ProblemDao;
import com.kasisripriyawebapps.myindia.entity.Problem;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Class ProblemDaoImpl.
 */
@Repository
public class ProblemDaoImpl extends BaseDaoImpl<Long, Problem> implements ProblemDao {
	
	
	@Override
	public Long saveProblem(Problem problem) throws InternalServerException {
		return save(problem);
	}

	@Override
	public Problem getProblemByGuid(Long problemGuid) throws InternalServerException {
		// TODO Auto-generated method stub
		return getById(problemGuid);
	}

}
