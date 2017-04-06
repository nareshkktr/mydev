/*
 * 
 */
package com.kasisripriyawebapps.myindia.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class ActivityEntity.
 */
@Entity
@Table(name = "ACTIVITY_MASTER")
public class Activity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4137218458848575451L;

	/**
	 * Instantiates a new activity entity.
	 */
	public Activity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** The guid. */
	@Id
	@Column(name = "ACTIVITY_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	/** The activity name. */
	@Column(name = "ACTIVITY_NAME")
	private String activityName;
	
	/** The activity name. */
	@Column(name = "ACTIVITY_CONTENT")
	private String activityContent;

	/** The activity object type. */
	@Column(name = "ACTIVITY_OBJECT_TYPE")
	private String activityObjectType;

	/** The activity object guid. */
	@Column(name = "ACTIVITY_OBJECT_GUID")
	private Long activityObjectGuid;

	/** The activity happened on type. */
	@Column(name = "ON_OBJECT_TYPE")
	private String onObjectType;

	/** The activity happened on guid. */
	@Column(name = "ON_OBJECT_GUID")
	private Long onObjectGuid;

	/** The activity happened on whose object type. */
	@Column(name = "OF_OBJECT_TYPE")
	private String ofObjectType;

	/** The activity happened on whose object guid. */
	@Column(name = "OF_OBJECT_GUID")
	private Long ofObjectGuid;

	/** The created time stamp. */
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;
	
	/** The created By. */
	@Column(name = "CREATED_BY")
	private Long createdBy;

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
