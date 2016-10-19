/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.dao.PostDao;
import com.kasisripriyawebapps.myindia.service.PostService;

// TODO: Auto-generated Javadoc
/**
 * The Class PostServiceImpl.
 */
@Service
public class PostServiceImpl implements PostService {

	/** The post dao. */
	@Autowired
	PostDao postDao;
}
