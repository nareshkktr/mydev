/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import java.util.List;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ActivityRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ActivityResponse;

/**
 * The Interface ActivityService.
 */
public interface ActivityService {

	Long saveActivity(ActivityRequest activityReq) throws InternalServerException;

	List<ActivityResponse> getActivities(Integer pageNo, Integer pageLimit) throws InternalServerException, RecordNotFoundException;

	List<ActivityResponse> getActivitiesByObjectGuid(Long objectGuid, Integer pageNo, Integer pageLimit) throws InternalServerException, RecordNotFoundException;

}
