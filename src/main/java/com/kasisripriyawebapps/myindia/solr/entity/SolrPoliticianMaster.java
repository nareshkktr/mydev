package com.kasisripriyawebapps.myindia.solr.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "PoliticianMaster")
public class SolrPoliticianMaster {

	
	@Id
	@Field
	private Long politicianGuid;
	@Field
	private String fullName;
	@Field
	private String currentDesignation;
	public Long getPoliticianGuid() {
		return politicianGuid;
	}
	public void setPoliticianGuid(Long politicianGuid) {
		this.politicianGuid = politicianGuid;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCurrentDesignation() {
		return currentDesignation;
	}
	public void setCurrentDesignation(String currentDesignation) {
		this.currentDesignation = currentDesignation;
	}
	
	
	
}
