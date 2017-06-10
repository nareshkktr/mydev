package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PhotoResponse {
	private Long guid;
	private String name;
	private String imageUrl;
	private Integer noOfPhotos;
	private List<String> imageUrls = new ArrayList<String>();
	private BaseUserInformation creator;
	@JsonFormat(pattern = "EEE, MMM dd yyyy HH:mm:ss")
	private Timestamp createdTimeStamp;
	@JsonFormat(pattern = "EEE, MMM dd yyyy HH:mm:ss")
	private Timestamp updatedTimeStamp;
	private Long thumbsUpCount;
	private Long thumbsDownCount;
	private Long commentsCount;
	private Long shareCount;
	private Long reportAbuseCount;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getNoOfPhotos() {
		return noOfPhotos;
	}

	public void setNoOfPhotos(Integer noOfPhotos) {
		this.noOfPhotos = noOfPhotos;
	}

	public List<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

	public BaseUserInformation getCreator() {
		return creator;
	}

	public void setCreator(BaseUserInformation creator) {
		this.creator = creator;
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

	public Long getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(Long commentsCount) {
		this.commentsCount = commentsCount;
	}

	public Long getShareCount() {
		return shareCount;
	}

	public void setShareCount(Long shareCount) {
		this.shareCount = shareCount;
	}

	public Long getReportAbuseCount() {
		return reportAbuseCount;
	}

	public void setReportAbuseCount(Long reportAbuseCount) {
		this.reportAbuseCount = reportAbuseCount;
	}
}
