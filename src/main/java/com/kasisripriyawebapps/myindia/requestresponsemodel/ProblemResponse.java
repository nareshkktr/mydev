package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.sql.Timestamp;

import com.kasisripriyawebapps.myindia.entity.LocationMaster;
import com.kasisripriyawebapps.myindia.entity.ProblemType;



public class ProblemResponse {
	
	private Long guid;
	private LocationMaster createdLocation;
	private String problemShortDescription;
	private String problemLongDescription;
	private String rootCause;
	private String problemStatus;
	private String problemSeverity;
	private String photoURL;
	private Long noOfAffectedPeople;
	private Long amountInvolved;
	private Timestamp createdTimeStamp;
	private Boolean escalationEnabled;
	private BaseUserInformation createdBy;
	private PoliticianResponse owner;
	private ProblemType problemType;
	
	
	public Long getGuid() {
		return guid;
	}
	public void setGuid(Long guid) {
		this.guid = guid;
	}
	public LocationMaster getCreatedLocation() {
		return createdLocation;
	}
	public void setCreatedLocation(LocationMaster createdLocation) {
		this.createdLocation = createdLocation;
	}
	public String getProblemShortDescription() {
		return problemShortDescription;
	}
	public void setProblemShortDescription(String problemShortDescription) {
		this.problemShortDescription = problemShortDescription;
	}
	public String getProblemLongDescription() {
		return problemLongDescription;
	}
	public void setProblemLongDescription(String problemLongDescription) {
		this.problemLongDescription = problemLongDescription;
	}
	public String getRootCause() {
		return rootCause;
	}
	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}
	public String getProblemStatus() {
		return problemStatus;
	}
	public void setProblemStatus(String problemStatus) {
		this.problemStatus = problemStatus;
	}
	public String getProblemSeverity() {
		return problemSeverity;
	}
	public void setProblemSeverity(String problemSeverity) {
		this.problemSeverity = problemSeverity;
	}
	public String getPhotoURL() {
		return photoURL;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}
	public Long getNoOfAffectedPeople() {
		return noOfAffectedPeople;
	}
	public void setNoOfAffectedPeople(Long noOfAffectedPeople) {
		this.noOfAffectedPeople = noOfAffectedPeople;
	}
	public Long getAmountInvolved() {
		return amountInvolved;
	}
	public void setAmountInvolved(Long amountInvolved) {
		this.amountInvolved = amountInvolved;
	}
	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}
	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}
	public Boolean getEscalationEnabled() {
		return escalationEnabled;
	}
	public void setEscalationEnabled(Boolean escalationEnabled) {
		this.escalationEnabled = escalationEnabled;
	}
	public BaseUserInformation getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(BaseUserInformation createdBy) {
		this.createdBy = createdBy;
	}
	public ProblemType getProblemType() {
		return problemType;
	}
	public void setProblemType(ProblemType problemType) {
		this.problemType = problemType;
	}
	public PoliticianResponse getOwner() {
		return owner;
	}
	public void setOwner(PoliticianResponse owner) {
		this.owner = owner;
	}
}
