/*
 * 
 */
package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.Location;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Interface LocationDao.
 */
public interface LocationDao {

	void saveAllLocations(List<Location> allLocations) throws InternalServerException;
}
