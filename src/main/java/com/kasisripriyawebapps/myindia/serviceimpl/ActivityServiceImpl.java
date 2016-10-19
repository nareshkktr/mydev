/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.dao.ActivityDao;
import com.kasisripriyawebapps.myindia.service.ActivityService;

// TODO: Auto-generated Javadoc
/**
 * The Class ActivityServiceImpl.
 */
@Service
public class ActivityServiceImpl implements ActivityService {

	/** The activity dao. */
	@Autowired
	ActivityDao activityDao;
}
