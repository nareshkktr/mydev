package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EventRecipientRequest {
	
	private Long guid;
	private Long eventId;
	private Long accountId;
	private String recipientType;
	private Long createdBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Timestamp createdTimeStamp;
	public EventRecipientRequest() {
		super();
	}
	public Long getGuid() {
		return guid;
	}
	public void setGuid(Long guid) {
		this.guid = guid;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public String getRecipientType() {
		return recipientType;
	}
	public void setRecipientType(String recipientType) {
		this.recipientType = recipientType;
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
	public EventRecipientRequest(Long guid, Long eventId, Long accountId, String recipientType, Long createdBy,
			Timestamp createdTimeStamp) {
		super();
		this.guid = guid;
		this.eventId = eventId;
		this.accountId = accountId;
		this.recipientType = recipientType;
		this.createdBy = createdBy;
		this.createdTimeStamp = createdTimeStamp;
	}
	
	

}
