package com.kasisripriyawebapps.myindia.requestresponsemodel;


import com.kasisripriyawebapps.myindia.entity.LocationMaster;
import com.kasisripriyawebapps.myindia.entity.ProblemType;

public class CreateProblemRequest {
	
	private LocationMaster createdLocation; 
	
	private String problemShortDescription;

	private String problemLongDescription;
	
	private Long noOfAffectedPeople;
	
	private Long amountInvolved;

	private ProblemType problemType;
	
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

	public ProblemType getProblemType() {
		return problemType;
	}

	public void setProblemType(ProblemType problemType) {
		this.problemType = problemType;
	}
	
	

}
