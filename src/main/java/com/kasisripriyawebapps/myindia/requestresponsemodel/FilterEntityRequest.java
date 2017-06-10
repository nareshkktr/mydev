package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

public class FilterEntityRequest {
	
	private String locationName;
	private String objectName;
	private List<String> supportingFields;
	private Set<String> tokens;
	private String objectType;
	private Integer pageNo;
	private Integer pageLimit;

	public FilterEntityRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FilterEntityRequest(String locationName, String objectName, List<String> supportingFields,
			Set<String> tokens, String objectType) {
		super();
		this.locationName = locationName;
		this.objectName = objectName;
		this.supportingFields = supportingFields;
		this.tokens = tokens;
		this.objectType = objectType;
	}



	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public List<String> getSupportingFields() {
		return supportingFields;
	}
	public void setSupportingFields(List<String> supportingFields) {
		this.supportingFields = supportingFields;
	}
	public Set<String> getTokens() {
		
		this.tokens = new HashSet<String>();
		
		if(this.locationName != null){
			this.tokens.add(tokenize(this.locationName));
		}
		if(this.objectName != null){
			this.tokens.add(tokenize(this.objectName));
		}
		if(this.supportingFields != null && !this.supportingFields.isEmpty()){
			for(String tag: this.supportingFields){
				this.tokens.add(tokenize(tag));
			}
		}
		
		return this.tokens;
	}
	
	private String tokenize(String tag){
		
		Set<String> tokens = new HashSet<String>();
		StringTokenizer multiTokenizer = new StringTokenizer(tag," ,");
		while (multiTokenizer.hasMoreTokens())
		{
			tokens.add(multiTokenizer.nextToken());
		}
		
		return ".*("+StringUtils.join(tokens, "|")+").*";
		
	}
	
	public void setTokens(Set<String> tokens) {
		this.tokens = tokens;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(Integer pageLimit) {
		this.pageLimit = pageLimit;
	}
	
	
}
