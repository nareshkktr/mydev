package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GroupMemberRequest {

	private Long guid;
	private Long groupGuid;
	private Long accountGuid;
	private Long createdBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Timestamp createdTimeStamp;
	
	public GroupMemberRequest(){}
	
	public GroupMemberRequest(Long guid, Long groupGuid, Long accountGuid, Long createdBy, Timestamp createdTimeStamp) {
		super();
		this.guid = guid;
		this.groupGuid = groupGuid;
		this.accountGuid = accountGuid;
		this.createdBy = createdBy;
		this.createdTimeStamp = createdTimeStamp;
	}
	public Long getGuid() {
		return guid;
	}
	public void setGuid(Long guid) {
		this.guid = guid;
	}
	public Long getGroupGuid() {
		return groupGuid;
	}
	public void setGroupGuid(Long groupGuid) {
		this.groupGuid = groupGuid;
	}
	public Long getAccountGuid() {
		return accountGuid;
	}
	public void setAccountGuid(Long accountGuid) {
		this.accountGuid = accountGuid;
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
	

}
