package com.kasisripriyawebapps.myindia.requestresponsemodel;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseUserInformation {
	
	private Long userGuid;
	private String name;
	private String userImage;
	private String gender;
	private String userName;
	private String accessToken;
	private String refreshToken;
	private Integer expirationTimeInSeconds;
	private UserLocationDetails userLocation;
	private Long accountGuid;
	private String currentDesignation;
	

	public BaseUserInformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public BaseUserInformation(Long userGuid, String name, String userImage, String gender, String userName,
			String accessToken, UserLocationDetails userLocation) {
		super();
		this.userGuid = userGuid;
		this.name = name;
		this.userImage = userImage;
		this.gender = gender;
		this.userName = userName;
		this.accessToken = accessToken;
		this.userLocation = userLocation;
	}



	public Long getUserGuid() {
		return userGuid;
	}

	public void setUserGuid(Long userGuid) {
		this.userGuid = userGuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public UserLocationDetails getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(UserLocationDetails userLocation) {
		this.userLocation = userLocation;
	}
	
	public String getRefreshToken() {
		return refreshToken;
	}
	
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Integer getExpirationTimeInSeconds() {
		return expirationTimeInSeconds;
	}

	public void setExpirationTimeInSeconds(Integer expirationTimeInSeconds) {
		this.expirationTimeInSeconds = expirationTimeInSeconds;
	}

	public Long getAccountGuid() {
		return accountGuid;
	}

	public void setAccountGuid(Long accountGuid) {
		this.accountGuid = accountGuid;
	}



	public String getCurrentDesignation() {
		return currentDesignation;
	}



	public void setCurrentDesignation(String currentDesignation) {
		this.currentDesignation = currentDesignation;
	}
	
	

}
