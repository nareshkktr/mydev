/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.dao.ThumbsUpDownDao;
import com.kasisripriyawebapps.myindia.service.ThumbsUpDownService;

// TODO: Auto-generated Javadoc
/**
 * The Class ThumbsUpDownServiceImpl.
 */
@Service
public class ThumbsUpDownServiceImpl implements ThumbsUpDownService {

	/** The thumbs up down dao. */
	@Autowired
	ThumbsUpDownDao thumbsUpDownDao;

}
