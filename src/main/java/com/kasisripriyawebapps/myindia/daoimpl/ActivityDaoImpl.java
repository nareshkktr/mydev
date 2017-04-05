/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.ActivityDao;
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

}
