package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.io.Serializable;

import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;

public class CreateUpdateProblemRequestData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8369176558905441280L;

	private Long problemGuId;
	private String problemName;
	private String problemDesc;
	private String problemMainPhoto;
	private SolrLocationMaster problemLocation;
	private String problemPhoto;
	private Long problemTypeGuId;
	private Long noOfAffectdCitizens;
	private Long moneyAtStake;

	public Long getProblemGuId() {
		return problemGuId;
	}

	public void setProblemGuId(Long problemGuId) {
		this.problemGuId = problemGuId;
	}

	public String getProblemName() {
		return problemName;
	}

	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}

	public String getProblemDesc() {
		return problemDesc;
	}

	public void setProblemDesc(String problemDesc) {
		this.problemDesc = problemDesc;
	}

	public String getProblemMainPhoto() {
		return problemMainPhoto;
	}

	public void setProblemMainPhoto(String problemMainPhoto) {
		this.problemMainPhoto = problemMainPhoto;
	}

	public SolrLocationMaster getProblemLocation() {
		return problemLocation;
	}

	public void setProblemLocation(SolrLocationMaster problemLocation) {
		this.problemLocation = problemLocation;
	}

	public String getProblemPhoto() {
		return problemPhoto;
	}

	public void setProblemPhoto(String problemPhoto) {
		this.problemPhoto = problemPhoto;
	}

	public Long getProblemTypeGuId() {
		return problemTypeGuId;
	}

	public void setProblemTypeGuId(Long problemTypeGuId) {
		this.problemTypeGuId = problemTypeGuId;
	}

	public Long getNoOfAffectdCitizens() {
		return noOfAffectdCitizens;
	}

	public void setNoOfAffectdCitizens(Long noOfAffectdCitizens) {
		this.noOfAffectdCitizens = noOfAffectdCitizens;
	}

	public Long getMoneyAtStake() {
		return moneyAtStake;
	}

	public void setMoneyAtStake(Long moneyAtStake) {
		this.moneyAtStake = moneyAtStake;
	}

}
