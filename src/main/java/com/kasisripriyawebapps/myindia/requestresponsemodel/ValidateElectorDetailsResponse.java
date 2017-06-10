package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValidateElectorDetailsResponse {

	private Long userGuid;
	private String locationState;
	private String locationDistrict;
	private String locationMandal;
	private String mainTown;
	private List<SolrLocationMaster> locations;
	private List<UserOccupationResponse> occupations;

	public Long getUserGuid() {
		return userGuid;
	}

	public void setUserGuid(Long userGuid) {
		this.userGuid = userGuid;
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

	public String getMainTown() {
		return mainTown;
	}

	public void setMainTown(String mainTown) {
		this.mainTown = mainTown;
	}

	public List<UserOccupationResponse> getOccupations() {
		return occupations;
	}

	public void setOccupations(List<UserOccupationResponse> occupations) {
		this.occupations = occupations;
	}

}
