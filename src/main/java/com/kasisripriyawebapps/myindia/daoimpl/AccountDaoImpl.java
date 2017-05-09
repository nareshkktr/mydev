/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.kasisripriyawebapps.myindia.dao.AccountDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.entity.Account;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Repository
public class AccountDaoImpl extends BaseDaoImpl<Long, Account> implements AccountDao {

	@Override
	public Long createAccount(Account account) throws InternalServerException {
		return save(account);
	}
	@Override
	public void updateAccount(Account account) throws InternalServerException {
		update(account);
	}
	@Override
	public Account getAccountByUserName(String userName) throws InternalServerException {
		Criterion criterionObj = Restrictions.eq("userName", userName);
		return getByCondition(criterionObj);
	}

	@Override
	public Account getAccountByUserNameAndPassword(String userName, String salt, String password)
			throws InternalServerException {
		Criterion criterionObj = Restrictions.eq("userName", userName);
		Criterion criterionObjOne = Restrictions.eq("password",
				CommonUtil.hashPassword(CommonUtil.saltPassword(password, salt)));
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		criterions.add(criterionObjOne);
		return getByConditions(criterions);
	}

	@Override
	public Account getAccountById(Long accountGuid) throws InternalServerException {
		return getById(accountGuid);
	}

	@Override
	public List<Account> getAccountsById(Set<Long> accountGuids) throws InternalServerException {
		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("createdTimeStamp");
		sortCriteria.setIsAscending(true);
		Long[] accountGuidsArray = accountGuids.toArray(new Long[accountGuids.size()]);
		return getAllByPrimaryKeys(sortCriteria, accountGuidsArray);
	}

	@Override
	public Account getAccountByUserEmail(String emailAddress) throws InternalServerException {
		Criterion criterionObj = Restrictions.eq("userEmail", emailAddress);
		return getByCondition(criterionObj);
	}

	@Override
	public Account getAccountByUserNameOrEmail(String loginUserName) throws InternalServerException {
		Criterion criterionObj = Restrictions.eq("userName", loginUserName);
		Criterion criterionObjOne = Restrictions.eq("userEmail", loginUserName);
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		criterions.add(criterionObjOne);
		return getByORConditions(criterions, null);
	}

	@Override
	public Account getAccountByIdAndPassword(Long guid, String salt, String password) throws InternalServerException {
		Criterion criterionObj = Restrictions.eq("guid", guid);
		Criterion criterionObjOne = Restrictions.eq("password",
				CommonUtil.hashPassword(CommonUtil.saltPassword(password, salt)));
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		criterions.add(criterionObjOne);
		return getByConditions(criterions);
	}

}
