package com.kasisripriyawebapps.myindia.solr.service;

import com.kasisripriyawebapps.myindia.entity.Problem;

public interface GlobalSearchMasterService {
	
	 public void addToIndex(Problem problem);

	 public void deleteFromIndex(Long id);
}
