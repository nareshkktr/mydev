/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import java.util.List;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;

/**
 * The Interface LocationService.
 */
public interface LocationService {

	List<SolrLocationMaster> getSearchResultsByLocationName(String searchTerm) throws InternalServerException;

}
