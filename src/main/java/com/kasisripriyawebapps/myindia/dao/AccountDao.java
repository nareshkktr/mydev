/*
 * 
 */
package com.kasisripriyawebapps.myindia.dao;

import com.kasisripriyawebapps.myindia.entity.Account;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface AccountDao {

	Long createAccount(Account account) throws InternalServerException;

	Account getAccountByUserName(String userName) throws InternalServerException;

	Account getAccountByUserNameAndPassword(String userName, String salt, String password) throws InternalServerException;

}
