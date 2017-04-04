package com.kasisripriyawebapps.myindia.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "GROUPS")
public class Groups {
	
	@Id
	@Column(name = "GROUP_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@Column(name = "GROUP_NAME")
	private String groupName;
	
	@Column(name = "GROUP_IMAGE_URL")
	private String groupImageURL; 
	
	@Column(name = "CREATED_BY")
	private Long createdBy;
	
	/** The created time stamp. */
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;
	
	/** The updated by. */
	@Column(name = "MODIFIED_BY")
	private Long modifiedBy;
	
	/** The updated time stamp. */
	@Column(name = "MODIFIED_TIMESTAMP")
	private Timestamp modifiedTimeStamp;
	
	@OneToMany(mappedBy = "groups", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<GroupMembers> groupMembers = new ArrayList<GroupMembers>(0);

	
	public Groups(){}
	public Groups(Long guid, String groupName, String groupImageURL, Long createdBy, Timestamp createdTimeStamp,
			Long modifiedBy, Timestamp modifiedTimeStamp, List<GroupMembers> groupMembers) {
		super();
		this.guid = guid;
		this.groupName = groupName;
		this.groupImageURL = groupImageURL;
		this.createdBy = createdBy;
		this.createdTimeStamp = createdTimeStamp;
		this.modifiedBy = modifiedBy;
		this.modifiedTimeStamp = modifiedTimeStamp;
		this.groupMembers = groupMembers;
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
	public List<GroupMembers> getGroupMembers() {
		return groupMembers;
	}
	public void setGroupMembers(List<GroupMembers> groupMembers) {
		this.groupMembers.clear(); 
		
		if(groupMembers !=null){
			this.groupMembers.addAll(groupMembers);	
		}
	}
	
	
    
	
	


}
