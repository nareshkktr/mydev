package com.kasisripriyawebapps.myindia.solr.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import com.fasterxml.jackson.annotation.JsonInclude;

@SolrDocument(solrCoreName = "globalSearch")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SolrGlobalSearchMaster {

	@Id
	@Field
	private Long objectGuid;

	@Field
	private String objectName;

	@Field
	private String objectType;

	@Field
	private String objectSubType;

	public Long getObjectGuid() {
		return objectGuid;
	}

	public void setObjectGuid(Long objectGuid) {
		this.objectGuid = objectGuid;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getObjectSubType() {
		return objectSubType;
	}

	public void setObjectSubType(String objectSubType) {
		this.objectSubType = objectSubType;
	}

}
