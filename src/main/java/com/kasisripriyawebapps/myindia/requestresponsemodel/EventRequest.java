package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "EventRequest", description = "To Create Event An User")
public class EventRequest {
	private Long guid;
	private Long eventTypeGuId;
	private Long createdLocationGuId;
	private List<EventRecipientRequest> eventRecipientRequests;
	private String eventName;
	private String eventDescription;
	private String eventLocationDetails;
	private String photoURL;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Timestamp eventStartDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Timestamp eventEndDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Timestamp createdTimeStamp;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private Timestamp updatedTimeStamp;
	private Long createdBy;
	private Long updatedBy;
	public EventRequest(){}
	public EventRequest(Long guid, Long eventTypeGuId, Long createdLocationGuId,
			List<EventRecipientRequest> eventRecipientRequests, String eventName, String eventDescription,
			String eventLocationDetails, String photoURL, Timestamp eventStartDate, Timestamp eventEndDate,
			Timestamp createdTimeStamp, Timestamp updatedTimeStamp, Long createdBy, Long updatedBy) {
		super();
		this.guid = guid;
		this.eventTypeGuId = eventTypeGuId;
		this.createdLocationGuId = createdLocationGuId;
		this.eventRecipientRequests = eventRecipientRequests;
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.eventLocationDetails = eventLocationDetails;
		this.photoURL = photoURL;
		this.eventStartDate = eventStartDate;
		this.eventEndDate = eventEndDate;
		this.createdTimeStamp = createdTimeStamp;
		this.updatedTimeStamp = updatedTimeStamp;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}
	public Long getGuid() {
		return guid;
	}
	public void setGuid(Long guid) {
		this.guid = guid;
	}
	public Long getEventTypeGuId() {
		return eventTypeGuId;
	}
	public void setEventTypeGuId(Long eventTypeGuId) {
		this.eventTypeGuId = eventTypeGuId;
	}
	public Long getCreatedLocationGuId() {
		return createdLocationGuId;
	}
	public void setCreatedLocationGuId(Long createdLocationGuId) {
		this.createdLocationGuId = createdLocationGuId;
	}
	public List<EventRecipientRequest> getEventRecipientRequests() {
		return eventRecipientRequests;
	}
	public void setEventRecipientRequests(List<EventRecipientRequest> eventRecipientRequests) {
		this.eventRecipientRequests = eventRecipientRequests;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public String getEventLocationDetails() {
		return eventLocationDetails;
	}
	public void setEventLocationDetails(String eventLocationDetails) {
		this.eventLocationDetails = eventLocationDetails;
	}
	public String getPhotoURL() {
		return photoURL;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}
	public Timestamp getEventStartDate() {
		return eventStartDate;
	}
	public void setEventStartDate(Timestamp eventStartDate) {
		this.eventStartDate = eventStartDate;
	}
	public Timestamp getEventEndDate() {
		return eventEndDate;
	}
	public void setEventEndDate(Timestamp eventEndDate) {
		this.eventEndDate = eventEndDate;
	}
	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}
	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}
	public Timestamp getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}
	public void setUpdatedTimeStamp(Timestamp updatedTimeStamp) {
		this.updatedTimeStamp = updatedTimeStamp;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	

}
