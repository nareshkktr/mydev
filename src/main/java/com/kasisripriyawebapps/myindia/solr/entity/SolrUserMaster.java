package com.kasisripriyawebapps.myindia.solr.entity;

import java.sql.Timestamp;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "userMaster")
public class SolrUserMaster {

	@Id
	@Field
	private Long userGuid;
	@Field
	private String idCardType;
	@Field
	private String idCardNo;
	@Field
	private String gender;
	@Field
	private String assemblyConstituencyName;
	@Field
	private String state;
	@Field
	private String referenceType;
	@Field
	private String district;
	@Field
	private String electorName;
	@Field
	private String houseNo;
	@Field
	private Integer assemblyConstituencyNo;
	@Field
	private String referenceName;
	@Field
	private Integer age;
	@Field
	private String parliamentaryConstituencyName;
	@Field
	private Integer parliamentaryConstituencyNo;
	@Field
	private String mandal;
	@Field
	private String pincode;
	@Field
	private String policeStation;
	@Field
	private String mainTwon;
	@Field
	private String revenueDivision;
	@Field
	private Timestamp createdTimeStamp;
	@Field
	private Timestamp updatedTimeStamp;
	@Field
	private Integer partNo;
	@Field
	private String pollingStation;
	@Field
	private String pollingStationAddress;

	public Long getUserGuid() {
		return userGuid;
	}

	public void setUserGuid(Long userGuid) {
		this.userGuid = userGuid;
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

	public String getReferenceType() {
		return referenceType;
	}

	public void setReferenceType(String referenceType) {
		this.referenceType = referenceType;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public Integer getAssemblyConstituencyNo() {
		return assemblyConstituencyNo;
	}

	public void setAssemblyConstituencyNo(Integer assemblyConstituencyNo) {
		this.assemblyConstituencyNo = assemblyConstituencyNo;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	public Integer getPartNo() {
		return partNo;
	}

	public void setPartNo(Integer partNo) {
		this.partNo = partNo;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCardNo == null) ? 0 : idCardNo.hashCode());
		result = prime * result + ((idCardType == null) ? 0 : idCardType.hashCode());
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
		SolrUserMaster other = (SolrUserMaster) obj;
		if (idCardNo == null) {
			if (other.idCardNo != null)
				return false;
		} else if (!idCardNo.equals(other.idCardNo))
			return false;
		if (idCardType == null) {
			if (other.idCardType != null)
				return false;
		} else if (!idCardType.equals(other.idCardType))
			return false;
		return true;
	}

}
