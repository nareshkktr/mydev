/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.dao.SearchDao;
import com.kasisripriyawebapps.myindia.service.SearchService;

// TODO: Auto-generated Javadoc
/**
 * The Class SearchServiceImpl.
 */
@Service
public class SearchServiceImpl implements SearchService {

	/** The search dao. */
	@Autowired
	SearchDao searchDao;
}
