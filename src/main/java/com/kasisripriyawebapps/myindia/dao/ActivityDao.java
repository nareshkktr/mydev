/*
 * 
 */
package com.kasisripriyawebapps.myindia.dao;

import com.kasisripriyawebapps.myindia.entity.Activity;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Interface ActivityDao.
 */
public interface ActivityDao {

	Long saveActivity(Activity activity) throws InternalServerException;

}
