/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
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
import com.kasisripriyawebapps.myindia.requestresponsemodel.BaseUserInformation;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateAccountRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.LoginRequest;
import com.kasisripriyawebapps.myindia.service.AccountService;
import com.kasisripriyawebapps.myindia.service.OAuthService;
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
	OAuthService oAuthService;

	@Autowired
	LocationDao locationDao;

	@Autowired
	private UserMasterRepository userMasterRepository;

	@Override
	@Transactional
	public BaseUserInformation createAccount(final CreateAccountRequest createAccountRequest)
			throws InternalServerException, RecordNotFoundException {
		
		BaseUserInformation baseUserInfo = new BaseUserInformation();
		
		Long accountGuid = null;
		Account account = new Account();
		account.setUserName(createAccountRequest.getLoginUserName());
		account.setSalt(CommonUtil.generateSalt(32));
		account.setPassword(CommonUtil
				.hashPassword(CommonUtil.saltPassword(createAccountRequest.getPassword(), account.getSalt())));
		account.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
		account.setUserEmail(createAccountRequest.getEmailAddress());
		SolrUserMaster solrUser = userMasterRepository.findByUserGuid(createAccountRequest.getUserGuid());
		account.setType("VOTER");
		UserInfo userInfo = new UserInfo();
		if (solrUser != null) {
			String solrUserJsonStr = new Gson().toJson(solrUser);
			userInfo = new Gson().fromJson(solrUserJsonStr, UserInfo.class);
			userInfo.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			userInfo.setAccount(account);
			User user = userDao.getUserByGuid(createAccountRequest.getUserGuid());
			Location nativeLocation = locationDao.getLocationByGuidAndParentGuid(
					createAccountRequest.getChildLocation().getLocationType(),
					createAccountRequest.getChildLocation().getLocationGuid(),
					createAccountRequest.getParentLocation().getLocationType(),
					createAccountRequest.getParentLocation().getLocationGuid());
			userInfo.setUser(user);
			userInfo.setNativeLocation(nativeLocation);
			LocationMaster masterLocation = locationMasterDao
					.getLocationByGuid(createAccountRequest.getChildLocation().getLocationGuid());
			userInfo.setMasterLocation(masterLocation);
			account.setUserInfo(userInfo);
			accountGuid = accountDao.createAccount(account);
			
			baseUserInfo = prepareBaseUserInformation(account);
			
		} else {
			throw new RecordNotFoundException(ExceptionConstants.USER_NOT_FOUND);
		}
		return baseUserInfo;
	}

	@Override
	@Transactional
	public BaseUserInformation prepareBaseUserInformation(Account account) throws InternalServerException {

		BaseUserInformation baseUserInfo = new BaseUserInformation();
		JSONObject authTokenInfo = null;
		
		baseUserInfo.setName(account.getUserInfo().getElectorName());
		baseUserInfo.setUserGuid(account.getUserInfo().getGuid());
		baseUserInfo.setGender(account.getUserInfo().getGender());
		baseUserInfo.setUserImage(account.getUserInfo().getPhotoURL());
		baseUserInfo.setUserName(account.getUserName());
		
		if (account != null) {
			try {
				authTokenInfo = oAuthService.getAuthTokenInfo(account.getUserName(), account.getPassword());
				baseUserInfo.setAccessToken(authTokenInfo.getString("access_token"));
			} catch (JSONException e) {
				throw new InternalServerException(e.getMessage());
			}
		}
		
		return baseUserInfo;
	}


	@Override
	@Transactional(readOnly = true)
	public Account getAccountByUserName(final String userName) throws InternalServerException {
		final Account account = accountDao.getAccountByUserName(userName);
		return account;
	}

	@Override
	@Transactional(readOnly = true)
	public BaseUserInformation login(LoginRequest loginRequest) throws InternalServerException, RecordNotFoundException {
		
		BaseUserInformation baseUserInfo = new BaseUserInformation();
		
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
		
		baseUserInfo = prepareBaseUserInformation(account);
		
		return baseUserInfo;
	}
}
