/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.dao.PoliticianDao;
import com.kasisripriyawebapps.myindia.service.PoliticianService;

// TODO: Auto-generated Javadoc
/**
 * The Class PoliticianServiceImpl.
 */
@Service
public class PoliticianServiceImpl implements PoliticianService {

	/** The politician dao. */
	@Autowired
	PoliticianDao politicianDao;
	
}
