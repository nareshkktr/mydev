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
 * The Class Support.
 */
@Entity
@Table(name = "SUPPORT")
public class Support implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -979438889385955944L;

	/** The guid. */
	@Id
	@Column(name = "SUPPORT_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	/** The object type. */
	@Column(name = "OBJECT_TYPE")
	private String objectType;

	/** The object guid. */
	@Column(name = "OBJECT_GUID")
	private Long objectGuid;

	/** The support object type. */
	@Column(name = "SUPPORT_OBJECT_TYPE")
	private String supportObjectType;

	/** The support object guid. */
	@Column(name = "SUPPORT_OBJECT_GUID")
	private Long supportObjectGuid;

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
	 * Gets the support object type.
	 *
	 * @return the support object type
	 */
	public String getSupportObjectType() {
		return supportObjectType;
	}

	/**
	 * Sets the support object type.
	 *
	 * @param supportObjectType
	 *            the new support object type
	 */
	public void setSupportObjectType(String supportObjectType) {
		this.supportObjectType = supportObjectType;
	}

	/**
	 * Gets the support object guid.
	 *
	 * @return the support object guid
	 */
	public Long getSupportObjectGuid() {
		return supportObjectGuid;
	}

	/**
	 * Sets the support object guid.
	 *
	 * @param supportObjectGuid
	 *            the new support object guid
	 */
	public void setSupportObjectGuid(Long supportObjectGuid) {
		this.supportObjectGuid = supportObjectGuid;
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
