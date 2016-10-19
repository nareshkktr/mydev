/*
 * 
 */
package com.kasisripriyawebapps.myindia.requestresponsemodel;

import io.swagger.annotations.ApiModel;

/**
 * The Class CreateUpdateAccountRequest.
 */
@ApiModel(value = "CreateAccountRequest", description = "To Create Account For An User")
public class CreateAccountRequest {

	private String loginUserName;
	private String password;
	private GetUserByPropertyRequest userIdentityData;

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public GetUserByPropertyRequest getUserIdentityData() {
		return userIdentityData;
	}

	public void setUserIdentityData(GetUserByPropertyRequest userIdentityData) {
		this.userIdentityData = userIdentityData;
	}

}
