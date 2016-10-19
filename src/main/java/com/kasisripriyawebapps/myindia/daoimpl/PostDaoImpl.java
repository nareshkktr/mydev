/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.PostDao;
import com.kasisripriyawebapps.myindia.entity.Post;

/**
 * The Class PostDaoImpl.
 */
@Repository
public class PostDaoImpl extends BaseDaoImpl<Long, Post> implements PostDao {

}
