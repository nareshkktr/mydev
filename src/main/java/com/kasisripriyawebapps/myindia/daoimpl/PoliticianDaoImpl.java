/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.PoliticianDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.entity.Politician;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Class PoliticianDaoImpl.
 */
@Repository
public class PoliticianDaoImpl extends BaseDaoImpl<Long, Politician> implements PoliticianDao {

	@Override
	public List<Politician> getAllPoliticians() throws InternalServerException {
		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("fullName");
		sortCriteria.setIsAscending(true);
		return getAll( sortCriteria);
	}

	@Override
	public void saveOrUpdatePolitician(List<Politician> newPolitician) throws InternalServerException {
		// TODO Auto-generated method stub
		saveOrUpdateBatch(newPolitician);
	}
	
	

}
