package com.kasisripriyawebapps.myindia.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "GROUP_MEMBERS")
@XmlRootElement
@NamedNativeQueries({
	@NamedNativeQuery(name = "removeGroupMember", query ="delete from GROUP_MEMBERS where group_guid=:groupMemberId")})
public class GroupMembers {
	
	@Id
	@Column(name = "GROUP_MEMBER_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GROUP_GUID")
	private Groups groups;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_GUID")
	private Account account;
	@Column(name = "CREATED_BY")
	private Long createdBy;
	/** The created time stamp. */
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;
	
	public GroupMembers(){}
	
	public GroupMembers(Long guid, Groups groups, Account account, Long createdBy, Timestamp createdTimeStamp) {
		super();
		this.guid = guid;
		this.groups = groups;
		this.account = account;
		this.createdBy = createdBy;
		this.createdTimeStamp = createdTimeStamp;
	}

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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
