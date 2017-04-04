/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import java.util.List;
import java.util.Map;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.FilterEntityRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GlobalSearchRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GlobalSearchResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ProblemResponse;
import com.kasisripriyawebapps.myindia.solr.entity.SolrGlobalSearchMaster;

/**
 * The Interface SearchService.
 */
public interface SearchService {

	Map<String, List<SolrGlobalSearchMaster>> getAllGlobalSearchResults(String searchTerm) throws InternalServerException;

	GlobalSearchResponse getGlobalSearchResults(GlobalSearchRequest globalSearchRequest) throws InternalServerException;

	List<ProblemResponse> filterEntity(FilterEntityRequest filterEntityRequest) throws InternalServerException, RecordNotFoundException;

}
