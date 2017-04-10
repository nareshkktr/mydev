package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.sql.Timestamp;

public class ActivityRequest {
	
	/** The object type. */
	private String objectType;

	/** The object guid. */
	private Long objectGuid;

	/** The activity name. */
	private String activityName;
	
	/** The activity content. */
	private String activityContent;

	/** The activity object type. */
	private String activityObjectType;

	/** The activity object guid. */
	private Long activityObjectGuid;

	/** The activity happened on type. */
	private String onObjectType;

	/** The activity happened on guid. */
	private Long onObjectGuid;

	/** The activity happened on whose object type. */
	private String ofObjectType;

	/** The activity happened on whose object guid. */
	private Long ofObjectGuid;

	/** The created time stamp. */
	private Timestamp createdTimeStamp;
	
	/** The created time stamp. */
	private Long createdBy;

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public Long getObjectGuid() {
		return objectGuid;
	}

	public void setObjectGuid(Long objectGuid) {
		this.objectGuid = objectGuid;
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

	public String getActivityObjectType() {
		return activityObjectType;
	}

	public void setActivityObjectType(String activityObjectType) {
		this.activityObjectType = activityObjectType;
	}

	public Long getActivityObjectGuid() {
		return activityObjectGuid;
	}

	public void setActivityObjectGuid(Long activityObjectGuid) {
		this.activityObjectGuid = activityObjectGuid;
	}

	public String getOnObjectType() {
		return onObjectType;
	}

	public void setOnObjectType(String onObjectType) {
		this.onObjectType = onObjectType;
	}

	public Long getOnObjectGuid() {
		return onObjectGuid;
	}

	public void setOnObjectGuid(Long onObjectGuid) {
		this.onObjectGuid = onObjectGuid;
	}

	public String getOfObjectType() {
		return ofObjectType;
	}

	public void setOfObjectType(String ofObjectType) {
		this.ofObjectType = ofObjectType;
	}

	public Long getOfObjectGuid() {
		return ofObjectGuid;
	}

	public void setOfObjectGuid(Long ofObjectGuid) {
		this.ofObjectGuid = ofObjectGuid;
	}

	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
}
