/*
 * 
 */
package com.kasisripriyawebapps.myindia.dao;

import com.kasisripriyawebapps.myindia.entity.Share;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Interface ShareDao.
 */
public interface ShareDao {

	Long shareObject(Share share) throws InternalServerException;

	Integer getShareCount(String shareObjectType, Long shareObjectGuid) throws InternalServerException;

}
