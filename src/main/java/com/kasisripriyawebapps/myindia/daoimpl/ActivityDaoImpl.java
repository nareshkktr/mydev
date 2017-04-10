/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.ActivityDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.entity.Activity;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Class ActivityDaoImpl.
 */
@Repository
public class ActivityDaoImpl extends BaseDaoImpl<Long, Activity> implements ActivityDao {

	@Override
	public Long saveActivity(Activity activity) throws InternalServerException {
		return save(activity);
	}

	@Override
	public List<Activity> getActivities(Integer pageNo, Integer pageLimit) throws InternalServerException {
		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("createdTimeStamp");
		sortCriteria.setIsAscending(false);
		return getAllByPage(sortCriteria,pageNo,pageLimit);
	}

	@Override
	public List<Activity> getActivitiesByObjectGuid(Long objectGuid, Integer pageNo, Integer pageLimit)
			throws InternalServerException {
		
		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("createdTimeStamp");
		sortCriteria.setIsAscending(false);
		
		//Restriction on onObjectGuid
		Criterion criteria = Restrictions.eq("onObjectGuid", objectGuid);
		
		return getAllByConditionsByPage(criteria,sortCriteria,pageNo,pageLimit);
	}

}
