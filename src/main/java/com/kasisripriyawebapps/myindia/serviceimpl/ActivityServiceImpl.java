/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.dao.ActivityDao;
import com.kasisripriyawebapps.myindia.entity.Activity;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ActivityRequest;
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

	@Override
	@Transactional
	public Long saveActivity(ActivityRequest activityReq) throws InternalServerException {
		
		Activity activity = prepareActivityObject(activityReq);
		Long activityGuid = activityDao.saveActivity(activity);
		return activityGuid;
	}

	private Activity prepareActivityObject(ActivityRequest activityReq) {
		
		Activity activity = new Activity();
		
		activity.setActivityContent(activityReq.getActivityContent());
		activity.setActivityName(activityReq.getActivityName());
		
		activity.setObjectGuid(activityReq.getObjectGuid());
		activity.setObjectType(activityReq.getObjectType());
		
		activity.setActivityObjectGuid(activityReq.getActivityObjectGuid());
		activity.setActivityObjectGuid1(activityReq.getActivityObjectGuid1());
		activity.setActivityObjectGuid2(activityReq.getActivityObjectGuid2());
		activity.setActivityObjectGuid3(activityReq.getActivityObjectGuid3());
		activity.setActivityObjectType(activityReq.getActivityObjectType());
		activity.setActivityObjectType1(activityReq.getActivityObjectType1());
		activity.setActivityObjectType2(activityReq.getActivityObjectType2());
		activity.setActivityObjectType3(activityReq.getActivityObjectType3());
		
		
		activity.setCreatedBy(activityReq.getCreatedBy());
		activity.setCreatedTimeStamp(activityReq.getCreatedTimeStamp());
		
		return activity;
	}
}
