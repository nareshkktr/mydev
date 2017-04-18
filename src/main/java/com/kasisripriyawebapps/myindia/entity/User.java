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

	/** The gender. */
	@Column(name = "GENDER")
	private String gender;

	/** The assembly constituency name. */
	@Column(name = "ASSEMBLY_CONSTITUENCY_NAME")
	private String assemblyConstituencyName;

	/** The state. */
	@Column(name = "LOCATION_STATE")
	private String state;

	/** The father or husband. */
	@Column(name = "REFERENCE_TYPE")
	private String referenceType;

	/** The district. */
	@Column(name = "LOCATION_DISTRICT")
	private String district;

	/** The user name. */
	@Column(name = "ELECTOR_NAME")
	private String electorName;

	/** The house no. */
	@Column(name = "HOUSE_NO")
	private String houseNo;

	/** The assembly constituency no. */
	@Column(name = "ASSEMBLY_CONSTITUENCT_NO")
	private Integer assemblyConstituencyNo;

	/** The father or husband name. */
	@Column(name = "REFERENCE_NAME")
	private String referenceName;

	/** The age. */
	@Column(name = "AGE")
	private int age;

	@Column(name = "PARLIAMENTARY_CONSTITUENCY_NAME")
	private String parliamentaryConstituencyName;

	@Column(name = "PARLIAMENTARY_CONSTITUENCT_NO")
	private Integer parliamentaryConstituencyNo;

	@Column(name = "LOCATION_MANDAL")
	private String mandal;

	@Column(name = "LOCATION_PINCODE")
	private String pincode;

	@Column(name = "POLICE_STATION")
	private String policeStation;

	@Column(name = "MAIN_TOWN")
	private String mainTwon;

	@Column(name = "REVENUE_DIVISION")
	private String revenueDivision;

	/** The created time stamp. */
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	/** The created time stamp. */
	@Column(name = "UPDATED_TIMESTAMP")
	private Timestamp updatedTimeStamp;

	@Column(name = "PART_NO")
	private Integer partNo;

	@Column(name = "POLLING_STATION")
	private String pollingStation;

	@Column(name = "POLLING_STATION_ADDRESS")
	private String pollingStationAddress;
	
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private UserInfo userInfo;

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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
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

	public Integer getAssemblyConstituencyNo() {
		return assemblyConstituencyNo;
	}

	public void setAssemblyConstituencyNo(Integer assemblyConstituencyNo) {
		this.assemblyConstituencyNo = assemblyConstituencyNo;
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

	public String getParliamentaryConstituencyName() {
		return parliamentaryConstituencyName;
	}

	public void setParliamentaryConstituencyName(String parliamentaryConstituencyName) {
		this.parliamentaryConstituencyName = parliamentaryConstituencyName;
	}

	public Integer getParliamentaryConstituencyNo() {
		return parliamentaryConstituencyNo;
	}

	public void setParliamentaryConstituencyNo(Integer parliamentaryConstituencyNo) {
		this.parliamentaryConstituencyNo = parliamentaryConstituencyNo;
	}

	public String getMandal() {
		return mandal;
	}

	public void setMandal(String mandal) {
		this.mandal = mandal;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	public String getMainTwon() {
		return mainTwon;
	}

	public void setMainTwon(String mainTwon) {
		this.mainTwon = mainTwon;
	}

	public String getRevenueDivision() {
		return revenueDivision;
	}

	public void setRevenueDivision(String revenueDivision) {
		this.revenueDivision = revenueDivision;
	}

	public Integer getPartNo() {
		return partNo;
	}

	public void setPartNo(Integer partNo) {
		this.partNo = partNo;
	}

	public Timestamp getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}

	public void setUpdatedTimeStamp(Timestamp updatedTimeStamp) {
		this.updatedTimeStamp = updatedTimeStamp;
	}

	public String getElectorName() {
		return electorName;
	}

	public void setElectorName(String electorName) {
		this.electorName = electorName;
	}

	public String getPollingStation() {
		return pollingStation;
	}

	public void setPollingStation(String pollingStation) {
		this.pollingStation = pollingStation;
	}

	public String getPollingStationAddress() {
		return pollingStationAddress;
	}

	public void setPollingStationAddress(String pollingStationAddress) {
		this.pollingStationAddress = pollingStationAddress;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCardNo == null) ? 0 : idCardNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (idCardNo == null) {
			if (other.idCardNo != null)
				return false;
		} else if (!idCardNo.equals(other.idCardNo))
			return false;
		return true;
	}

	
}
