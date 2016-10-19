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

	/** The object type. */
	@Column(name = "OBJECT_TYPE")
	private String objectType;

	/** The object guid. */
	@Column(name = "OBJECT_GUID")
	private Long objectGuid;

	/** The activity name. */
	@Column(name = "ACTIVITY_NAME")
	private String activityName;

	/** The activity object type. */
	@Column(name = "ACTIVITY_OBJECT_TYPE")
	private String activityObjectType;

	/** The activity object guid. */
	@Column(name = "ACTIVITY_OBJECT_GUID")
	private Long activityObjectGuid;

	/** The activity object type1. */
	@Column(name = "ACTIVITY_OBJECT_TYPE_1")
	private String activityObjectType1;

	/** The activity object guid1. */
	@Column(name = "ACTIVITY_OBJECT_GUID_1")
	private Long activityObjectGuid1;

	/** The activity object type2. */
	@Column(name = "ACTIVITY_OBJECT_TYPE_2")
	private String activityObjectType2;

	/** The activity object guid2. */
	@Column(name = "ACTIVITY_OBJECT_GUID_2")
	private Long activityObjectGuid2;

	/** The activity object type3. */
	@Column(name = "ACTIVITY_OBJECT_TYPE_3")
	private String activityObjectType3;

	/** The activity object guid3. */
	@Column(name = "ACTIVITY_OBJECT_GUID_3")
	private Long activityObjectGuid3;

	/** The created time stamp. */
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	/**
	 * Gets the guid.
	 *
	 * @return the guid
	 */
	public Long getGuid() {
		return guid;
	}

	/**
	 * Sets the guid.
	 *
	 * @param guid
	 *            the new guid
	 */
	public void setGuid(Long guid) {
		this.guid = guid;
	}

	/**
	 * Gets the object type.
	 *
	 * @return the object type
	 */
	public String getObjectType() {
		return objectType;
	}

	/**
	 * Sets the object type.
	 *
	 * @param objectType
	 *            the new object type
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	/**
	 * Gets the object guid.
	 *
	 * @return the object guid
	 */
	public Long getObjectGuid() {
		return objectGuid;
	}

	/**
	 * Sets the object guid.
	 *
	 * @param objectGuid
	 *            the new object guid
	 */
	public void setObjectGuid(Long objectGuid) {
		this.objectGuid = objectGuid;
	}

	/**
	 * Gets the activity name.
	 *
	 * @return the activity name
	 */
	public String getActivityName() {
		return activityName;
	}

	/**
	 * Sets the activity name.
	 *
	 * @param activityName
	 *            the new activity name
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	/**
	 * Gets the activity object type.
	 *
	 * @return the activity object type
	 */
	public String getActivityObjectType() {
		return activityObjectType;
	}

	/**
	 * Sets the activity object type.
	 *
	 * @param activityObjectType
	 *            the new activity object type
	 */
	public void setActivityObjectType(String activityObjectType) {
		this.activityObjectType = activityObjectType;
	}

	/**
	 * Gets the activity object guid.
	 *
	 * @return the activity object guid
	 */
	public Long getActivityObjectGuid() {
		return activityObjectGuid;
	}

	/**
	 * Sets the activity object guid.
	 *
	 * @param activityObjectGuid
	 *            the new activity object guid
	 */
	public void setActivityObjectGuid(Long activityObjectGuid) {
		this.activityObjectGuid = activityObjectGuid;
	}

	/**
	 * Gets the activity object type1.
	 *
	 * @return the activity object type1
	 */
	public String getActivityObjectType1() {
		return activityObjectType1;
	}

	/**
	 * Sets the activity object type1.
	 *
	 * @param activityObjectType1
	 *            the new activity object type1
	 */
	public void setActivityObjectType1(String activityObjectType1) {
		this.activityObjectType1 = activityObjectType1;
	}

	/**
	 * Gets the activity object guid1.
	 *
	 * @return the activity object guid1
	 */
	public Long getActivityObjectGuid1() {
		return activityObjectGuid1;
	}

	/**
	 * Sets the activity object guid1.
	 *
	 * @param activityObjectGuid1
	 *            the new activity object guid1
	 */
	public void setActivityObjectGuid1(Long activityObjectGuid1) {
		this.activityObjectGuid1 = activityObjectGuid1;
	}

	/**
	 * Gets the activity object type2.
	 *
	 * @return the activity object type2
	 */
	public String getActivityObjectType2() {
		return activityObjectType2;
	}

	/**
	 * Sets the activity object type2.
	 *
	 * @param activityObjectType2
	 *            the new activity object type2
	 */
	public void setActivityObjectType2(String activityObjectType2) {
		this.activityObjectType2 = activityObjectType2;
	}

	/**
	 * Gets the activity object guid2.
	 *
	 * @return the activity object guid2
	 */
	public Long getActivityObjectGuid2() {
		return activityObjectGuid2;
	}

	/**
	 * Sets the activity object guid2.
	 *
	 * @param activityObjectGuid2
	 *            the new activity object guid2
	 */
	public void setActivityObjectGuid2(Long activityObjectGuid2) {
		this.activityObjectGuid2 = activityObjectGuid2;
	}

	/**
	 * Gets the activity object type3.
	 *
	 * @return the activity object type3
	 */
	public String getActivityObjectType3() {
		return activityObjectType3;
	}

	/**
	 * Sets the activity object type3.
	 *
	 * @param activityObjectType3
	 *            the new activity object type3
	 */
	public void setActivityObjectType3(String activityObjectType3) {
		this.activityObjectType3 = activityObjectType3;
	}

	/**
	 * Gets the activity object guid3.
	 *
	 * @return the activity object guid3
	 */
	public Long getActivityObjectGuid3() {
		return activityObjectGuid3;
	}

	/**
	 * Sets the activity object guid3.
	 *
	 * @param activityObjectGuid3
	 *            the new activity object guid3
	 */
	public void setActivityObjectGuid3(Long activityObjectGuid3) {
		this.activityObjectGuid3 = activityObjectGuid3;
	}

	/**
	 * Gets the created time stamp.
	 *
	 * @return the created time stamp
	 */
	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	/**
	 * Sets the created time stamp.
	 *
	 * @param createdTimeStamp
	 *            the new created time stamp
	 */
	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

}
