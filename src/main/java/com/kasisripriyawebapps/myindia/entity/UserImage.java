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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "USER_IMAGE")
public class UserImage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 451773781485333068L;

	@Id
	@Column(name = "USER_IMAGE_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@Column(name = "IMAGE_NAME")
	private String imageName;

	@Column(name = "IMAGE_URL")
	private String imageURL;

	@Column(name = "THUMBS_UP_COUNT")
	private Long thumbsUpCount;

	@Column(name = "THUMBS_DOWN_COUNT")
	private Long thumbsDownCount;

	@Column(name = "SHARE_COUNT")
	private Long shareCount;

	@Column(name = "ABUSE_COUNT")
	private Long abuseCount;

	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	@Column(name = "CREATED_BY")
	private Long createdBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_INFO_GUID")
	@JsonBackReference
	private UserInfo userInfo;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Long getThumbsUpCount() {
		return thumbsUpCount;
	}

	public void setThumbsUpCount(Long thumbsUpCount) {
		this.thumbsUpCount = thumbsUpCount;
	}

	public Long getThumbsDownCount() {
		return thumbsDownCount;
	}

	public void setThumbsDownCount(Long thumbsDownCount) {
		this.thumbsDownCount = thumbsDownCount;
	}

	public Long getShareCount() {
		return shareCount;
	}

	public void setShareCount(Long shareCount) {
		this.shareCount = shareCount;
	}

	public Long getAbuseCount() {
		return abuseCount;
	}

	public void setAbuseCount(Long abuseCount) {
		this.abuseCount = abuseCount;
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

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
