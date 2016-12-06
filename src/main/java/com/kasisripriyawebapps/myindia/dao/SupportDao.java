package com.kasisripriyawebapps.myindia.dao;

import com.kasisripriyawebapps.myindia.entity.Support;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.SupportUnSupportRequest;

public interface SupportDao {

	Long supportObject(Support supportObject) throws InternalServerException;

	Integer getSupportCount(String supportObjectType, Long supportObjectGuid) throws InternalServerException;

	Support getSupportObject(SupportUnSupportRequest supportUnSupportRequest) throws InternalServerException;

	void unSupportObject(Support supportObject) throws InternalServerException;

}
