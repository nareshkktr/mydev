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
 * The Class ThumbsUpDown.
 */
@Entity
@Table(name = "THUMBS_UP_DOWN")
public class ThumbsUpDown implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1650337671226873860L;

	/**
	 * Instantiates a new thumbs up down entity.
	 */
	public ThumbsUpDown() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** The guid. */
	@Id
	@Column(name = "THUMBS_UP_DOWN_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	/** The object type. */
	@Column(name = "OBJECT_TYPE")
	private String objectType;

	/** The object guid. */
	@Column(name = "OBJECT_GUID")
	private Long objectGuid;

	/** The thumbs object type. */
	@Column(name = "THUMBS_OBJECT_TYPE")
	private String thumbsObjectType;

	/** The thumbs up down flag. */
	@Column(name = "THUMBS_UP_DOWN_FLAG")
	private Integer thumbsUpDownFlag;

	/** The thumbs object guid. */
	@Column(name = "THUMBS_OBJECT_GUID")
	private Long thumbsObjectGuid;

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
	 * Gets the thumbs object type.
	 *
	 * @return the thumbs object type
	 */
	public String getThumbsObjectType() {
		return thumbsObjectType;
	}

	/**
	 * Sets the thumbs object type.
	 *
	 * @param thumbsObjectType
	 *            the new thumbs object type
	 */
	public void setThumbsObjectType(String thumbsObjectType) {
		this.thumbsObjectType = thumbsObjectType;
	}

	/**
	 * Gets the thumbs object guid.
	 *
	 * @return the thumbs object guid
	 */
	public Long getThumbsObjectGuid() {
		return thumbsObjectGuid;
	}

	/**
	 * Sets the thumbs object guid.
	 *
	 * @param thumbsObjectGuid
	 *            the new thumbs object guid
	 */
	public void setThumbsObjectGuid(Long thumbsObjectGuid) {
		this.thumbsObjectGuid = thumbsObjectGuid;
	}

	/**
	 * Gets the thumbs up down flag.
	 *
	 * @return the thumbs up down flag
	 */
	public Integer getThumbsUpDownFlag() {
		return thumbsUpDownFlag;
	}

	/**
	 * Sets the thumbs up down flag.
	 *
	 * @param thumbsUpDownFlag
	 *            the new thumbs up down flag
	 */
	public void setThumbsUpDownFlag(Integer thumbsUpDownFlag) {
		this.thumbsUpDownFlag = thumbsUpDownFlag;
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
