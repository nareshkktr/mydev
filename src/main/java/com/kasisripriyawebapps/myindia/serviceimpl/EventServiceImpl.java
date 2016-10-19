/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.dao.EventDao;
import com.kasisripriyawebapps.myindia.service.EventService;

// TODO: Auto-generated Javadoc
/**
 * The Class EventServiceImpl.
 */
@Service
public class EventServiceImpl implements EventService {

	/** The event dao. */
	@Autowired
	EventDao eventDao;

}
