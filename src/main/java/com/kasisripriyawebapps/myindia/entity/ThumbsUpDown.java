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


	/** The thumbs up down flag. */
	@Column(name = "THUMBS_UP_DOWN_FLAG")
	private Integer thumbsUpDownFlag;
 
	/** The created by. */
	@Column(name = "CREATED_BY")
	private Long createdBy;


	/** The created time stamp. */
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	public ThumbsUpDown(Long guid, String objectType, Long objectGuid, Integer thumbsUpDownFlag, Long createdBy,
			Timestamp createdTimeStamp) {
		super();
		this.guid = guid;
		this.objectType = objectType;
		this.objectGuid = objectGuid;
		this.thumbsUpDownFlag = thumbsUpDownFlag;
		this.createdBy = createdBy;
		this.createdTimeStamp = createdTimeStamp;
	}

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

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

	public Integer getThumbsUpDownFlag() {
		return thumbsUpDownFlag;
	}

	public void setThumbsUpDownFlag(Integer thumbsUpDownFlag) {
		this.thumbsUpDownFlag = thumbsUpDownFlag;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}



}
