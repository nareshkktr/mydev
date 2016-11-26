/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.UserDao;
import com.kasisripriyawebapps.myindia.entity.User;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

@Repository
public class UserDaoImpl extends BaseDaoImpl<Long, User> implements UserDao {

	@Override
	public void saveUsers(List<User> users) throws InternalServerException {
		saveBatch(users);
	}

	@Override
	public User getUserByGuid(Long userGuid) throws InternalServerException {
		return getById(userGuid);
	}

}
