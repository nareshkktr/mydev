/*
 * 
 */
package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.User;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface UserDao {

	void saveUsers(List<User> users) throws InternalServerException;

	User getUserByGuid(Long userGuid) throws InternalServerException;

}
