package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.LocationMaster;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface LocationMasterDao {

	void saveAllMasterLocations(List<LocationMaster> allMasterLocations) throws InternalServerException;

}
