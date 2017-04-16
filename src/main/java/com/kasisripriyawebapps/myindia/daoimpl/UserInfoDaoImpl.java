package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.constants.DaoConstants;
import com.kasisripriyawebapps.myindia.constants.NamedQueryParameters;
import com.kasisripriyawebapps.myindia.dao.UserInfoDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.entity.UserInfo;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

@Repository
public class UserInfoDaoImpl extends BaseDaoImpl<Long, UserInfo> implements UserInfoDao {

	@Override
	public void updateAllUsersLocationReferenceToDefault() throws InternalServerException {
		// TODO Auto-generated method stub

		String namedQueryName = NamedQueryParameters.UPDATE_USER_LOCATION_REF_ID;
		Map<String, Object> namedQueryParameters = new HashMap<String, Object>();
		namedQueryParameters.put(NamedQueryParameters.LOCATION_GUID, DaoConstants.COUNTRY_INDIA_LOCATION_REF_ID);
		executeUpdateNativeNamedQuery(namedQueryName, namedQueryParameters);
	}

	@Override
	public List<UserInfo> getAllUsers() throws InternalServerException {
		SortCriteriaData sortCriteria = new SortCriteriaData("electorName", true);
		return getAll(sortCriteria);
	}

	@Override
	public void updateUsers(List<UserInfo> userInfoList) throws InternalServerException {
		mergeBatch(userInfoList);
	}
}
