/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import java.util.List;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.solr.entity.SolrGlobalSearchMaster;

/**
 * The Interface SearchService.
 */
public interface SearchService {

	List<SolrGlobalSearchMaster> getAllGlobalSearchResults(String searchTerm) throws InternalServerException;

}
