/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import java.util.List;
import java.util.Map;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.solr.entity.SolrGlobalSearchMaster;

/**
 * The Interface SearchService.
 */
public interface SearchService {

	Map<String, List<SolrGlobalSearchMaster>> getAllGlobalSearchResults(String searchTerm) throws InternalServerException;

}
