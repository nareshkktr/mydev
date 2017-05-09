/*
 * 
 */
package com.kasisripriyawebapps.myindia.dao;

import java.util.List;
import java.util.Set;

import com.kasisripriyawebapps.myindia.entity.Account;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface AccountDao {

	Long createAccount(Account account) throws InternalServerException;

	Account getAccountByUserName(String userName) throws InternalServerException;

	Account getAccountByUserNameAndPassword(String userName, String salt, String password)
			throws InternalServerException;

	Account getAccountById(Long accountGuid) throws InternalServerException;

	List<Account> getAccountsById(Set<Long> accountGuids) throws InternalServerException;

	Account getAccountByUserEmail(String emailAddress) throws InternalServerException;

	Account getAccountByUserNameOrEmail(String loginUserName) throws InternalServerException;

	Account getAccountByIdAndPassword(Long guid, String salt, String password) throws InternalServerException;

	void updateAccount(Account account) throws InternalServerException;

}
