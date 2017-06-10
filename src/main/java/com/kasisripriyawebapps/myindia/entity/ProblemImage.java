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

@Entity
@Table(name = "PROBLEM_IMAGE")
public class ProblemImage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 451773781485333068L;

	@Id
	@Column(name = "PROBLEM_IMAGE_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@Column(name = "IMAGE_URL")
	private String imageURL;

	@Column(name = "IMAGE_NAME")
	private String imageName;

	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	@Column(name = "CREATED_BY")
	private Long createdBy;

	@Column(name = "CATEGORY")
	private String category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROBLEM_GUID")
	private Problem problem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROBLEM_ALBUM_GUID")
	private ProblemAlbum problemAlbum;

	/** The following count. */
	@Column(name = "THUMBS_UP_COUNT")
	private Integer thumbsUpCount = 0;

	/** The share count. */
	@Column(name = "THUMBS_DOWN_COUNT")
	private Integer thumbsDownCount = 0;

	/** The Support count. */
	@Column(name = "COMMENTS_COUNT")
	private Integer commentsCount = 0;

	/** The view count. */
	@Column(name = "SHARE_COUNT")
	private Integer shareCount = 0;

	/** The popularity count. */
	@Column(name = "REPORT_ABUSE_COUNT")
	private Integer reportAbuseCount = 0;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
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

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ProblemAlbum getProblemAlbum() {
		return problemAlbum;
	}

	public void setProblemAlbum(ProblemAlbum problemAlbum) {
		this.problemAlbum = problemAlbum;
	}

	public Integer getThumbsUpCount() {
		return thumbsUpCount;
	}

	public void setThumbsUpCount(Integer thumbsUpCount) {
		this.thumbsUpCount = thumbsUpCount;
	}

	public Integer getThumbsDownCount() {
		return thumbsDownCount;
	}

	public void setThumbsDownCount(Integer thumbsDownCount) {
		this.thumbsDownCount = thumbsDownCount;
	}

	public Integer getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(Integer commentsCount) {
		this.commentsCount = commentsCount;
	}

	public Integer getShareCount() {
		return shareCount;
	}

	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}

	public Integer getReportAbuseCount() {
		return reportAbuseCount;
	}

	public void setReportAbuseCount(Integer reportAbuseCount) {
		this.reportAbuseCount = reportAbuseCount;
	}

}
