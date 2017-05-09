package com.kasisripriyawebapps.myindia.requestresponsemodel;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "ForgotPasswordRequest", description = "Forgor password")
public class ForgotPasswordRequest {

	private String loginUserName;
	private String referenceName;
	private Long accountGuid;
	private String password;

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public Long getAccountGuid() {
		return accountGuid;
	}

	public void setAccountGuid(Long accountGuid) {
		this.accountGuid = accountGuid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
