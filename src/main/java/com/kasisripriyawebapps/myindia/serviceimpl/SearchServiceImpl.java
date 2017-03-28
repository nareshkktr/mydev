/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.dao.SearchDao;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.FilterEntityRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GlobalSearchRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GlobalSearchResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ProblemResponse;
import com.kasisripriyawebapps.myindia.service.ProblemService;
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
	ProblemService problemService;

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

	@Override
	@Transactional
	public List<ProblemResponse> filterEntity(FilterEntityRequest filterEntityRequest) throws InternalServerException {
		
		Set<String> tagTokens = filterEntityRequest.getTokens();
		
		String tokenizedString =  StringUtils.join(tagTokens, "|");
		
		tokenizedString = ".*("+tokenizedString+").*";
		
		List<ProblemResponse> filteredEntity = null;
		
		if(filterEntityRequest.getObjectType() != null){
			if(filterEntityRequest.getObjectType().equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_PROBLEM)){
				filteredEntity = problemService.filterProblems(tokenizedString,filterEntityRequest.getPageNo(),filterEntityRequest.getPageLimit());
			}
		}
		
		
		return filteredEntity;
	}
	
	public static void main(String args[]){
		Set<String> setsData = new HashSet<String>();
		
		setsData.add("Sripriya");
		setsData.add("Venkatesh");
		
		System.out.println( StringUtils.join(setsData, "%"));
		
	}
	

}
