package com.kasisripriyawebapps.myindia.solr.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import com.fasterxml.jackson.annotation.JsonInclude;

@SolrDocument(solrCoreName = "locationMaster")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SolrLocationMaster {

	@Id
	@Field
	private Long locationGuid;

	@Field
	private Long locationCode;

	@Field
	private String locationName;

	@Field
	private String locationType;

	@Field
	private Long parentLocationGuid;

	public Long getLocationGuid() {
		return locationGuid;
	}

	public void setLocationGuid(Long locationGuid) {
		this.locationGuid = locationGuid;
	}

	public Long getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(Long locationCode) {
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

	public Long getParentLocationGuid() {
		return parentLocationGuid;
	}

	public void setParentLocationGuid(Long parentLocationGuid) {
		this.parentLocationGuid = parentLocationGuid;
	}

}
