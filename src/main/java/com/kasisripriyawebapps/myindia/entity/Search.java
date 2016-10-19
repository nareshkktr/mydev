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
 * The Class Search.
 */
@Entity
@Table(name = "SEARCH_MASTER")
public class Search implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3414559204719655418L;

	/**
	 * Instantiates a new search entity.
	 */
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** The guid. */
	@Id
	@Column(name = "SEARCH_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	/** The object type. */
	@Column(name = "OBJECT_TYPE")
	private String objectType;

	/** The object guid. */
	@Column(name = "OBJECT_GUID")
	private Long objectGuid;

	/** The search text. */
	@Column(name = "SEARCH_TEXT")
	private String searchText;
	
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
	 * Gets the search text.
	 *
	 * @return the search text
	 */
	public String getSearchText() {
		return searchText;
	}

	/**
	 * Sets the search text.
	 *
	 * @param searchText
	 *            the new search text
	 */
	public void setSearchText(String searchText) {
		this.searchText = searchText;
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
