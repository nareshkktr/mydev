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
import com.kasisripriyawebapps.myindia.entity.User;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

@Repository
public class UserDaoImpl extends BaseDaoImpl<Long, User> implements UserDao {

	@Override
	public User getUserByIDTypeAndNo(String idCardType, String idCardNo) throws InternalServerException {
		Criterion criterionObj = Restrictions.eq("idCardType", idCardType);
		Criterion criterionObjOne = Restrictions.eq("idCardNo", idCardNo);
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		criterions.add(criterionObjOne);
		return getByConditions(criterions);
	}

	@Override
	public User getUserByIDTypeNoAndName(String idCardType, String idCardNo, String userName)
			throws InternalServerException {
		Criterion criterionObj = Restrictions.eq("idCardType", idCardType);
		Criterion criterionObjOne = Restrictions.eq("idCardNo", idCardNo);
		Criterion criterionObjTwo = Restrictions.eq("userName", userName);
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		criterions.add(criterionObjOne);
		criterions.add(criterionObjTwo);
		return getByConditions(criterions);
	}

	@Override
	public void saveUsers(List<User> users) throws InternalServerException {
		saveOrUpdateBatchAsManualCommit(users);
	}

	@Override
	public User getUserByIDTypeNoNameAndReference(String idCardType, String idCardNo, String userName,
			String referenceType, String referenceName) throws InternalServerException {
		Criterion criterionObj = Restrictions.eq("idCardType", idCardType);
		Criterion criterionObjOne = Restrictions.eq("idCardNo", idCardNo);
		Criterion criterionObjTwo = Restrictions.eq("userName", userName);
		Criterion criterionObjThree = Restrictions.eq("fatherOrHusband", referenceType);
		Criterion criterionObjFour = Restrictions.eq("fatherOrHusbandName", referenceName);
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		criterions.add(criterionObjOne);
		criterions.add(criterionObjTwo);
		criterions.add(criterionObjThree);
		criterions.add(criterionObjFour);
		return getByConditions(criterions);
	}

}
