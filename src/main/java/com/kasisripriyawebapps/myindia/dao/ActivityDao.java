/*
 * 
 */
package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.Activity;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Interface ActivityDao.
 */
public interface ActivityDao {

	Long saveActivity(Activity activity) throws InternalServerException;

	List<Activity> getActivities(Integer pageNo, Integer pageLimit) throws InternalServerException;

	List<Activity> getActivitiesByObjectGuid(Long objectGuid, Integer pageNo, Integer pageLimit) throws InternalServerException;

}
