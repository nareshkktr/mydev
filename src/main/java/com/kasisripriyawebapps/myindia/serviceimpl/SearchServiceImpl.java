/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.dao.SearchDao;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.service.SearchService;
import com.kasisripriyawebapps.myindia.solr.entity.SolrGlobalSearchMaster;
import com.kasisripriyawebapps.myindia.solr.repository.GlobalSearchRepository;

// TODO: Auto-generated Javadoc
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
	public List<SolrGlobalSearchMaster> getAllGlobalSearchResults(String searchTerm) throws InternalServerException {
		return globalSearchRepository.findByObjectNameContains(searchTerm);
	}
}
