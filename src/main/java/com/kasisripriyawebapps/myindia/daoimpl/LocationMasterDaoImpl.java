package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.LocationMasterDao;
import com.kasisripriyawebapps.myindia.entity.LocationMaster;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

@Repository
public class LocationMasterDaoImpl extends BaseDaoImpl<Long, LocationMaster> implements LocationMasterDao {

	@Override
	public void saveAllMasterLocations(List<LocationMaster> allMasterLocations) throws InternalServerException {
		saveOrUpdateBatch(allMasterLocations);
	}

}
