/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.dao.AccountDao;
import com.kasisripriyawebapps.myindia.dao.LocationDao;
import com.kasisripriyawebapps.myindia.dao.LocationMasterDao;
import com.kasisripriyawebapps.myindia.dao.UserDao;
import com.kasisripriyawebapps.myindia.entity.Account;
import com.kasisripriyawebapps.myindia.entity.Location;
import com.kasisripriyawebapps.myindia.entity.LocationMaster;
import com.kasisripriyawebapps.myindia.entity.User;
import com.kasisripriyawebapps.myindia.entity.UserInfo;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateAccountRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.LoginRequest;
import com.kasisripriyawebapps.myindia.service.AccountService;
import com.kasisripriyawebapps.myindia.solr.entity.SolrUserMaster;
import com.kasisripriyawebapps.myindia.solr.repository.UserMasterRepository;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDao;

	@Autowired
	UserDao userDao;

	@Autowired
	LocationMasterDao locationMasterDao;

	@Autowired
	LocationDao locationDao;

	@Autowired
	private UserMasterRepository userMasterRepository;

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

		SolrUserMaster solrUser = userMasterRepository.findByUserGuid(createAccountRequest.getUserGuid());

		UserInfo userInfo = new UserInfo();
		if (solrUser != null) {
			String solrUserJsonStr = new Gson().toJson(solrUser);
			userInfo = new Gson().fromJson(solrUserJsonStr, UserInfo.class);
			userInfo.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			userInfo.setAccount(account);
			User user = userDao.getUserByGuid(solrUser.getUserGuid());
			Location nativeLocation = locationDao.getLocationByGuid(createAccountRequest.getLocationRefGuid());
			userInfo.setUser(user);
			userInfo.setNativeLocation(nativeLocation);
			LocationMaster masterLocation = locationMasterDao
					.getLocationByGuid(createAccountRequest.getLocationGuid());
			userInfo.setMasterLocation(masterLocation);
			account.setUserInfo(userInfo);
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
