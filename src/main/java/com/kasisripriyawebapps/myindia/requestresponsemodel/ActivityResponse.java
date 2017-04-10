package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityResponse {
	
	private Long guid;
	
	//Activity details
	private String activityName;
	private String activityContent;
	private String activityType;
	private Long activityGuid;
	
	// On Object details
	private String onObjectType;
	private String onObjectName;
	private String onObjectImage;
	private Long onObjectGuid;
	
	// By Object details
	private BaseUserInformation userInfo;
	
	private Timestamp createdTimestamp;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityContent() {
		return activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public Long getActivityGuid() {
		return activityGuid;
	}

	public void setActivityGuid(Long activityGuid) {
		this.activityGuid = activityGuid;
	}

	public String getOnObjectType() {
		return onObjectType;
	}

	public void setOnObjectType(String onObjectType) {
		this.onObjectType = onObjectType;
	}

	public String getOnObjectName() {
		return onObjectName;
	}

	public void setOnObjectName(String onObjectName) {
		this.onObjectName = onObjectName;
	}

	public String getOnObjectImage() {
		return onObjectImage;
	}

	public void setOnObjectImage(String onObjectImage) {
		this.onObjectImage = onObjectImage;
	}

	public BaseUserInformation getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(BaseUserInformation userInfo) {
		this.userInfo = userInfo;
	}

	public Timestamp getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Long getOnObjectGuid() {
		return onObjectGuid;
	}

	public void setOnObjectGuid(Long onObjectGuid) {
		this.onObjectGuid = onObjectGuid;
	}
	
}
