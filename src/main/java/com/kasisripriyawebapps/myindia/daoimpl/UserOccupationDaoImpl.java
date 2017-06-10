package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.UserOccupationDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.entity.UserOccupation;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

@Repository
public class UserOccupationDaoImpl extends BaseDaoImpl<Long, UserOccupation> implements UserOccupationDao {

	@Override
	public List<UserOccupation> getAllUserOccupations() throws InternalServerException {
		SortCriteriaData sortCriteria = new SortCriteriaData("occupation", true);
		return getAll(sortCriteria);

	}

	@Override
	public UserOccupation getUserOccupationById(Long guid) throws InternalServerException {
		return getById(guid);
	}
}
