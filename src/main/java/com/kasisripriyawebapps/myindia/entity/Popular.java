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
 * The Class Popular.
 */
@Entity
@Table(name = "POPULAR")
public class Popular implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5873722425704576023L;

	@Id
	@Column(name = "POPULAR_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;
	
	/** The object type. */
	@Column(name = "OBJECT_TYPE")
	private String objectType;

	/** The object guid. */
	@Column(name = "OBJECT_GUID")
	private Long objectGuid;

	/** The share object type. */
	@Column(name = "POPULAR_OBJECT_TYPE")
	private String popularObjectType;

	/** The share object guid. */
	@Column(name = "POPULAR_OBJECT_GUID")
	private Long popularObjectGuid;

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

	public String getPopularObjectType() {
		return popularObjectType;
	}

	public void setPopularObjectType(String popularObjectType) {
		this.popularObjectType = popularObjectType;
	}

	public Long getPopularObjectGuid() {
		return popularObjectGuid;
	}

	public void setPopularObjectGuid(Long popularObjectGuid) {
		this.popularObjectGuid = popularObjectGuid;
	}

	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

}
