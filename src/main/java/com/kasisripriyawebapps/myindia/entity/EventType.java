package com.kasisripriyawebapps.myindia.entity;

import java.io.Serializable;
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
@Table(name = "EVENT_TYPE")
public class EventType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1249676341930477331L;

	@Id
	@Column(name = "EVENT_TYPE_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@Column(name = "EVENT_TYPE_NAME")
	private String eventTypeName;

	@Column(name = "EVENT_TYPE_PHOTO_URL")
	private String eventTypePhotoURL;

	public EventType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventType(Long guid, String eventTypeName, String eventTypePhotoURL, List<Event> events) {
		super();
		this.guid = guid;
		this.eventTypeName = eventTypeName;
		this.eventTypePhotoURL = eventTypePhotoURL;
		this.events = events;
	}

	@OneToMany(mappedBy = "eventType", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Event> events = new ArrayList<Event>(0);

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getEventTypeName() {
		return eventTypeName;
	}

	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}

	public String getEventTypePhotoURL() {
		return eventTypePhotoURL;
	}

	public void setEventTypePhotoURL(String eventTypePhotoURL) {
		this.eventTypePhotoURL = eventTypePhotoURL;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events.clear();
		if (events != null) {
			this.events.addAll(events);
		}
	}

}
