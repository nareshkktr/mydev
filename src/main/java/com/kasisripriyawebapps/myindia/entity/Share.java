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
 * The Class Share.
 */
@Entity
@Table(name = "SHARE")
public class Share implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6117179256167337449L;

	/**
	 * Instantiates a new share entity.
	 */
	public Share() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** The guid. */
	@Id
	@Column(name = "SHARE_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	/** The object type. */
	@Column(name = "OBJECT_TYPE")
	private String objectType;

	/** The object guid. */
	@Column(name = "OBJECT_GUID")
	private Long objectGuid;

	/** The share object type. */
	@Column(name = "SHARE_OBJECT_TYPE")
	private String shareObjectType;

	/** The share object guid. */
	@Column(name = "SHARE_OBJECT_GUID")
	private Long shareObjectGuid;

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
	 * Gets the share object type.
	 *
	 * @return the share object type
	 */
	public String getShareObjectType() {
		return shareObjectType;
	}

	/**
	 * Sets the share object type.
	 *
	 * @param shareObjectType
	 *            the new share object type
	 */
	public void setShareObjectType(String shareObjectType) {
		this.shareObjectType = shareObjectType;
	}

	/**
	 * Gets the share object guid.
	 *
	 * @return the share object guid
	 */
	public Long getShareObjectGuid() {
		return shareObjectGuid;
	}

	/**
	 * Sets the share object guid.
	 *
	 * @param shareObjectGuid
	 *            the new share object guid
	 */
	public void setShareObjectGuid(Long shareObjectGuid) {
		this.shareObjectGuid = shareObjectGuid;
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
