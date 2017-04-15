/*
 * 
 */
package com.kasisripriyawebapps.myindia.dao;

import com.kasisripriyawebapps.myindia.entity.ThumbsUpDown;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Interface ThumbsUpDownDao.
 */
public interface ThumbsUpDownDao {
	Long createThumbsUpDown(ThumbsUpDown thumbsUpDown) throws InternalServerException;

}
