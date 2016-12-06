package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.dao.SupportDao;
import com.kasisripriyawebapps.myindia.entity.Support;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.SupportUnSupportRequest;
import com.kasisripriyawebapps.myindia.service.SupportService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Service
public class SupportServiceImpl implements SupportService {

	@Autowired
	SupportDao supportDao;

	@Override
	public Integer supportObject(SupportUnSupportRequest supportUnSupportRequest) throws InternalServerException {
		Integer supportCount = 0;
		Support supportObject = new Support();
		supportObject.setObjectType(supportUnSupportRequest.getSupportObjectType());
		supportObject.setObjectGuid(supportUnSupportRequest.getSupportObjectGuid());
		supportObject.setSupportObjectType(supportUnSupportRequest.getSupportingObjectType());
		supportObject.setSupportObjectGuid(supportUnSupportRequest.getSupportingObjectGuid());
		supportObject.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
		supportDao.supportObject(supportObject);
		supportCount = supportDao.getSupportCount(supportUnSupportRequest.getSupportObjectType(),
				supportUnSupportRequest.getSupportObjectGuid());
		return supportCount;
	}

	@Override
	public Integer unSupportObject(SupportUnSupportRequest supportUnSupportRequest) throws InternalServerException {
		Integer supportCount = 0;
		Support supportObject = supportDao.getSupportObject(supportUnSupportRequest);
		supportDao.unSupportObject(supportObject);
		supportCount = supportDao.getSupportCount(supportUnSupportRequest.getSupportObjectType(),
				supportUnSupportRequest.getSupportObjectGuid());
		return supportCount;
	}

}
