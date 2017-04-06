package com.kasisripriyawebapps.myindia.entity;

import java.io.Serializable;

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
import javax.xml.bind.annotation.XmlRootElement;@Entity
@Table(name = "EVENT_INVITEES_STATUS")
@XmlRootElement
@NamedNativeQueries({
	@NamedNativeQuery(name = "removeEventInviteeStatus", query ="delete from EVENT_INVITEES_STATUS where EVENT_INVITEE_STATUS_GUID=:eventStatusGuid"),
	@NamedNativeQuery(name = "getEventInviteeStatus", query ="select EVENT_INVITEE_STATUS_GUID from EVENT_INVITEES_STATUS where EVENT_INVITEE_STATUS_GUID=:eventStatusGuid")})
public class EventInviteeStatus implements Serializable{

	private static final long serialVersionUID = 7805797303737765930L;

	@Id
	@Column(name = "EVENT_INVITEE_STATUS_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EVENT_GUID")
	private Event event;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_GUID")
	private Account account;
	@Column(name = "REASON")
	private String reason;
	@Column(name = "IS_INVITED")
	private Boolean isInvited;
	@Column(name = "CREATED_BY")
	private Long createdBy;
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;
	@Column(name = "MODIFIED_BY")
	private Long modifiedBy;
	@Column(name = "MODIFIED_TIMESTAMP")
	private Timestamp modifiedTimeStamp;
	public EventInviteeStatus() {
		super();
	}
	public EventInviteeStatus(Long guid, Event event, Account account, String reason, Boolean isInvited, Long createdBy,
			Timestamp createdTimeStamp, Long modifiedBy, Timestamp modifiedTimeStamp) {
		super();
		this.guid = guid;
		this.event = event;
		this.account = account;
		this.reason = reason;
		this.isInvited = isInvited;
		this.createdBy = createdBy;
		this.createdTimeStamp = createdTimeStamp;
		this.modifiedBy = modifiedBy;
		this.modifiedTimeStamp = modifiedTimeStamp;
	}
	public Long getGuid() {
		return guid;
	}
	public void setGuid(Long guid) {
		this.guid = guid;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}



