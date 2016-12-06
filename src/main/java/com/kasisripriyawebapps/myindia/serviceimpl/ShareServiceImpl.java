/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.dao.ShareDao;
import com.kasisripriyawebapps.myindia.entity.Share;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ShareUnShareRequest;
import com.kasisripriyawebapps.myindia.service.ShareService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

/**
 * The Class ShareServiceImpl.
 */
@Service
public class ShareServiceImpl implements ShareService {

	@Autowired
	ShareDao shareDao;

	@Override
	public Integer shareObject(ShareUnShareRequest shareUnShareRequest) throws InternalServerException {
		Integer shareCount = 0;
		Share share = new Share();
		share.setObjectType(shareUnShareRequest.getShareObjectType());
		share.setObjectGuid(shareUnShareRequest.getShareObjectGuid());
		share.setShareObjectType(shareUnShareRequest.getSharingObjectType());
		share.setShareObjectGuid(shareUnShareRequest.getSharingObjectGuid());
		share.setShareTo(shareUnShareRequest.getShareTo());
		share.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
		shareDao.shareObject(share);
		shareCount=shareDao.getShareCount(shareUnShareRequest.getShareObjectType(),shareUnShareRequest.getShareObjectGuid());
		return shareCount;
	}

}
