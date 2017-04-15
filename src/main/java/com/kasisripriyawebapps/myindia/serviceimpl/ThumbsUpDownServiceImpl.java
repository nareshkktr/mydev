/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.dao.ThumbsUpDownDao;
import com.kasisripriyawebapps.myindia.entity.ThumbsUpDown;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ActivityRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ThumbsUpDownRequest;
import com.kasisripriyawebapps.myindia.service.ActivityService;
import com.kasisripriyawebapps.myindia.service.ThumbsUpDownService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ThumbsUpDownServiceImpl.
 */
@Service
public class ThumbsUpDownServiceImpl implements ThumbsUpDownService {

	/** The thumbs up down dao. */
	@Autowired
	ThumbsUpDownDao thumbsUpDownDao;
	
	@Autowired
	ActivityService activityService;

	@Override
	@Transactional
	public Long createThumbsUpDown(ThumbsUpDownRequest request, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException {
		ThumbsUpDown thumbsUpDown=new ThumbsUpDown();
		Integer thumbsUpDownFlag=0;
		thumbsUpDown.setCreatedBy(loggedInUserDetails.getGuid());
		thumbsUpDown.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
		thumbsUpDown.setObjectGuid(request.getObjectGuid());
		thumbsUpDown.setObjectType(request.getObjectType());
		thumbsUpDownFlag=request.getThumbsUpDownFlag();
		thumbsUpDown.setThumbsUpDownFlag(thumbsUpDownFlag);
		Long responseId=thumbsUpDownDao.createThumbsUpDown(thumbsUpDown);
		
		thumbsUpDown.setGuid(responseId);
        ActivityRequest activityReq = preapreActivityRequest(thumbsUpDown);
		
		//Save For Activity Feed
		activityService.saveActivity(activityReq);

		return responseId;
	}
	
       private ActivityRequest preapreActivityRequest(ThumbsUpDown thumbsUpDown) {
		
		ActivityRequest activityRequest = new ActivityRequest();
		
		activityRequest.setActivityContent(thumbsUpDown.getObjectType());
		
		//Like/UnLike
		if(thumbsUpDown.getThumbsUpDownFlag() == ApplicationConstants.THUMBS_ZERO){
		activityRequest.setActivityName(ApplicationConstants.THUMBS_UNLIKE);
		}
		activityRequest.setActivityName(ApplicationConstants.THUMBS_LIKE);
		//thumbsUpDown
		activityRequest.setActivityObjectGuid(thumbsUpDown.getGuid());
		activityRequest.setActivityObjectType(ApplicationConstants.THUMBS_UP_DOWN);
		
		//thumbsUpDown on
		activityRequest.setOnObjectGuid(thumbsUpDown.getObjectGuid());
		activityRequest.setOnObjectType(thumbsUpDown.getObjectType());
		
		//thumbsUpDown By
		activityRequest.setCreatedBy(thumbsUpDown.getCreatedBy());
		activityRequest.setCreatedTimeStamp(thumbsUpDown.getCreatedTimeStamp());
		
		return activityRequest;
	}

}
