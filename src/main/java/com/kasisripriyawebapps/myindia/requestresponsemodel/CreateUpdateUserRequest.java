/*
 * 
 */
package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.sql.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateUpdateUserRequest.
 */
public class CreateUpdateUserRequest {

	/**
	 * Instantiates a new creates the update user request.
	 */
	public CreateUpdateUserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new creates the update user request.
	 *
	 * @param guid
	 *            the guid
	 * @param firstName
	 *            the first name
	 * @param lastName
	 *            the last name
	 * @param fullName
	 *            the full name
	 * @param nickName
	 *            the nick name
	 * @param gender
	 *            the gender
	 * @param dateOfBirth
	 *            the date of birth
	 * @param locationGuid
	 *            the location guid
	 * @param phoneNo
	 *            the phone no
	 * @param alternatePhoneNo
	 *            the alternate phone no
	 * @param iDCardType
	 *            the i d card type
	 * @param iDCardNo
	 *            the i d card no
	 * @param occupation
	 *            the occupation
	 * @param accountGuid
	 *            the account guid
	 */
	public CreateUpdateUserRequest(Long guid, String firstName, String lastName, String fullName, String nickName,
			String gender, Date dateOfBirth, Long locationGuid, Long phoneNo, Long alternatePhoneNo, String iDCardType,
			String iDCardNo, String occupation, Long accountGuid) {
		super();
		this.guid = guid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.nickName = nickName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.locationGuid = locationGuid;
		this.phoneNo = phoneNo;
		this.alternatePhoneNo = alternatePhoneNo;
		idCardType = iDCardType;
		idCardNo = iDCardNo;
		this.occupation = occupation;
		this.accountGuid = accountGuid;
	}

	/** The guid. */
	private Long guid;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The full name. */
	private String fullName;
	
	/** The nick name. */
	private String nickName;
	
	/** The gender. */
	private String gender;
	
	/** The date of birth. */
	private Date dateOfBirth;
	
	/** The location guid. */
	private Long locationGuid;
	
	/** The phone no. */
	private Long phoneNo;
	
	/** The alternate phone no. */
	private Long alternatePhoneNo;
	
	/** The id card type. */
	private String idCardType;
	
	/** The id card no. */
	private String idCardNo;
	
	/** The occupation. */
	private String occupation;
	
	/** The account guid. */
	private Long accountGuid;
	

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
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the full name.
	 *
	 * @return the full name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Sets the full name.
	 *
	 * @param fullName
	 *            the new full name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Gets the nick name.
	 *
	 * @return the nick name
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * Sets the nick name.
	 *
	 * @param nickName
	 *            the new nick name
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender
	 *            the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the date of birth.
	 *
	 * @return the date of birth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Sets the date of birth.
	 *
	 * @param dateOfBirth
	 *            the new date of birth
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Gets the location guid.
	 *
	 * @return the location guid
	 */
	public Long getLocationGuid() {
		return locationGuid;
	}

	/**
	 * Sets the location guid.
	 *
	 * @param locationGuid
	 *            the new location guid
	 */
	public void setLocationGuid(Long locationGuid) {
		this.locationGuid = locationGuid;
	}

	/**
	 * Gets the phone no.
	 *
	 * @return the phone no
	 */
	public Long getPhoneNo() {
		return phoneNo;
	}

	/**
	 * Sets the phone no.
	 *
	 * @param phoneNo
	 *            the new phone no
	 */
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	/**
	 * Gets the alternate phone no.
	 *
	 * @return the alternate phone no
	 */
	public Long getAlternatePhoneNo() {
		return alternatePhoneNo;
	}

	/**
	 * Sets the alternate phone no.
	 *
	 * @param alternatePhoneNo
	 *            the new alternate phone no
	 */
	public void setAlternatePhoneNo(Long alternatePhoneNo) {
		this.alternatePhoneNo = alternatePhoneNo;
	}

	
	/**
	 * Gets the ID card type.
	 *
	 * @return the ID card type
	 */
	public String getIdCardType() {
		return idCardType;
	}

	/**
	 * Sets the ID card type.
	 *
	 * @param idCardType
	 *            the new ID card type
	 */
	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}

	/**
	 * Gets the ID card no.
	 *
	 * @return the ID card no
	 */
	public String getIdCardNo() {
		return idCardNo;
	}

	/**
	 * Sets the ID card no.
	 *
	 * @param idCardNo
	 *            the new ID card no
	 */
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	/**
	 * Gets the occupation.
	 *
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * Sets the occupation.
	 *
	 * @param occupation
	 *            the new occupation
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/**
	 * Gets the account guid.
	 *
	 * @return the account guid
	 */
	public Long getAccountGuid() {
		return accountGuid;
	}

	/**
	 * Sets the account guid.
	 *
	 * @param accountGuid
	 *            the new account guid
	 */
	public void setAccountGuid(Long accountGuid) {
		this.accountGuid = accountGuid;
	}

}
