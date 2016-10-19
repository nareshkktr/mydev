/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.dao.ShareDao;
import com.kasisripriyawebapps.myindia.service.ShareService;

// TODO: Auto-generated Javadoc
/**
 * The Class ShareServiceImpl.
 */
@Service
public class ShareServiceImpl implements ShareService {

	/** The share dao. */
	@Autowired
	ShareDao shareDao;
	
}
