/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.constants.ServiceConstants;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.service.LocationService;
import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;
import com.kasisripriyawebapps.myindia.solr.repository.LocationMasterRepository;

/**
 * The Class LocationServiceImpl.
 */
@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationMasterRepository locationMasterRepository;

	@Override
	public List<SolrLocationMaster> getSearchResultsByLocationName(String searchTerm) throws InternalServerException {
		return locationMasterRepository.findByLocationNameContains(searchTerm);
	}

	@Override
	public List<SolrLocationMaster> getPopularLocations() throws InternalServerException {

		List<String> stateLocationTypes = new ArrayList<String>();
		stateLocationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		stateLocationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);

		List<SolrLocationMaster> stateLocations = locationMasterRepository.findByLocationTypeIn(stateLocationTypes);
		return stateLocations;
	}

}
