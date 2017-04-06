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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "EVENT_RECIPIENTS")
@XmlRootElement
@NamedNativeQueries({
	@NamedNativeQuery(name = "removeEventRecipient", query ="delete from EVENT_RECIPIENTS where EVENT_RECIPIENT_GUID=:eventRecipientGuid"),
	@NamedNativeQuery(name = "getEventRecipient", query ="select EVENT_RECIPIENT_GUID from EVENT_RECIPIENTS where EVENT_RECIPIENT_GUID=:eventRecipientId")})

public class EventRecipients implements Serializable{

	private static final long serialVersionUID = 1785851795169025736L;
	@Id
	@Column(name = "EVENT_RECIPIENT_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EVENT_GUID")
	private Event event;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RECIPIENT_GUID")
	private Account account;
	@Column(name = "RECIPIENT_TYPE")
	private String recipientType;
	@Column(name = "CREATED_BY")
	private Long createdBy;
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;
	
	public EventRecipients(){}

	public EventRecipients(Long guid, Event event, Account account, String recipientType, Long createdBy,
			Timestamp createdTimeStamp) {
		super();
		this.guid = guid;
		this.event = event;
		this.account = account;
		this.recipientType = recipientType;
		this.createdBy = createdBy;
		this.createdTimeStamp = createdTimeStamp;
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
	
}
