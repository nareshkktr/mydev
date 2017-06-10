package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityResponse {

	private Long guid;

	// Activity details
	private String activityName;
	private String activityContent;
	private String activityType;
	private Long activityGuid;

	// On Object details
	private String onObjectType;
	private String onObjectName;
	private String onObjectImage;
	private Long onObjectGuid;

	// By Object details
	private BaseUserInformation userInfo;

	private Timestamp createdTimestamp;

	private String loggedTimeShort;

	private String loggedTimeLong;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityContent() {
		return activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public Long getActivityGuid() {
		return activityGuid;
	}

	public void setActivityGuid(Long activityGuid) {
		this.activityGuid = activityGuid;
	}

	public String getOnObjectType() {
		return onObjectType;
	}

	public void setOnObjectType(String onObjectType) {
		this.onObjectType = onObjectType;
	}

	public String getOnObjectName() {
		return onObjectName;
	}

	public void setOnObjectName(String onObjectName) {
		this.onObjectName = onObjectName;
	}

	public String getOnObjectImage() {
		return onObjectImage;
	}

	public void setOnObjectImage(String onObjectImage) {
		this.onObjectImage = onObjectImage;
	}

	public BaseUserInformation getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(BaseUserInformation userInfo) {
		this.userInfo = userInfo;
	}

	public Timestamp getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Timestamp createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Long getOnObjectGuid() {
		return onObjectGuid;
	}

	public void setOnObjectGuid(Long onObjectGuid) {
		this.onObjectGuid = onObjectGuid;
	}

	public String getLoggedTimeShort() {
		Timestamp currentTimestamp = CommonUtil.getCurrentGMTTimestamp();

		Integer currentYear = currentTimestamp.getYear();
		Integer currentMonth = currentTimestamp.getMonth();
		Integer currentDay = currentTimestamp.getDate();
		Integer currentHour = currentTimestamp.getHours();
		Integer currentMinutes = currentTimestamp.getMinutes();
		Integer currentSeconds = currentTimestamp.getSeconds();

		Integer activityYear = createdTimestamp.getYear();
		Integer activityMonth = createdTimestamp.getMonth();
		Integer activityDay = createdTimestamp.getDate();
		Integer activityHour = createdTimestamp.getHours();
		Integer activityMinutes = createdTimestamp.getMinutes();
		Integer activitySeconds = currentTimestamp.getSeconds();

		if (currentYear > activityYear) {
			loggedTimeShort = (currentYear - activityYear) + " y";
		} else if (currentYear == activityYear) {
			if (currentMonth > activityMonth) {
				loggedTimeShort = (currentMonth - activityMonth) + "m";
			} else if (currentMonth == activityMonth) {
				if (currentDay > activityDay) {
					loggedTimeShort = (currentDay - activityDay) + "d";
				} else if (currentDay == activityDay) {
					if (currentHour > activityHour) {
						loggedTimeShort = (currentHour - activityHour) + "h";
					} else if (currentHour == activityHour) {
						if (currentMinutes > activityMinutes) {
							loggedTimeShort = (currentMinutes - activityMinutes) + "m";
						} else if (currentMinutes == activityMinutes) {
							loggedTimeShort = (currentSeconds - activitySeconds) + "s";
						}
					}
				}
			}
		}
		return loggedTimeShort;
	}

	public void setLoggedTimeShort(String loggedTimeShort) {
		this.loggedTimeShort = loggedTimeShort;
	}

	public String getLoggedTimeLong() {
		Timestamp currentTimestamp = CommonUtil.getCurrentGMTTimestamp();

		Integer currentYear = currentTimestamp.getYear();
		Integer currentMonth = currentTimestamp.getMonth();
		Integer currentDay = currentTimestamp.getDate();
		Integer currentHour = currentTimestamp.getHours();
		Integer currentMinutes = currentTimestamp.getMinutes();
		Integer currentSeconds = currentTimestamp.getSeconds();

		Integer activityYear = createdTimestamp.getYear();
		Integer activityMonth = createdTimestamp.getMonth();
		Integer activityDay = createdTimestamp.getDate();
		Integer activityHour = createdTimestamp.getHours();
		Integer activityMinutes = createdTimestamp.getMinutes();
		Integer activitySeconds = currentTimestamp.getSeconds();

		if (currentYear > activityYear) {
			loggedTimeLong = (currentYear - activityYear) + " Years ago";
		} else if (currentYear == activityYear) {
			if (currentMonth > activityMonth) {
				loggedTimeLong = (currentMonth - activityMonth) + " Months ago";
			} else if (currentMonth == activityMonth) {
				if (currentDay > activityDay) {
					loggedTimeLong = (currentDay - activityDay) + " Days ago";
				} else if (currentDay == activityDay) {
					if (currentHour > activityHour) {
						loggedTimeLong = (currentHour - activityHour) + " Hours ago";
					} else if (currentHour == activityHour) {
						if (currentMinutes > activityMinutes) {
							loggedTimeLong = (currentMinutes - activityMinutes) + " Mins ago";
						} else if (currentMinutes == activityMinutes) {
							if (currentSeconds > activitySeconds) {
								loggedTimeLong = (currentSeconds - activitySeconds) + " Seconds ago";
							} else {
								loggedTimeLong = "Just Now";
							}
						}
					}
				}
			}
		}
		return loggedTimeLong;
	}

	public void setLoggedTimeLong(String loggedTimeLong) {
		this.loggedTimeLong = loggedTimeLong;
	}

}
