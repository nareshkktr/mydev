/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.ProblemDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
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
		return getById(problemGuid);
	}


	@Override
	public void updateProblem(Problem problem) throws InternalServerException {
		update(problem);
	}

	@Override
	public List<Problem> filterProblems(String tokenizedString,Integer pageNo, Integer pageLimit) throws InternalServerException {
	
		Criterion criterionObj =Restrictions.sqlRestriction("this_.tags REGEXP \'"+ tokenizedString+"\'");// Restrictions.sqlRestriction(tags REGEXP tokenizedString);
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("createdTimeStamp");
		sortCriteria.setIsAscending(true);
		return getAllByConditionsByPage(criterions,sortCriteria,pageNo,pageLimit);
	}

}
