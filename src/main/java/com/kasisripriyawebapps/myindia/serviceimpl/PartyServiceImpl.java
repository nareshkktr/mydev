/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.dao.PartyDao;
import com.kasisripriyawebapps.myindia.service.PartyService;

// TODO: Auto-generated Javadoc
/**
 * The Class PartyServiceImpl.
 */
@Service
public class PartyServiceImpl implements PartyService {

	/** The party dao. */
	@Autowired
	PartyDao partyDao;
}
