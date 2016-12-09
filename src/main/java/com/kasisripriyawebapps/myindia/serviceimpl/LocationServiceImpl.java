/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<SolrLocationMaster> getSearchResultsByLocationName(String searchTerm)
			throws InternalServerException {
		// TODO Auto-generated method stub
		return locationMasterRepository.findByLocationNameContains(searchTerm);
	}

}
