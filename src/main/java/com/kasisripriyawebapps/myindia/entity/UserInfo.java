package com.kasisripriyawebapps.myindia.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "USER_INFO")
public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8003389573773736483L;

	/** The guid. */
	@Id
	@Column(name = "USER_INFO_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	/** The id card type. */
	@Column(name = "ID_CARD_TYPE")
	private String idCardType;

	/** The id card no. */
	@Column(name = "ID_CRAD_NO")
	private String idCardNo;

	/** The gender. */
	@Column(name = "GENDER")
	@SerializedName("gender")
	private String gender;

	/** The father or husband. */
	@Column(name = "FATHER_OR_HUSBAND")
	@SerializedName("rln_type")
	private String fatherOrHusband;

	/** The date of birth. */
	@Column(name = "DATE_OF_BIRTH")
	@SerializedName("dob")
	private String dateOfBirth;

	/** The user name. */
	@Column(name = "USER_NAME")
	@SerializedName("name")
	private String userName;

	/** The house no. */
	@Column(name = "HOUSE_NO")
	@SerializedName("house_no")
	private String houseNo;

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

	/** The created time stamp. */
	@Column(name = "UPTED_TIMESTAMP")
	private Timestamp updatedTimeStamp;

	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_GUID")
	@JsonBackReference
	private Account account;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCATION_GUID")
	@JsonBackReference
	private Location location;

	@OneToMany(mappedBy = "userInfo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<UserImage> userImages = new ArrayList<UserImage>(0);

	@Column(name = "BANNER_PHOTO_URL")
	private String bannerPhotoURL;

	@Column(name = "PHOTO_URL")
	private String photoURL;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Timestamp getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}

	public void setUpdatedTimeStamp(Timestamp updatedTimeStamp) {
		this.updatedTimeStamp = updatedTimeStamp;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<UserImage> getUserImages() {
		return userImages;
	}

	public void setUserImages(List<UserImage> userImages) {
		this.userImages.clear();
		if (userImages != null) {
			this.userImages.addAll(userImages);
		}
	}

	public String getBannerPhotoURL() {
		return bannerPhotoURL;
	}

	public void setBannerPhotoURL(String bannerPhotoURL) {
		this.bannerPhotoURL = bannerPhotoURL;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
