package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "GroupRequest", description = "To Create Group An User")
public class GroupRequest {

	private Long guid;
	private String groupName;
	private String groupImageURL; 
	private Long createdBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Timestamp createdTimeStamp;
	private Long modifiedBy;
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss.SSS")
	private Timestamp modifiedTimeStamp;
	private List<GroupMemberRequest> groupMemberRequest;
	public GroupRequest(){}
	public GroupRequest(Long guid, String groupName, String groupImageURL, Long createdBy, Timestamp createdTimeStamp,
			Long modifiedBy, Timestamp modifiedTimeStamp, List<GroupMemberRequest> groupMemberRequest) {
		super();
		this.guid = guid;
		this.groupName = groupName;
		this.groupImageURL = groupImageURL;
		this.createdBy = createdBy;
		this.createdTimeStamp = createdTimeStamp;
		this.modifiedBy = modifiedBy;
		this.modifiedTimeStamp = modifiedTimeStamp;
		this.groupMemberRequest = groupMemberRequest;
	}
	public Long getGuid() {
		return guid;
	}
	public void setGuid(Long guid) {
		this.guid = guid;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupImageURL() {
		return groupImageURL;
	}
	public void setGroupImageURL(String groupImageURL) {
		this.groupImageURL = groupImageURL;
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
	public List<GroupMemberRequest> getGroupMemberRequest() {
		return groupMemberRequest;
	}
	public void setGroupMemberRequest(List<GroupMemberRequest> groupMemberRequest) {
		this.groupMemberRequest = groupMemberRequest;
	}
	

}
