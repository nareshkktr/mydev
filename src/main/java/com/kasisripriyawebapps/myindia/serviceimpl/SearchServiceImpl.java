/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.dao.SearchDao;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GlobalSearchRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GlobalSearchResponse;
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
	public Map<String, List<SolrGlobalSearchMaster>> getAllGlobalSearchResults(String searchTerm)
			throws InternalServerException {
		Map<String, List<SolrGlobalSearchMaster>> searchResultsMap = new HashMap<String, List<SolrGlobalSearchMaster>>();
		List<SolrGlobalSearchMaster> searchResults = globalSearchRepository
				.findByObjectNameContainingIgnoreCaseOrderByObjectNameAsc(searchTerm);
		if (CommonUtil.isListNotNullAndNotEmpty(searchResults)) {
			searchResultsMap = searchResults.stream()
					.collect(Collectors.groupingBy(searchResult -> searchResult.getObjectType()));
		}
		return searchResultsMap;
	}

	@Override
	public GlobalSearchResponse getGlobalSearchResults(GlobalSearchRequest globalSearchRequest)
			throws InternalServerException {

		GlobalSearchResponse globalSearchResponse = new GlobalSearchResponse();

		List<SolrGlobalSearchMaster> searchResults = new ArrayList<SolrGlobalSearchMaster>();
		if (globalSearchRequest.getSearchObjectType().equalsIgnoreCase("ALL")) {
			searchResults = globalSearchRepository
					.findByObjectNameContainingIgnoreCaseOrderByObjectNameAsc(globalSearchRequest.getSearchText());
		} else {
			searchResults = globalSearchRepository
					.findByObjectNameContainingIgnoreCaseAndObjectTypeOrderByObjectNameAsc(
							globalSearchRequest.getSearchText(), globalSearchRequest.getSearchObjectType());
		}
		if (CommonUtil.isListNotNullAndNotEmpty(searchResults)) {
			globalSearchResponse.setTotalCount(searchResults.size());

			Map<String, Long> objectsCount = searchResults.stream().collect(
					Collectors.groupingBy(searchResult -> searchResult.getObjectType(), Collectors.counting()));

			globalSearchResponse.setObjectsCount(objectsCount);

			searchResults = searchResults.stream()
					.skip(globalSearchRequest.getPageOffset() * globalSearchRequest.getPageLimit())
					.limit(globalSearchRequest.getPageLimit()).collect(Collectors.toList());

			globalSearchResponse.setSearchResults(searchResults);

		}
		return globalSearchResponse;
	}
}
