/*
 * 
 */
package com.kasisripriyawebapps.myindia.requestresponsemodel;

import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;

import io.swagger.annotations.ApiModel;

/**
 * The Class CreateUpdateAccountRequest.
 */
@ApiModel(value = "CreateAccountRequest", description = "To Create Account For An User")
public class CreateAccountRequest {

	private String emailAddress;
	private String loginUserName;
	private String password;
	private Long userGuid;
	private SolrLocationMaster childLocation;
	private SolrLocationMaster parentLocation;
	private String occupation;

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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public SolrLocationMaster getChildLocation() {
		return childLocation;
	}

	public void setChildLocation(SolrLocationMaster childLocation) {
		this.childLocation = childLocation;
	}

	public SolrLocationMaster getParentLocation() {
		return parentLocation;
	}

	public void setParentLocation(SolrLocationMaster parentLocation) {
		this.parentLocation = parentLocation;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	
}
