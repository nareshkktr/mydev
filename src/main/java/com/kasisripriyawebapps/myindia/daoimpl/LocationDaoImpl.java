/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.LocationDao;
import com.kasisripriyawebapps.myindia.entity.Location;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Class LocationDaoImpl.
 */
@Repository
public class LocationDaoImpl extends BaseDaoImpl<Long, Location> implements LocationDao {

	@Override
	public void saveAllLocations(List<Location> allLocations) throws InternalServerException {
		saveOrUpdateBatch(allLocations);
	}
}
