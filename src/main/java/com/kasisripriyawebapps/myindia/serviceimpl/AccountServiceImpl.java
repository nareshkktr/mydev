/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.dao.AccountDao;
import com.kasisripriyawebapps.myindia.dao.UserDao;
import com.kasisripriyawebapps.myindia.entity.Account;
import com.kasisripriyawebapps.myindia.entity.User;
import com.kasisripriyawebapps.myindia.entity.UserInfo;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateAccountRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.LoginRequest;
import com.kasisripriyawebapps.myindia.service.AccountService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDao;

	@Autowired
	UserDao userDao;

	@Override
	@Transactional
	public Long createAccount(final CreateAccountRequest createAccountRequest)
			throws InternalServerException, RecordNotFoundException {
		Long accountGuid = null;
		Account account = new Account();
		account.setUserName(createAccountRequest.getLoginUserName());
		account.setSalt(CommonUtil.generateSalt(32));
		account.setPassword(CommonUtil
				.hashPassword(CommonUtil.saltPassword(createAccountRequest.getPassword(), account.getSalt())));
		account.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());

		User user = userDao.getUserByIDTypeNoNameAndReference(
				createAccountRequest.getUserIdentityData().getIdCardType(),
				createAccountRequest.getUserIdentityData().getIdCardNo(),
				createAccountRequest.getUserIdentityData().getUserName(),
				createAccountRequest.getUserIdentityData().getReferenceType(),
				createAccountRequest.getUserIdentityData().getReferenceName());

		UserInfo userInfo = null;
		if (user != null) {
			userInfo = new UserInfo();
			userInfo.setDateOfBirth(user.getDateOfBirth());
			userInfo.setFatherOrHusband(user.getFatherOrHusband());
			userInfo.setFatherOrHusbandName(user.getFatherOrHusbandName());
			userInfo.setHouseNo(user.getHouseNo());
			userInfo.setIdCardType(user.getIdCardType());
			userInfo.setIdCardType(user.getIdCardNo());
			userInfo.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			userInfo.setAccount(account);
			account.setUserInfo(userInfo);
			account.setUser(user);
			accountGuid = accountDao.createAccount(account);
		} else {
			throw new RecordNotFoundException(ExceptionConstants.USER_NOT_FOUND);
		}
		return accountGuid;
	}

	@Override
	@Transactional(readOnly = true)
	public Account getAccountByUserName(final String userName) throws InternalServerException {
		final Account account = accountDao.getAccountByUserName(userName);
		return account;
	}

	@Override
	@Transactional(readOnly = true)
	public Account login(LoginRequest loginRequest) throws InternalServerException, RecordNotFoundException {
		Account account = getAccountByUserName(loginRequest.getLoginUserName());
		if (account == null) {
			throw new RecordNotFoundException(ExceptionConstants.LOGIN_ACCOUNT_NOT_FOUND_USER_NAME);
		} else {
			account = accountDao.getAccountByUserNameAndPassword(account.getUserName(), account.getSalt(),
					loginRequest.getPassword());
			if (account == null) {
				throw new RecordNotFoundException(ExceptionConstants.LOGIN_ACCOUNT_NOT_FOUND_PASSWORD);
			}
		}
		return account;
	}
}
