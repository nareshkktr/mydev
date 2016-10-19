/*
 * 
 */
package com.kasisripriyawebapps.myindia.entity;

import java.io.Serializable;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

// TODO: Auto-generated Javadoc
/**
 * The Class EventEntity.
 */
@Entity
@Table(name = "EVENT_MASTER")
public class Event implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2570378599209427236L;

	/**
	 * Instantiates a new event entity.
	 */
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(Long guid, EventType eventType, Location location, String eventName,
			String eventDescription, String eventLocationDetails, String photoURL, Timestamp eventStartDate,
			Timestamp eventEndDate, Timestamp createdTimeStamp, Timestamp updatedTimeStamp, Long createdBy,
			Long updatedBy) {
		super();
		this.guid = guid;
		this.eventType = eventType;
		this.location = location;
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

	@Id
	@Column(name = "EVENT_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "EVENT_TYPE_GUID")
	@JsonBackReference
	private EventType eventType;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "LOCATION_GUID")
	@JsonBackReference
	private Location location;

	@Column(name = "EVENT_NAME")
	private String eventName;

	@Column(name = "EVENT_DESCRIPTION")
	private String eventDescription;

	@Column(name = "EVENT_LOCATION_DIRETION_DETAILS")
	private String eventLocationDetails;

	@Column(name = "PHOTO_URL")
	private String photoURL;

	@Column(name = "EVENT_START_DATE")
	private Timestamp eventStartDate;

	@Column(name = "EVENT_END_DATE")
	private Timestamp eventEndDate;

	@Column(name = "POPULARITY_COUNT")
	private Long popularityCount;

	@Column(name = "SUPPORTING_COUNT")
	private Long supportingCount;

	@Column(name = "FOLLOWING_COUNT")
	private Long followingCount;

	@Column(name = "SHARE_COUNT")
	private Long shareCount;

	/** The created time stamp. */
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	/** The updated time stamp. */
	@Column(name = "UPDATED_TIMESTAMP")
	private Timestamp updatedTimeStamp;

	/** The created by. */
	@Column(name = "CREATED_BY")
	private Long createdBy;

	/** The updated by. */
	@Column(name = "UPDATED_BY")
	private Long updatedBy;

	@OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<EventImage> eventImages = new ArrayList<EventImage>(0);

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
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

	public Long getPopularityCount() {
		return popularityCount;
	}

	public void setPopularityCount(Long popularityCount) {
		this.popularityCount = popularityCount;
	}

	public Long getSupportingCount() {
		return supportingCount;
	}

	public void setSupportingCount(Long supportingCount) {
		this.supportingCount = supportingCount;
	}

	public Long getFollowingCount() {
		return followingCount;
	}

	public void setFollowingCount(Long followingCount) {
		this.followingCount = followingCount;
	}

	public Long getShareCount() {
		return shareCount;
	}

	public void setShareCount(Long shareCount) {
		this.shareCount = shareCount;
	}

	public List<EventImage> getEventImages() {
		return eventImages;
	}

	public void setEventImages(List<EventImage> eventImages) {
		this.eventImages.clear();
		if (eventImages != null) {
			this.eventImages.addAll(eventImages);
		}
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	
}
