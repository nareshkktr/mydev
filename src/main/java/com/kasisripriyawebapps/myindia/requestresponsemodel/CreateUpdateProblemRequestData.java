package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.io.Serializable;

import com.kasisripriyawebapps.myindia.entity.ProblemType;
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
	private ProblemType problemType;
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

	public ProblemType getProblemType() {
		return problemType;
	}

	public void setProblemType(ProblemType problemType) {
		this.problemType = problemType;
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
