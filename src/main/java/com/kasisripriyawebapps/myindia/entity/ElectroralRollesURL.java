package com.kasisripriyawebapps.myindia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ELECTRORAL_ROLLES_URL")
public class ElectroralRollesURL {

	@Id
	@Column(name = "ELECTRORAL_ROLLES_URL_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@Column(name = "STATE_NAME")
	private String stateName;

	@Column(name = "DISTRICT_NAME")
	private String districtName;

	@Column(name = "MLA_CONSTITUENCY_NAME")
	private String mlaConstituencyName;

	@Column(name = "MLA_CONSTITUENCY_NO")
	private Integer mlaConstituencyNo;

	@Column(name = "POLLING_STATION_NAME")
	private String pollingStationName;

	@Column(name = "POLLING_STATION_ADDRESS")
	private String pollingStationAddress;

	@Column(name = "PDF_URL")
	private String pdfUrl;

	@Column(name = "partNo")
	private Integer partNo;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getPollingStationName() {
		return pollingStationName;
	}

	public void setPollingStationName(String pollingStationName) {
		this.pollingStationName = pollingStationName;
	}

	public String getPdfUrl() {
		return pdfUrl;
	}

	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}

	public String getPollingStationAddress() {
		return pollingStationAddress;
	}

	public void setPollingStationAddress(String pollingStationAddress) {
		this.pollingStationAddress = pollingStationAddress;
	}

	public String getMlaConstituencyName() {
		return mlaConstituencyName;
	}

	public void setMlaConstituencyName(String mlaConstituencyName) {
		this.mlaConstituencyName = mlaConstituencyName;
	}

	public Integer getMlaConstituencyNo() {
		return mlaConstituencyNo;
	}

	public void setMlaConstituencyNo(Integer mlaConstituencyNo) {
		this.mlaConstituencyNo = mlaConstituencyNo;
	}

	public Integer getPartNo() {
		return partNo;
	}

	public void setPartNo(Integer partNo) {
		this.partNo = partNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((districtName == null) ? 0 : districtName.hashCode());
		result = prime * result + ((mlaConstituencyName == null) ? 0 : mlaConstituencyName.hashCode());
		result = prime * result + ((partNo == null) ? 0 : partNo.hashCode());
		result = prime * result + ((pollingStationAddress == null) ? 0 : pollingStationAddress.hashCode());
		result = prime * result + ((stateName == null) ? 0 : stateName.hashCode());
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
		ElectroralRollesURL other = (ElectroralRollesURL) obj;
		if (districtName == null) {
			if (other.districtName != null)
				return false;
		} else if (!districtName.equals(other.districtName))
			return false;
		if (mlaConstituencyName == null) {
			if (other.mlaConstituencyName != null)
				return false;
		} else if (!mlaConstituencyName.equals(other.mlaConstituencyName))
			return false;
		if (partNo == null) {
			if (other.partNo != null)
				return false;
		} else if (!partNo.equals(other.partNo))
			return false;
		if (pollingStationAddress == null) {
			if (other.pollingStationAddress != null)
				return false;
		} else if (!pollingStationAddress.equals(other.pollingStationAddress))
			return false;
		if (stateName == null) {
			if (other.stateName != null)
				return false;
		} else if (!stateName.equals(other.stateName))
			return false;
		return true;
	}

}
