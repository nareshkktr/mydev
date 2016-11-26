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
	private Long userGuid;
	private Long locationRefGuid;
	private Long locationGuid;

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

	public Long getUserGuid() {
		return userGuid;
	}

	public void setUserGuid(Long userGuid) {
		this.userGuid = userGuid;
	}

	public Long getLocationRefGuid() {
		return locationRefGuid;
	}

	public void setLocationRefGuid(Long locationRefGuid) {
		this.locationRefGuid = locationRefGuid;
	}

	public Long getLocationGuid() {
		return locationGuid;
	}

	public void setLocationGuid(Long locationGuid) {
		this.locationGuid = locationGuid;
	}

}
