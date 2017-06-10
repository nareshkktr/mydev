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

@Entity
@Table(name = "PROBLEM_ATTACHMENT_FOLDER")
public class ProblemAttachmentFolder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9017818530752077094L;

	@Id
	@Column(name = "PROBLEM_ATTACHMENT_FOLDER_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@Column(name = "FOLDER_NAME")
	private String folderName;

	@Column(name = "FOLDER_DESCRIPTION")
	private String folderDescription;

	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	@Column(name = "CREATED_BY")
	private Long createdBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROBLEM_GUID")
	private Problem problem;

	@OneToMany(mappedBy = "problemAttachmentFolder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProblemAttachment> problemAttachments = new ArrayList<ProblemAttachment>(0);

	@Column(name = "FILES_COUNT")
	private Integer filesCount = 0;

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

	@Column(name = "MODIFIED_TIMESTAMP")
	private Timestamp updatedTimeStamp;

	@Column(name = "MODIFIED_BY")
	private Long updatedBy;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getFolderDescription() {
		return folderDescription;
	}

	public void setFolderDescription(String folderDescription) {
		this.folderDescription = folderDescription;
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

	public List<ProblemAttachment> getProblemAttachments() {
		return problemAttachments;
	}

	public void setProblemAttachments(List<ProblemAttachment> problemAttachments) {
		this.problemAttachments = problemAttachments;
	}

	public Integer getFilesCount() {
		return filesCount;
	}

	public void setFilesCount(Integer filesCount) {
		this.filesCount = filesCount;
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

	public Timestamp getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}

	public void setUpdatedTimeStamp(Timestamp updatedTimeStamp) {
		this.updatedTimeStamp = updatedTimeStamp;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

}
