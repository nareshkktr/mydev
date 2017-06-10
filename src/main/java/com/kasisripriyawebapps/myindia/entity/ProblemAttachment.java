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
@Table(name = "PROBLEM_ATTACHMENT")
public class ProblemAttachment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1866186005993118507L;

	@Id
	@Column(name = "PROBLEM_ATTACHMENT_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@Column(name = "FILE_URL")
	private String fileURL;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	@Column(name = "CREATED_BY")
	private Long createdBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROBLEM_GUID")
	private Problem problem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROBLEM_ATTACHMENT_FOLDER_GUID")
	private ProblemAttachmentFolder problemAttachmentFolder;

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

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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

	public ProblemAttachmentFolder getProblemAttachmentFolder() {
		return problemAttachmentFolder;
	}

	public void setProblemAttachmentFolder(ProblemAttachmentFolder problemAttachmentFolder) {
		this.problemAttachmentFolder = problemAttachmentFolder;
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
