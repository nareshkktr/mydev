package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.io.Serializable;

public class PartyResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5617901397817174006L;
	private Long guid;
	private String partyName;
	private String partyAbbrevation;
	private String photoURL;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getPartyAbbrevation() {
		return partyAbbrevation;
	}

	public void setPartyAbbrevation(String partyAbbrevation) {
		this.partyAbbrevation = partyAbbrevation;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

}
