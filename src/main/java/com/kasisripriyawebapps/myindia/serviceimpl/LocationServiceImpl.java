/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.dao.LocationDao;
import com.kasisripriyawebapps.myindia.dao.LocationMasterDao;
import com.kasisripriyawebapps.myindia.service.LocationService;

/**
 * The Class LocationServiceImpl.
 */
@Service
public class LocationServiceImpl implements LocationService {

	/** The location dao. */
	@Autowired
	LocationDao locationDao;

	@Autowired
	LocationMasterDao locationMasterDao;

	@Override
	public void exportVillageReferenceLocations(String uploadedFileLocation) {
		// TODO Auto-generated method stub

	}

}
