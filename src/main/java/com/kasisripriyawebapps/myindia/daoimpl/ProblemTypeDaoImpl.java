package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.ProblemTypeDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.entity.ProblemType;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

@Repository
public class ProblemTypeDaoImpl extends BaseDaoImpl<Long, ProblemType> implements ProblemTypeDao {

	@Override
	public ProblemType getProblemTypeByName(String problemTypeName) throws InternalServerException {
		Criterion criterionObj = Restrictions.eq("problemTypeName", problemTypeName);
		return getByCondition(criterionObj);
	}

	@Override
	public Long createProblemType(ProblemType problemType) throws InternalServerException {
		return save(problemType);
	}

	@Override
	public ProblemType getProblemTypeById(Long problemTypeGuid) throws InternalServerException {
		return getById(problemTypeGuid);
	}

	@Override
	public void deleteProblemType(ProblemType problemType) throws InternalServerException {
		delete(problemType);
	}

	@Override
	public void updateProblemType(ProblemType problemType) throws InternalServerException {
		update(problemType);
	}

	@Override
	public List<ProblemType> getAllProblemTypes(Integer offset, Integer limit) throws InternalServerException {
		SortCriteriaData sortCriteria = new SortCriteriaData("problemTypeName", true);
		return getAllByPage(sortCriteria,offset,limit);
	}

	@Override
	public List<ProblemType> getAllProblemTypes() throws InternalServerException {
		SortCriteriaData sortCriteria = new SortCriteriaData("problemTypeName", true);
		return getAll(sortCriteria);
	}

}
