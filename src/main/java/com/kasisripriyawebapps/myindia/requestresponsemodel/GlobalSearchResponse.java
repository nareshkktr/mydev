package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kasisripriyawebapps.myindia.solr.entity.SolrGlobalSearchMaster;

public class GlobalSearchResponse {

	private List<SolrGlobalSearchMaster> searchResults = new ArrayList<SolrGlobalSearchMaster>();
	private Integer totalCount = 0;
	private Map<String, Long> objectsCount = new HashMap<String, Long>();

	public List<SolrGlobalSearchMaster> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<SolrGlobalSearchMaster> searchResults) {
		this.searchResults = searchResults;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Map<String, Long> getObjectsCount() {
		return objectsCount;
	}

	public void setObjectsCount(Map<String, Long> objectsCount) {
		this.objectsCount = objectsCount;
	}

}
