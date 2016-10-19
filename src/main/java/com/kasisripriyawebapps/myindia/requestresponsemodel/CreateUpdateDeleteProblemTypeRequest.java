package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.io.Serializable;

public class CreateUpdateDeleteProblemTypeRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1550141466805782118L;

	public CreateUpdateDeleteProblemTypeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateUpdateDeleteProblemTypeRequest(String problemTypeName, String problemTypePhoto) {
		super();
		this.problemTypeName = problemTypeName;
		this.problemTypePhoto = problemTypePhoto;
	}

	private Long problemTypeId;
	private String problemTypeName;
	private String problemTypePhoto;

	public Long getProblemTypeId() {
		return problemTypeId;
	}

	public void setProblemTypeId(Long problemTypeId) {
		this.problemTypeId = problemTypeId;
	}

	public String getProblemTypeName() {
		return problemTypeName;
	}

	public void setProblemTypeName(String problemTypeName) {
		this.problemTypeName = problemTypeName;
	}

	public String getProblemTypePhoto() {
		return problemTypePhoto;
	}

	public void setProblemTypePhoto(String problemTypePhoto) {
		this.problemTypePhoto = problemTypePhoto;
	}

}
