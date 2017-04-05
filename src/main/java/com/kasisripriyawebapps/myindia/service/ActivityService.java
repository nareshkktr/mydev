/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ActivityRequest;

/**
 * The Interface ActivityService.
 */
public interface ActivityService {

	Long saveActivity(ActivityRequest activityReq) throws InternalServerException;

}
