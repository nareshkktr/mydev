/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
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
	public List<Problem> filterProblems(Set<String> tokens,Integer pageNo, Integer pageLimit) throws InternalServerException {
	
		Criterion[] criterionsArray =  new Criterion[tokens.size()];
		int index=0;
		for(String token:tokens){
			Criterion criterionObj =Restrictions.sqlRestriction("this_.tags REGEXP \'"+ token+"\'");
			criterionsArray[index] = criterionObj;
			index++;
		}
		Criterion criterion = Restrictions.and(criterionsArray);
		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("createdTimeStamp");
		sortCriteria.setIsAscending(true);
		return getAllByConditionsByPage(criterion,sortCriteria,pageNo,pageLimit);
	}

}
