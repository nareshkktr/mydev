/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.constants.NamedQueryParameters;
import com.kasisripriyawebapps.myindia.constants.ServiceConstants;
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

	@Override
	public void deleteAllLocations() throws InternalServerException {

		String namedQueryName = NamedQueryParameters.DELETE_ALL_LOCATIONS;
		executeUpdateNativeNamedQuery(namedQueryName, null);

	}

	@Override
	public Location getLocationByTypeAndGuid(String masterLocationType, Long masterLocationGuid)
			throws InternalServerException {
		Criterion criterionObj = null;
		if (masterLocationType.equalsIgnoreCase(ServiceConstants.LOCATION_VILLAGE_TYPE)) {
			criterionObj = Restrictions.eq("locationVillage", masterLocationGuid);
		} else if (masterLocationType.equalsIgnoreCase(ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE)) {
			criterionObj = Restrictions.eq("locationMunicipalCorporation", masterLocationGuid);
		} else if (masterLocationType.equalsIgnoreCase(ServiceConstants.LOCATION_MUNCIPALITY_TYPE)) {
			criterionObj = Restrictions.eq("locationMunicipality", masterLocationGuid);
		} else if (masterLocationType.equalsIgnoreCase(ServiceConstants.LOCATION_TOWN_PANCHAYATH_TYPE)) {
			criterionObj = Restrictions.eq("locationTownPanchayat", masterLocationGuid);
		}
		return getByCondition(criterionObj);
	}

	@Override
	public Location getLocationByGuid(Long locationRefGuid) throws InternalServerException {
		return getById(locationRefGuid);
	}

}
