package com.kasisripriyawebapps.myindia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATION_MASTER")
public class LocationMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8443244270848172413L;
	@Id
	@Column(name = "LOCATION_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	/** The location type. */
	@Column(name = "LOCATION_CODE")
	private String locationCode;

	/** The location name. */
	@Column(name = "LOCATION_NAME")
	private String locationName;

	/** The location type. */
	@Column(name = "LOCATION_TYPE")
	private String locationType;
	
	@Column(name = "PARENT_LOCATION_CODE")
	private String parentLocationCode;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getParentLocationCode() {
		return parentLocationCode;
	}

	public void setParentLocationCode(String parentLocationCode) {
		this.parentLocationCode = parentLocationCode;
	}

	
	
}
