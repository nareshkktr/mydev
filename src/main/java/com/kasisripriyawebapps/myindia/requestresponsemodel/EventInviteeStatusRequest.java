package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EventInviteeStatusRequest {
		
	private Long guid;
	private Long eventId;
	private Long accountId;
	private String reason;
	private Boolean isInvited;
	private Long createdBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Timestamp createdTimeStamp;
	private Long modifiedBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Timestamp modifiedTimeStamp;
	public EventInviteeStatusRequest(){}
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Boolean getIsInvited() {
		return isInvited;
	}
	public void setIsInvited(Boolean isInvited) {
		this.isInvited = isInvited;
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
	public Long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Timestamp getModifiedTimeStamp() {
		return modifiedTimeStamp;
	}
	public void setModifiedTimeStamp(Timestamp modifiedTimeStamp) {
		this.modifiedTimeStamp = modifiedTimeStamp;
	}
	public EventInviteeStatusRequest(Long guid, Long eventId, Long accountId, String reason, Boolean isInvited,
			Long createdBy, Timestamp createdTimeStamp, Long modifiedBy, Timestamp modifiedTimeStamp) {
		super();
		this.guid = guid;
		this.eventId = eventId;
		this.accountId = accountId;
		this.reason = reason;
		this.isInvited = isInvited;
		this.createdBy = createdBy;
		this.createdTimeStamp = createdTimeStamp;
		this.modifiedBy = modifiedBy;
		this.modifiedTimeStamp = modifiedTimeStamp;
	}

}
