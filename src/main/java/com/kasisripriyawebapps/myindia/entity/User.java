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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.annotations.SerializedName;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@Table(name = "USER_MASTER")
public class User implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -195951950816506448L;

	/**
	 * Instantiates a new user entity.
	 */
	public User() {
		super();
	}

	/** The guid. */
	@Id
	@Column(name = "USER_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	/** The id card type. */
	@Column(name = "ID_CARD_TYPE")
	private String idCardType;

	/** The id card no. */
	@Column(name = "ID_CARD_NO")
	private String idCardNo;

	/** The pc name. */
	@Column(name = "PC_NAME")
	@SerializedName("pc_name")
	private String pcName;

	/** The gender. */
	@Column(name = "GENDER")
	@SerializedName("gender")
	private String gender;

	/** The assembly constituency name. */
	@Column(name = "ASSEMBLY_CONSTITUENCY_NAME")
	@SerializedName("ac_name")
	private String assemblyConstituencyName;

	/** The state. */
	@Column(name = "LOCATION_STATE")
	@SerializedName("state")
	private String state;

	/** The father or husband. */
	@Column(name = "FATHER_OR_HUSBAND")
	@SerializedName("rln_type")
	private String fatherOrHusband;

	/** The date of birth. */
	@Column(name = "DATE_OF_BIRTH")
	@SerializedName("dob")
	private String dateOfBirth;

	/** The district. */
	@Column(name = "LOCATION_DISTRICT")
	@SerializedName("district")
	private String district;

	/** The user name. */
	@Column(name = "USER_NAME")
	@SerializedName("name")
	private String userName;

	/** The house no. */
	@Column(name = "HOUSE_NO")
	@SerializedName("house_no")
	private String houseNo;

	/** The assembly constituency no. */
	@Column(name = "ASSEMBLY_CONSTITUENCT_NO")
	@SerializedName("ac_no")
	private String assemblyConstituencyNo;

	/** The father or husband name. */
	@Column(name = "FATHER_HUSBAND_NAME")
	@SerializedName("rln_name")
	private String fatherOrHusbandName;

	/** The age. */
	@Column(name = "AGE")
	@SerializedName("age")
	private int age;

	/** The created time stamp. */
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Account account;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getPcName() {
		return pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAssemblyConstituencyName() {
		return assemblyConstituencyName;
	}

	public void setAssemblyConstituencyName(String assemblyConstituencyName) {
		this.assemblyConstituencyName = assemblyConstituencyName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFatherOrHusband() {
		return fatherOrHusband;
	}

	public void setFatherOrHusband(String fatherOrHusband) {
		this.fatherOrHusband = fatherOrHusband;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getAssemblyConstituencyNo() {
		return assemblyConstituencyNo;
	}

	public void setAssemblyConstituencyNo(String assemblyConstituencyNo) {
		this.assemblyConstituencyNo = assemblyConstituencyNo;
	}

	public String getFatherOrHusbandName() {
		return fatherOrHusbandName;
	}

	public void setFatherOrHusbandName(String fatherOrHusbandName) {
		this.fatherOrHusbandName = fatherOrHusbandName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
