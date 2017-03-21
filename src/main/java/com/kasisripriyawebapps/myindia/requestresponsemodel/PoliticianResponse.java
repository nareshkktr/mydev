package com.kasisripriyawebapps.myindia.requestresponsemodel;

import com.kasisripriyawebapps.myindia.entity.Location;

public class PoliticianResponse {

	private Long guid;
	private String fullName;
	private String photoURL;
	private Location nativeLocation;
	private String currentDesignation;
	
	public PoliticianResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PoliticianResponse(Long guid, String fullName, String photoURL, Location nativeLocation,
			String currentDesignation) {
		super();
		this.guid = guid;
		this.fullName = fullName;
		this.photoURL = photoURL;
		this.nativeLocation = nativeLocation;
		this.currentDesignation = currentDesignation;
	}

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public Location getNativeLocation() {
		return nativeLocation;
	}

	public void setNativeLocation(Location nativeLocation) {
		this.nativeLocation = nativeLocation;
	}

	public String getCurrentDesignation() {
		return currentDesignation;
	}

	public void setCurrentDesignation(String currentDesignation) {
		this.currentDesignation = currentDesignation;
	}
	
	
}
