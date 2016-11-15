package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.UserInfo;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface UserInfoDao {

	void updateAllUsersLocationReferenceToDefault() throws InternalServerException;

	List<UserInfo> getAllUsers() throws InternalServerException;

	void updateUsers(List<UserInfo> userInfoList) throws InternalServerException;

}
