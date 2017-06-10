package com.kasisripriyawebapps.myindia.requestresponsemodel;

public class ValidateElectorDetailsRequest {

	private String idCardNo;
	private String referenceName;
	private String electorName;
	private String gender;
	private Integer yearOfBirth;

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public String getElectorName() {
		return electorName;
	}

	public void setElectorName(String electorName) {
		this.electorName = electorName;
	}

	public Integer getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(Integer yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
