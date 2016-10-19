/*
 * 
 */
package com.kasisripriyawebapps.myindia.dto;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

// TODO: Auto-generated Javadoc
/**
 * The Class UserElectroralData.
 */
public class UserElectroralData implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -499024233683006009L;

	/** The pc name. */
	@SerializedName("pc_name")
	private String pcName;
	
	/** The state code. */
	@SerializedName("st_code")
	private String stateCode;
	
	/** The gender. */
	@SerializedName("gender")
	private String gender;
	
	/** The father or husband native lang name. */
	@SerializedName("rln_name_v1")
	private String fatherOrHusbandNativeLangName;
	
	/** The user native lang name. */
	@SerializedName("name_v1")
	private String userNativeLangName;
	
	/** The ep ic no. */
	@SerializedName("epic_no")
	private String epIcNo;
	
	/** The assembly constituency name. */
	@SerializedName("ac_name")
	private String assemblyConstituencyName;
	
	/** The polling station lat lang. */
	@SerializedName("ps_lat_long")
	private String pollingStationLatLang;
	
	/** The voter detailslast updated date. */
	@SerializedName("last_update")
	private String voterDetailslastUpdatedDate;
	
	/** The state. */
	@SerializedName("state")
	private String state;
	
	/** The user unique id. */
	@SerializedName("id")
	private String userUniqueId;
	
	/** The polling station name. */
	@SerializedName("ps_name")
	private String pollingStationName;
	
	/** The father or husband. */
	@SerializedName("rln_type")
	private String fatherOrHusband;
	
	/** The part no. */
	@SerializedName("part_no")
	private String partNo;
	
	/** The date of birth. */
	@SerializedName("dob")
	private String dateOfBirth;
	
	/** The district. */
	@SerializedName("district")
	private String district;
	
	/** The user name. */
	@SerializedName("name")
	private String userName;
	
	/** The house no. */
	@SerializedName("house_no")
	private String houseNo;
	
	/** The section no. */
	@SerializedName("section_no")
	private String sectionNo;
	
	/** The assembly constituency no. */
	@SerializedName("ac_no")
	private String assemblyConstituencyNo;
	
	/** The father or husband name. */
	@SerializedName("rln_name")
	private String fatherOrHusbandName;
	
	/** The serial no in part. */
	@SerializedName("slno_inpart")
	private String serialNoInPart;
	
	/** The part name. */
	@SerializedName("part_name")
	private String partName;
	
	/** The age. */
	@SerializedName("age")
	private int age;

	/**
	 * Instantiates a new user electroral data.
	 */
	public UserElectroralData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new user electroral data.
	 *
	 * @param pcName
	 *            the pc name
	 * @param stateCode
	 *            the state code
	 * @param gender
	 *            the gender
	 * @param fatherOrHusbandNativeLangName
	 *            the father or husband native lang name
	 * @param userNativeLangName
	 *            the user native lang name
	 * @param epIcNo
	 *            the ep ic no
	 * @param assemblyConstituencyName
	 *            the assembly constituency name
	 * @param pollingStationLatLang
	 *            the polling station lat lang
	 * @param voterDetailslastUpdatedDate
	 *            the voter detailslast updated date
	 * @param state
	 *            the state
	 * @param userUniqueId
	 *            the user unique id
	 * @param pollingStationName
	 *            the polling station name
	 * @param fatherOrHusband
	 *            the father or husband
	 * @param partNo
	 *            the part no
	 * @param dateOfBirth
	 *            the date of birth
	 * @param district
	 *            the district
	 * @param userName
	 *            the user name
	 * @param houseNo
	 *            the house no
	 * @param sectionNo
	 *            the section no
	 * @param assemblyConstituencyNo
	 *            the assembly constituency no
	 * @param fatherOrHusbandName
	 *            the father or husband name
	 * @param serialNoInPart
	 *            the serial no in part
	 * @param partName
	 *            the part name
	 * @param age
	 *            the age
	 */
	public UserElectroralData(String pcName, String stateCode, String gender, String fatherOrHusbandNativeLangName,
			String userNativeLangName, String epIcNo, String assemblyConstituencyName, String pollingStationLatLang,
			String voterDetailslastUpdatedDate, String state, String userUniqueId, String pollingStationName,
			String fatherOrHusband, String partNo, String dateOfBirth, String district, String userName, String houseNo,
			String sectionNo, String assemblyConstituencyNo, String fatherOrHusbandName, String serialNoInPart,
			String partName, int age) {
		super();
		this.pcName = pcName;
		this.stateCode = stateCode;
		this.gender = gender;
		this.fatherOrHusbandNativeLangName = fatherOrHusbandNativeLangName;
		this.userNativeLangName = userNativeLangName;
		this.epIcNo = epIcNo;
		this.assemblyConstituencyName = assemblyConstituencyName;
		this.pollingStationLatLang = pollingStationLatLang;
		this.voterDetailslastUpdatedDate = voterDetailslastUpdatedDate;
		this.state = state;
		this.userUniqueId = userUniqueId;
		this.pollingStationName = pollingStationName;
		this.fatherOrHusband = fatherOrHusband;
		this.partNo = partNo;
		this.dateOfBirth = dateOfBirth;
		this.district = district;
		this.userName = userName;
		this.houseNo = houseNo;
		this.sectionNo = sectionNo;
		this.assemblyConstituencyNo = assemblyConstituencyNo;
		this.fatherOrHusbandName = fatherOrHusbandName;
		this.serialNoInPart = serialNoInPart;
		this.partName = partName;
		this.age = age;
	}

	/**
	 * Gets the pc name.
	 *
	 * @return the pc name
	 */
	public String getPcName() {
		return pcName;
	}

	/**
	 * Sets the pc name.
	 *
	 * @param pcName
	 *            the new pc name
	 */
	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	/**
	 * Gets the state code.
	 *
	 * @return the state code
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * Sets the state code.
	 *
	 * @param stateCode
	 *            the new state code
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
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
	 * Gets the father or husband native lang name.
	 *
	 * @return the father or husband native lang name
	 */
	public String getFatherOrHusbandNativeLangName() {
		return fatherOrHusbandNativeLangName;
	}

	/**
	 * Sets the father or husband native lang name.
	 *
	 * @param fatherOrHusbandNativeLangName
	 *            the new father or husband native lang name
	 */
	public void setFatherOrHusbandNativeLangName(String fatherOrHusbandNativeLangName) {
		this.fatherOrHusbandNativeLangName = fatherOrHusbandNativeLangName;
	}

	/**
	 * Gets the user native lang name.
	 *
	 * @return the user native lang name
	 */
	public String getUserNativeLangName() {
		return userNativeLangName;
	}

	/**
	 * Sets the user native lang name.
	 *
	 * @param userNativeLangName
	 *            the new user native lang name
	 */
	public void setUserNativeLangName(String userNativeLangName) {
		this.userNativeLangName = userNativeLangName;
	}

	/**
	 * Gets the ep ic no.
	 *
	 * @return the ep ic no
	 */
	public String getEpIcNo() {
		return epIcNo;
	}

	/**
	 * Sets the ep ic no.
	 *
	 * @param epIcNo
	 *            the new ep ic no
	 */
	public void setEpIcNo(String epIcNo) {
		this.epIcNo = epIcNo;
	}

	/**
	 * Gets the assembly constituency name.
	 *
	 * @return the assembly constituency name
	 */
	public String getAssemblyConstituencyName() {
		return assemblyConstituencyName;
	}

	/**
	 * Sets the assembly constituency name.
	 *
	 * @param assemblyConstituencyName
	 *            the new assembly constituency name
	 */
	public void setAssemblyConstituencyName(String assemblyConstituencyName) {
		this.assemblyConstituencyName = assemblyConstituencyName;
	}

	/**
	 * Gets the polling station lat lang.
	 *
	 * @return the polling station lat lang
	 */
	public String getPollingStationLatLang() {
		return pollingStationLatLang;
	}

	/**
	 * Sets the polling station lat lang.
	 *
	 * @param pollingStationLatLang
	 *            the new polling station lat lang
	 */
	public void setPollingStationLatLang(String pollingStationLatLang) {
		this.pollingStationLatLang = pollingStationLatLang;
	}

	/**
	 * Gets the voter detailslast updated date.
	 *
	 * @return the voter detailslast updated date
	 */
	public String getVoterDetailslastUpdatedDate() {
		return voterDetailslastUpdatedDate;
	}

	/**
	 * Sets the voter detailslast updated date.
	 *
	 * @param voterDetailslastUpdatedDate
	 *            the new voter detailslast updated date
	 */
	public void setVoterDetailslastUpdatedDate(String voterDetailslastUpdatedDate) {
		this.voterDetailslastUpdatedDate = voterDetailslastUpdatedDate;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state
	 *            the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the user unique id.
	 *
	 * @return the user unique id
	 */
	public String getUserUniqueId() {
		return userUniqueId;
	}

	/**
	 * Sets the user unique id.
	 *
	 * @param userUniqueId
	 *            the new user unique id
	 */
	public void setUserUniqueId(String userUniqueId) {
		this.userUniqueId = userUniqueId;
	}

	/**
	 * Gets the polling station name.
	 *
	 * @return the polling station name
	 */
	public String getPollingStationName() {
		return pollingStationName;
	}

	/**
	 * Sets the polling station name.
	 *
	 * @param pollingStationName
	 *            the new polling station name
	 */
	public void setPollingStationName(String pollingStationName) {
		this.pollingStationName = pollingStationName;
	}

	/**
	 * Gets the father or husband.
	 *
	 * @return the father or husband
	 */
	public String getFatherOrHusband() {
		return fatherOrHusband;
	}

	/**
	 * Sets the father or husband.
	 *
	 * @param fatherOrHusband
	 *            the new father or husband
	 */
	public void setFatherOrHusband(String fatherOrHusband) {
		this.fatherOrHusband = fatherOrHusband;
	}

	/**
	 * Gets the part no.
	 *
	 * @return the part no
	 */
	public String getPartNo() {
		return partNo;
	}

	/**
	 * Sets the part no.
	 *
	 * @param partNo
	 *            the new part no
	 */
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	/**
	 * Gets the date of birth.
	 *
	 * @return the date of birth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Sets the date of birth.
	 *
	 * @param dateOfBirth
	 *            the new date of birth
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * Gets the district.
	 *
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * Sets the district.
	 *
	 * @param district
	 *            the new district
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName
	 *            the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the house no.
	 *
	 * @return the house no
	 */
	public String getHouseNo() {
		return houseNo;
	}

	/**
	 * Sets the house no.
	 *
	 * @param houseNo
	 *            the new house no
	 */
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	/**
	 * Gets the section no.
	 *
	 * @return the section no
	 */
	public String getSectionNo() {
		return sectionNo;
	}

	/**
	 * Sets the section no.
	 *
	 * @param sectionNo
	 *            the new section no
	 */
	public void setSectionNo(String sectionNo) {
		this.sectionNo = sectionNo;
	}

	/**
	 * Gets the assembly constituency no.
	 *
	 * @return the assembly constituency no
	 */
	public String getAssemblyConstituencyNo() {
		return assemblyConstituencyNo;
	}

	/**
	 * Sets the assembly constituency no.
	 *
	 * @param assemblyConstituencyNo
	 *            the new assembly constituency no
	 */
	public void setAssemblyConstituencyNo(String assemblyConstituencyNo) {
		this.assemblyConstituencyNo = assemblyConstituencyNo;
	}

	/**
	 * Gets the father or husband name.
	 *
	 * @return the father or husband name
	 */
	public String getFatherOrHusbandName() {
		return fatherOrHusbandName;
	}

	/**
	 * Sets the father or husband name.
	 *
	 * @param fatherOrHusbandName
	 *            the new father or husband name
	 */
	public void setFatherOrHusbandName(String fatherOrHusbandName) {
		this.fatherOrHusbandName = fatherOrHusbandName;
	}

	/**
	 * Gets the serial no in part.
	 *
	 * @return the serial no in part
	 */
	public String getSerialNoInPart() {
		return serialNoInPart;
	}

	/**
	 * Sets the serial no in part.
	 *
	 * @param serialNoInPart
	 *            the new serial no in part
	 */
	public void setSerialNoInPart(String serialNoInPart) {
		this.serialNoInPart = serialNoInPart;
	}

	/**
	 * Gets the part name.
	 *
	 * @return the part name
	 */
	public String getPartName() {
		return partName;
	}

	/**
	 * Sets the part name.
	 *
	 * @param partName
	 *            the new part name
	 */
	public void setPartName(String partName) {
		this.partName = partName;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age
	 *            the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((epIcNo == null) ? 0 : epIcNo.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserElectroralData other = (UserElectroralData) obj;
		if (epIcNo == null) {
			if (other.epIcNo != null)
				return false;
		} else if (!epIcNo.equals(other.epIcNo))
			return false;
		return true;
	}

}
