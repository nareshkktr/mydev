/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.dao.UserDao;
import com.kasisripriyawebapps.myindia.entity.User;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GetUserByPropertyRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GetUserByPropertyResponse;
import com.kasisripriyawebapps.myindia.service.ExternalService;
import com.kasisripriyawebapps.myindia.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	ExternalService externalService;

	@Transactional
	@Override
	public GetUserByPropertyResponse getUserByVoterIdName(GetUserByPropertyRequest getUserByPropertyRequest)
			throws InternalServerException, RecordNotFoundException {
		GetUserByPropertyResponse response = null;
		User user = userDao.getUserByIDTypeAndNo(getUserByPropertyRequest.getIdCardType(),
				getUserByPropertyRequest.getIdCardNo());
		if (user != null) {
			user = userDao.getUserByIDTypeNoAndName(getUserByPropertyRequest.getIdCardType(),
					getUserByPropertyRequest.getIdCardNo(), getUserByPropertyRequest.getUserName());
			if (user != null) {
				response = new GetUserByPropertyResponse();
				response.setReferenceType(user.getReferenceType());
			} else {
				throw new RecordNotFoundException(ExceptionConstants.INVALID_ID_CARD_NO_NAME);
			}
		} else {
			throw new RecordNotFoundException(ExceptionConstants.INVALID_ID_CARD_NO);
		}
		return response;
	}

	@Transactional
	@Override
	public GetUserByPropertyResponse getUserByVoterIdNameAndReference(GetUserByPropertyRequest getUserByPropertyRequest)
			throws InternalServerException, RecordNotFoundException {
		GetUserByPropertyResponse response = null;
		User user = null;
		if (getUserByVoterIdName(getUserByPropertyRequest) != null) {
			user = userDao.getUserByIDTypeNoNameAndReference(getUserByPropertyRequest.getIdCardType(),
					getUserByPropertyRequest.getIdCardNo(), getUserByPropertyRequest.getUserName(),
					getUserByPropertyRequest.getReferenceType(), getUserByPropertyRequest.getReferenceName());
			if (user != null) {
				response = new GetUserByPropertyResponse();
				response.setLocationState(user.getState());
				response.setLocationDistrict(user.getDistrict());
				response.setLocationMpConstituency(user.getParliamentaryConstituencyName());
				response.setLocationMLAConstituency(user.getAssemblyConstituencyName());
			} else {
				throw new RecordNotFoundException(ExceptionConstants.INVALID_REFERENCE_DETAILS_NAME);
			}
		}
		return response;
	}

}
