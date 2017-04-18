/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.UserDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.entity.ElectroralRollesURL;
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

	@Override
	public List<User> getElectroralRollesData(ElectroralRollesURL electroralRollesURL) throws InternalServerException {
		
		List<User> returnList = new ArrayList<User>();
		
		List<Criterion> criterions = new ArrayList<Criterion>();

		Criterion criterionObj = null;
		if (electroralRollesURL.getStateName() != null && !electroralRollesURL.getStateName().isEmpty()) {
			criterionObj = Restrictions.eq("state", electroralRollesURL.getStateName());
			criterions.add(criterionObj);
		}
		Criterion criterionObjOne = null;
		if (electroralRollesURL.getDistrictName() != null && !electroralRollesURL.getDistrictName().isEmpty()) {
			criterionObjOne = Restrictions.eq("district", electroralRollesURL.getDistrictName());
			criterions.add(criterionObjOne);
		}
		Criterion criterionObjTwo = null;
		if (electroralRollesURL.getMlaConstituencyName() != null
				&& !electroralRollesURL.getMlaConstituencyName().isEmpty()) {
			criterionObjTwo = Restrictions.eq("assemblyConstituencyName", electroralRollesURL.getMlaConstituencyName());
			criterions.add(criterionObjTwo);
		}
		Criterion criterionObjThree = null;
		if (electroralRollesURL.getPollingStationName() != null
				&& !electroralRollesURL.getPollingStationName().isEmpty()) {
			criterionObjThree = Restrictions.eq("pollingStation", electroralRollesURL.getPollingStationName());
			criterions.add(criterionObjThree);		
		}
		Criterion criterionObjFour = null;
		if (electroralRollesURL.getPollingStationAddress() != null
				&& !electroralRollesURL.getPollingStationAddress().isEmpty()) {
			criterionObjFour = Restrictions.eq("pollingStationAddress", electroralRollesURL.getPollingStationAddress());
			criterions.add(criterionObjFour);
		}
		
		SortCriteriaData sortCriteriaData = new SortCriteriaData("assemblyConstituencyNo", true);
		if (!criterions.isEmpty()) {
			returnList = getAllByConditions(criterions, sortCriteriaData);
		}
		return returnList;
	}

	@Override
	public void updateUsers(List<User> updatedUsers) throws InternalServerException {
		mergeBatch(updatedUsers);		
	}

}
