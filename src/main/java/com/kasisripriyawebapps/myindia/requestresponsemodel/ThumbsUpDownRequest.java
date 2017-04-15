package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ThumbsUpDownRequest {
	
	private Long guid;
	private String objectType;
	private Long objectGuid;
	private Integer thumbsUpDownFlag;
	private Long createdBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Timestamp createdTimeStamp;
	public Long getGuid() {
		return guid;
	}
	public void setGuid(Long guid) {
		this.guid = guid;
	}
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	public Long getObjectGuid() {
		return objectGuid;
	}
	public void setObjectGuid(Long objectGuid) {
		this.objectGuid = objectGuid;
	}
	public Integer getThumbsUpDownFlag() {
		return thumbsUpDownFlag;
	}
	public void setThumbsUpDownFlag(Integer thumbsUpDownFlag) {
		this.thumbsUpDownFlag = thumbsUpDownFlag;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}
	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}
	public ThumbsUpDownRequest(){}
	public ThumbsUpDownRequest(Long guid, String objectType, Long objectGuid, Integer thumbsUpDownFlag, Long createdBy,
			Timestamp createdTimeStamp) {
		super();
		this.guid = guid;
		this.objectType = objectType;
		this.objectGuid = objectGuid;
		this.thumbsUpDownFlag = thumbsUpDownFlag;
		this.createdBy = createdBy;
		this.createdTimeStamp = createdTimeStamp;
	}
	
	

}
