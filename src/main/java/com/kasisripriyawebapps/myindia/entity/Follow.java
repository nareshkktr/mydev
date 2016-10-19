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

/**
 * The Class FollowEntity.
 */
@Entity
@Table(name = "FOLLOW")
public class Follow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6566351518973272568L;

	/** The guid. */
	@Id
	@Column(name = "FOLLOW_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	/** The object type. */
	@Column(name = "OBJECT_TYPE")
	private String objectType;

	/** The object guid. */
	@Column(name = "OBJECT_GUID")
	private Long objectGuid;

	/** The share object type. */
	@Column(name = "FOLLOW_OBJECT_TYPE")
	private String followObjectType;

	/** The share object guid. */
	@Column(name = "FOLLOW_OBJECT_GUID")
	private Long followObjectGuid;

	/** The created time stamp. */
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

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

	public String getFollowObjectType() {
		return followObjectType;
	}

	public void setFollowObjectType(String followObjectType) {
		this.followObjectType = followObjectType;
	}

	public Long getFollowObjectGuid() {
		return followObjectGuid;
	}

	public void setFollowObjectGuid(Long followObjectGuid) {
		this.followObjectGuid = followObjectGuid;
	}

	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

}
