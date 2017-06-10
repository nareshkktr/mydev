package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.UserOccupation;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface UserOccupationDao {

	List<UserOccupation> getAllUserOccupations() throws InternalServerException;

	UserOccupation getUserOccupationById(Long guid) throws InternalServerException;;

}
