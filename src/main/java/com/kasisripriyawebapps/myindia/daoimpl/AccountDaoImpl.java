/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.kasisripriyawebapps.myindia.dao.AccountDao;
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
}
