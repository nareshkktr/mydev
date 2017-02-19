package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetUserByPropertyResponse {

	private Long userGuid;
	private String referenceType;
	private String referenceName;
	private String locationState;
	private String locationDistrict;
	private String locationMandal;

	private List<SolrLocationMaster> locations = null;

	public Long getUserGuid() {
		return userGuid;
	}

	public void setUserGuid(Long userGuid) {
		this.userGuid = userGuid;
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

	public String getLocationState() {
		return locationState;
	}

	public void setLocationState(String locationState) {
		this.locationState = locationState;
	}

	public String getLocationDistrict() {
		return locationDistrict;
	}

	public void setLocationDistrict(String locationDistrict) {
		this.locationDistrict = locationDistrict;
	}

	public String getLocationMandal() {
		return locationMandal;
	}

	public void setLocationMandal(String locationMandal) {
		this.locationMandal = locationMandal;
	}

	public List<SolrLocationMaster> getLocations() {
		return locations;
	}

	public void setLocations(List<SolrLocationMaster> locations) {
		this.locations = locations;
	}

}
