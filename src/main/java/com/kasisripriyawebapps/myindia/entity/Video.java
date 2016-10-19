/*
 * 
 */
package com.kasisripriyawebapps.myindia.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Video.
 */
@Entity
@Table(name = "VIDEO_MASTER")
public class Video implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -121817035955871040L;

	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Video(Long guid, String objectType, String objectGuid, String videoName, String videoUrl,
			Timestamp createdTimeStamp, Long createdBy) {
		super();
		this.guid = guid;
		this.objectType = objectType;
		this.objectGuid = objectGuid;
		this.videoName = videoName;
		this.videoUrl = videoUrl;
		this.createdTimeStamp = createdTimeStamp;
		this.createdBy = createdBy;
	}

	@Id
	@Column(name = "VIDEO_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@Column(name = "OBJECT_TYPE")
	private String objectType;

	@Column(name = "OBJECT_GUID")
	private String objectGuid;

	@Column(name = "VIDEO_NAME")
	private String videoName;

	@Column(name = "VIDEO_URL")
	private String videoUrl;

	/** The created time stamp. */
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	/** The created by. */
	@Column(name = "CREATED_BY")
	private Long createdBy;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getObjectGuid() {
		return objectGuid;
	}

	public void setObjectGuid(String objectGuid) {
		this.objectGuid = objectGuid;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

}
