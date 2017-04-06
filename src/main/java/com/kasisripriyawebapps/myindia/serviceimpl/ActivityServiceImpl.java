/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.dao.ActivityDao;
import com.kasisripriyawebapps.myindia.entity.Activity;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ActivityRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ActivityResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.BaseUserInformation;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ProblemResponse;
import com.kasisripriyawebapps.myindia.service.AccountService;
import com.kasisripriyawebapps.myindia.service.ActivityService;
import com.kasisripriyawebapps.myindia.service.ProblemService;

// TODO: Auto-generated Javadoc
/**
 * The Class ActivityServiceImpl.
 */
@Service
public class ActivityServiceImpl implements ActivityService {

	/** The activity dao. */
	@Autowired
	ActivityDao activityDao;
	
	/** The problem service. */
	@Autowired
	ProblemService problemService;
	
	/** The account service. */
	@Autowired
	AccountService accountService;

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
		
		activity.setActivityObjectGuid(activityReq.getActivityObjectGuid());
		activity.setActivityObjectType(activityReq.getActivityObjectType());
		
		activity.setOfObjectGuid(activityReq.getOfObjectGuid());
		activity.setOfObjectType(activityReq.getOfObjectType());
		
		activity.setOnObjectGuid(activityReq.getOnObjectGuid());
		activity.setOnObjectType(activityReq.getOnObjectType());
		
		activity.setCreatedBy(activityReq.getCreatedBy());
		activity.setCreatedTimeStamp(activityReq.getCreatedTimeStamp());
		
		return activity;
	}

	@Override
	@Transactional
	public List<ActivityResponse> getActivities(Integer pageNo, Integer pageLimit) throws InternalServerException, RecordNotFoundException {
		
		List<Activity> activities =activityDao.getActivities(pageNo,pageLimit);
		
		List<ActivityResponse> activityResponse = prepareActivityResponse(activities);
		
		return activityResponse;
	}

	private List<ActivityResponse> prepareActivityResponse(List<Activity> activities) throws InternalServerException, RecordNotFoundException {
		
		List<ActivityResponse> activityResponses = new ArrayList<ActivityResponse>();
		
		for(Activity activity:activities){
			ActivityResponse activityResponse = new ActivityResponse();
			
			activityResponse.setGuid(activity.getGuid());
			
			activityResponse.setActivityContent(activity.getActivityContent());
			activityResponse.setActivityName(activity.getActivityName());
			
			activityResponse.setActivityGuid(activity.getActivityObjectGuid());
			activityResponse.setActivityType(activity.getActivityObjectType());
			
			if(activity.getOnObjectType().equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_PROBLEM)){
				ProblemResponse problem = problemService.retreiveProblemBaseInfo(activity.getOnObjectGuid());
				activityResponse.setOnObjectImage(problem.getPhotoURL());
				activityResponse.setOnObjectName(problem.getProblemShortDescription());
				activityResponse.setOnObjectType(ApplicationConstants.OBJECT_TYPE_PROBLEM);
				activityResponse.setOnObjectGuid(problem.getGuid());
			}
			
			Set<Long> accountIds = new HashSet<Long>();
			accountIds.add(activity.getCreatedBy());
			
			List<BaseUserInformation> usersInfo = accountService.getAccountsByIds(accountIds);
			
			if(usersInfo != null && !usersInfo.isEmpty()){
				activityResponse.setUserInfo(usersInfo.get(0));
			}
			
			activityResponse.setCreatedTimestamp(activity.getCreatedTimeStamp());
			
			activityResponses.add(activityResponse);
		}
		
		return activityResponses;
	}

	@Override
	@Transactional
	public List<ActivityResponse> getActivitiesByObjectGuid(Long objectGuid, Integer pageNo, Integer pageLimit)
			throws InternalServerException, RecordNotFoundException {

		List<Activity> activities =activityDao.getActivitiesByObjectGuid(objectGuid,pageNo,pageLimit);
		
		List<ActivityResponse> activityResponse = prepareActivityResponse(activities);
		
		return activityResponse;
	}
}
