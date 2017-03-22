package com.kasisripriyawebapps.myindia.requestresponsemodel;

public class ProblemTypeResponse {
	
	private Long problemTypeGuid;

	private String problemTypeName;

	private String problemTypeMinistry;

	private String problemTypePhotoURL;
	
	private String problemCategory;

	public Long getProblemTypeGuid() {
		return problemTypeGuid;
	}

	public void setProblemTypeGuid(Long problemTypeGuid) {
		this.problemTypeGuid = problemTypeGuid;
	}

	public String getProblemTypeName() {
		return problemTypeName;
	}

	public void setProblemTypeName(String problemTypeName) {
		this.problemTypeName = problemTypeName;
	}

	public String getProblemTypeMinistry() {
		return problemTypeMinistry;
	}

	public void setProblemTypeMinistry(String problemTypeMinistry) {
		this.problemTypeMinistry = problemTypeMinistry;
	}

	public String getProblemTypePhotoURL() {
		return problemTypePhotoURL;
	}

	public void setProblemTypePhotoURL(String problemTypePhotoURL) {
		this.problemTypePhotoURL = problemTypePhotoURL;
	}

	public String getProblemCategory() {
		return problemCategory;
	}

	public void setProblemCategory(String problemCategory) {
		this.problemCategory = problemCategory;
	}
	
	

}
