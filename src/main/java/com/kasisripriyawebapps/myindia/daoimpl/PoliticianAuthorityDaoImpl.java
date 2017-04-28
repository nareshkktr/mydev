package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.PoliticianAuthorityDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.entity.PoliticianAuthority;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

@Repository
public class PoliticianAuthorityDaoImpl extends BaseDaoImpl<Long, PoliticianAuthority> implements PoliticianAuthorityDao{

	@Override
	public List<PoliticianAuthority> getActivePoliticianAuthhoritiesByDesignation(String sittingLoksabhaMpDesignation)
			throws InternalServerException {
		Criterion criterionObj = Restrictions.eq("designation", sittingLoksabhaMpDesignation);
		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("designation");
		sortCriteria.setIsAscending(true);
		return getAllByCondition(criterionObj,sortCriteria);
	}

	@Override
	public void saveOrUpdatePolitician(List<PoliticianAuthority> activePoliticianAuthorities)
			throws InternalServerException {
		saveOrUpdateBatch(activePoliticianAuthorities);
	}

	@Override
	public List<PoliticianAuthority> getActivePoliticianAuthhoritiesByDesignationAndLocations(String politicianType,
			List<Long> applicableLocationGuids) throws InternalServerException {
		Criterion criterionObj = Restrictions.eq("designation", politicianType);
		Criterion criterionForLocations = Restrictions.in("electedLocation.guid", applicableLocationGuids);
		
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionForLocations);
		criterions.add(criterionObj);
		
		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("designation");
		sortCriteria.setIsAscending(true);
		return getAllByConditions(criterions,sortCriteria);
	}

}
