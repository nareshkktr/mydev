package com.kasisripriyawebapps.myindia.solr.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import com.fasterxml.jackson.annotation.JsonInclude;

@SolrDocument(solrCoreName = "politicianAuthority")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SolrPoliticianAuthorityMaster {

	@Id
	@Field
	private Long politicianAuthorityGuid;

	@Field
	private Long locationGuid;

	@Field
	private String designation;

	@Field
	private Boolean isActive;

	@Field
	private Long politicianGuid;

	@Field
	private Long partyGuid;

	public Long getPoliticianAuthorityGuid() {
		return politicianAuthorityGuid;
	}

	public void setPoliticianAuthorityGuid(Long politicianAuthorityGuid) {
		this.politicianAuthorityGuid = politicianAuthorityGuid;
	}

	public Long getLocationGuid() {
		return locationGuid;
	}

	public void setLocationGuid(Long locationGuid) {
		this.locationGuid = locationGuid;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getPoliticianGuid() {
		return politicianGuid;
	}

	public void setPoliticianGuid(Long politicianGuid) {
		this.politicianGuid = politicianGuid;
	}

	public Long getPartyGuid() {
		return partyGuid;
	}

	public void setPartyGuid(Long partyGuid) {
		this.partyGuid = partyGuid;
	}

}
