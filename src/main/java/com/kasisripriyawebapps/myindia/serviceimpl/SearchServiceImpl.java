/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.dao.SearchDao;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.service.SearchService;
import com.kasisripriyawebapps.myindia.solr.entity.SolrGlobalSearchMaster;
import com.kasisripriyawebapps.myindia.solr.repository.GlobalSearchRepository;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

/**
 * The Class SearchServiceImpl.
 */
@Service
public class SearchServiceImpl implements SearchService {

	/** The search dao. */
	@Autowired
	SearchDao searchDao;

	@Autowired
	private GlobalSearchRepository globalSearchRepository;

	@Override
	public Map<String, List<SolrGlobalSearchMaster>> getAllGlobalSearchResults(String searchTerm) throws InternalServerException {
		Map<String, List<SolrGlobalSearchMaster>> searchResultsMap=new HashMap<String, List<SolrGlobalSearchMaster>>();
		List<SolrGlobalSearchMaster> searchResults=globalSearchRepository.findByObjectNameContains(searchTerm);
		if(CommonUtil.isListNotNullAndNotEmpty(searchResults)){
			searchResultsMap = searchResults.stream()
					.collect(Collectors.groupingBy(searchResult -> searchResult.getObjectType()));
		}
		return searchResultsMap;
	}
}
