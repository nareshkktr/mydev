/*
 * 
 */
package com.kasisripriyawebapps.myindia.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class AccountEntity.
 */
@Entity
@Table(name = "ACCOUNT_MASTER")
public class Account implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3820473427203719053L;

	/** The guid. */
	@Id
	@Column(name = "ACCOUNT_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@Column(name = "USER_EMAIL")
	private String userEmail;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "SALT")
	private String salt;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_INFO_GUID")
	private UserInfo userInfo;

	/**
	 * Instantiates a new account entity.
	 * 
	 * @param account
	 */
	public Account(Account account) {
		super();
		this.guid = account.getGuid();
		this.userName = account.getUserName();
		this.password = account.getPassword();
		this.salt = account.getSalt();
		this.type = account.getType();
		this.createdTimeStamp = account.getCreatedTimeStamp();
	}

	/**
	 * Instantiates a new account entity.
	 *
	 * @param guid
	 *            the guid
	 * @param emailAddress
	 *            the email address
	 * @param password
	 *            the password
	 * @param salt
	 *            the salt
	 * @param type
	 *            the type
	 * @param createdTimeStamp
	 *            the created time stamp
	 * @param updatedTimeStamp
	 *            the updated time stamp
	 * @param createdBy
	 *            the created by
	 * @param updatedBy
	 *            the updated by
	 */
	public Account(Long guid, String userName, String password, String salt, String type, Timestamp createdTimeStamp) {
		super();
		this.guid = guid;
		this.userName = userName;
		this.password = password;
		this.salt = salt;
		this.type = type;
		this.createdTimeStamp = createdTimeStamp;

	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

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
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the salt.
	 *
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * Sets the salt.
	 *
	 * @param salt
	 *            the new salt
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
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

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
