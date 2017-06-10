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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "USER_INFO")
@NamedQueries({
		@NamedQuery(name = "UPDATE_USER_LOCATION_REF_ID", query = "update UserInfo ui set ui.nativeLocation.guid=:locationGuid") })
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
	private String gender;

	@Column(name = "REFERENCE_TYPE")
	private String referenceType;

	/** The date of birth. */
	@Column(name = "DATE_OF_BIRTH")
	private String dateOfBirth;

	/** The user name. */
	@Column(name = "USER_NAME")
	private String electorName;

	/** The house no. */
	@Column(name = "HOUSE_NO")
	private String houseNo;

	@Column(name = "REFERENCE_NAME")
	private String referenceName;

	/** The age. */
	@Column(name = "AGE")
	private int age;

	/** The created time stamp. */
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	/** The created time stamp. */
	@Column(name = "UPTED_TIMESTAMP")
	private Timestamp updatedTimeStamp;

	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;

	@Column(name = "LOCATION_PINCODE")
	private String pincode;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "userInfo", cascade = CascadeType.ALL)
	private Account account;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_GUID")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "LOCATION_REF_GUID")
	private Location nativeLocation;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "LOCATION_GUID")
	private LocationMaster masterLocation;

	@OneToMany(mappedBy = "userInfo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<UserImage> userImages = new ArrayList<UserImage>(0);

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_POLITICAL_LOCATION", catalog = "myindia", joinColumns = {
			@JoinColumn(name = "USER_INFO_GUID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "LOCATION_GUID", nullable = false, updatable = false) })
	private List<LocationMaster> userPoliticalLocations = new ArrayList<LocationMaster>(0);

	@Column(name = "BANNER_PHOTO_URL")
	private String bannerPhotoURL;

	@Column(name = "PHOTO_URL")
	private String photoURL;

	@Column(name = "OCCUPATION")
	private String occupation;

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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getElectorName() {
		return electorName;
	}

	public void setElectorName(String electorName) {
		this.electorName = electorName;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
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

	public List<LocationMaster> getUserPoliticalLocations() {
		return userPoliticalLocations;
	}

	public void setUserPoliticalLocations(List<LocationMaster> userPoliticalLocations) {
		this.userPoliticalLocations.clear();
		if (userPoliticalLocations != null) {
			this.userPoliticalLocations.addAll(userPoliticalLocations);
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

	public Location getNativeLocation() {
		return nativeLocation;
	}

	public void setNativeLocation(Location nativeLocation) {
		this.nativeLocation = nativeLocation;
	}

	public String getReferenceType() {
		return referenceType;
	}

	public void setReferenceType(String referenceType) {
		this.referenceType = referenceType;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocationMaster getMasterLocation() {
		return masterLocation;
	}

	public void setMasterLocation(LocationMaster masterLocation) {
		this.masterLocation = masterLocation;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

}
