/*
 * 
 */
package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.User;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface UserDao {

	User getUserByIDTypeAndNo(String idCardType, String idCardNo) throws InternalServerException;

	void saveUsers(List<User> users) throws InternalServerException;

	User getUserByIDTypeNoAndName(String idCardType, String idCardNo, String userName) throws InternalServerException;

	User getUserByIDTypeNoNameAndReference(String idCardType, String idCardNo, String userName,String referenceType,
			String referenceName) throws InternalServerException;

}
