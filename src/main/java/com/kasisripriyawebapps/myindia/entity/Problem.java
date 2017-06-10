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

/**
 * The Class Problem.
 */
@Entity
@Table(name = "PROBLEM_MASTER")
public class Problem implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2670054723199844722L;

	/**
	 * Instantiates a new problem entity.
	 */
	public Problem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Problem(LocationMaster createdLocation, String problemShortDescription, String problemLongDescription,
			String rootCause, String problemStatus, String problemSeverity, String photoURL, Long noOfAffectedPeople,
			Long amountInvolved, Timestamp createdTimeStamp, Timestamp updatedTimeStamp,
			Timestamp manualEscalationTimestamp, Boolean escalationEnabled, Long createdBy, Long updatedBy,
			List<ProblemImage> problemImages, ProblemType problemType, List<ProblemHistory> problemHistory) {
		super();
		this.createdLocation = createdLocation;
		this.problemShortDescription = problemShortDescription;
		this.problemLongDescription = problemLongDescription;
		this.rootCause = rootCause;
		this.problemStatus = problemStatus;
		this.problemSeverity = problemSeverity;
		this.photoURL = photoURL;
		this.noOfAffectedPeople = noOfAffectedPeople;
		this.amountInvolved = amountInvolved;
		this.createdTimeStamp = createdTimeStamp;
		this.updatedTimeStamp = updatedTimeStamp;
		this.manualEscalationTimestamp = manualEscalationTimestamp;
		this.escalationEnabled = escalationEnabled;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.problemImages = problemImages;
		this.problemType = problemType;
		this.problemHistory = problemHistory;
	}

	public Boolean getEscalationEnabled() {
		return escalationEnabled;
	}

	public void setEscalationEnabled(Boolean escalationEnabled) {
		this.escalationEnabled = escalationEnabled;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

	public String getProblemStatus() {
		return problemStatus;
	}

	public void setProblemStatus(String problemStatus) {
		this.problemStatus = problemStatus;
	}

	public String getProblemSeverity() {
		return problemSeverity;
	}

	public void setProblemSeverity(String problemSeverity) {
		this.problemSeverity = problemSeverity;
	}

	public Long getAmountInvolved() {
		return amountInvolved;
	}

	public void setAmountInvolved(Long amountInvolved) {
		this.amountInvolved = amountInvolved;
	}

	public Timestamp getManualEscalationTimestamp() {
		return manualEscalationTimestamp;
	}

	public void setManualEscalationTimestamp(Timestamp manualEscalationTimestamp) {
		this.manualEscalationTimestamp = manualEscalationTimestamp;
	}

	@Id
	@Column(name = "PROBLEM_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROBLEM_LOCATION_GUID")
	private LocationMaster createdLocation;

	@Column(name = "SHORT_DESCRIPTION")
	private String problemShortDescription;

	@Column(name = "LONG_DESCRIPTION")
	private String problemLongDescription;

	@Column(name = "ROOT_CAUSE")
	private String rootCause;

	@Column(name = "PROBLEM_STATUS")
	private String problemStatus;

	@Column(name = "PROLEM_SEVERITY")
	private String problemSeverity;

	@Column(name = "PHOTO_URL")
	private String photoURL;

	@Column(name = "PEOPLE_AFFECTED_COUNT")
	private Long noOfAffectedPeople;

	@Column(name = "AMOUNT_INVOLVED")
	private Long amountInvolved;

	/** The created time stamp. */
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	/** The updated time stamp. */
	@Column(name = "MODIFIED_TIMESTAMP")
	private Timestamp updatedTimeStamp;

	/** The updated time stamp. */
	@Column(name = "MANUAL_ESCALATION_TIME")
	private Timestamp manualEscalationTimestamp;

	@Column(name = "ESCALATION_ENABLED")
	private Boolean escalationEnabled;

	/** The created by. */
	@Column(name = "CREATED_BY")
	private Long createdBy;

	/** The updated by. */
	@Column(name = "MODIFIED_BY")
	private Long updatedBy;

	/** The following count. */
	@Column(name = "FOLLOWING_COUNT")
	private Integer followingCount;

	/** The share count. */
	@Column(name = "SHARE_COUNT")
	private Integer shareCount;

	/** The Support count. */
	@Column(name = "SUPPORT_COUNT")
	private Integer supportCount;

	/** The view count. */
	@Column(name = "VIEW_COUNT")
	private Integer viewCount;

	/** The popularity count. */
	@Column(name = "POPULARITY_COUNT")
	private Integer popularityCount;

	@OneToMany(mappedBy = "problem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProblemImage> problemImages = new ArrayList<ProblemImage>(0);

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "PROBLEM_TYPE_GUID")
	private ProblemType problemType;

	@OneToMany(mappedBy = "problem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProblemHistory> problemHistory = new ArrayList<ProblemHistory>(0);

	@Column(name = "TAGS")
	private String tags;

	@OneToMany(mappedBy = "problem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProblemAttachment> problemAttachments = new ArrayList<ProblemAttachment>(0);

	@OneToMany(mappedBy = "problem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProblemAttachmentFolder> problemAttachmentFolders = new ArrayList<ProblemAttachmentFolder>(0);

	@OneToMany(mappedBy = "problem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProblemAlbum> problemAlbums = new ArrayList<ProblemAlbum>(0);

	@OneToMany(mappedBy = "problem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProblemOwner> problemOwners = new ArrayList<ProblemOwner>(0);

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public LocationMaster getCreatedLocation() {
		return createdLocation;
	}

	public void setCreatedLocation(LocationMaster createdLocation) {
		this.createdLocation = createdLocation;
	}

	public String getProblemShortDescription() {
		return problemShortDescription;
	}

	public void setProblemShortDescription(String problemShortDescription) {
		this.problemShortDescription = problemShortDescription;
	}

	public String getProblemLongDescription() {
		return problemLongDescription;
	}

	public void setProblemLongDescription(String problemLongDescription) {
		this.problemLongDescription = problemLongDescription;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public Long getNoOfAffectedPeople() {
		return noOfAffectedPeople;
	}

	public void setNoOfAffectedPeople(Long noOfAffectedPeople) {
		this.noOfAffectedPeople = noOfAffectedPeople;
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

	public List<ProblemImage> getProblemImages() {
		return problemImages;
	}

	public void setProblemImages(List<ProblemImage> problemImages) {
		this.problemImages.clear();
		if (problemImages != null) {
			this.problemImages.addAll(problemImages);
		}
	}

	public ProblemType getProblemType() {
		return problemType;
	}

	public void setProblemType(ProblemType problemType) {
		this.problemType = problemType;
	}

	public List<ProblemHistory> getProblemHistory() {
		return problemHistory;
	}

	public void setProblemHistory(List<ProblemHistory> problemHistory) {
		this.problemHistory.clear();
		if (problemHistory != null) {
			this.problemHistory.addAll(problemHistory);
		}
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Integer getFollowingCount() {
		return followingCount;
	}

	public void setFollowingCount(Integer followingCount) {
		this.followingCount = followingCount;
	}

	public Integer getShareCount() {
		return shareCount;
	}

	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}

	public Integer getSupportCount() {
		return supportCount;
	}

	public void setSupportCount(Integer supportCount) {
		this.supportCount = supportCount;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public Integer getPopularityCount() {
		return popularityCount;
	}

	public void setPopularityCount(Integer popularityCount) {
		this.popularityCount = popularityCount;
	}

	public List<ProblemAttachment> getProblemAttachments() {
		return problemAttachments;
	}

	public void setProblemAttachments(List<ProblemAttachment> problemAttachments) {
		this.problemAttachments = problemAttachments;
	}

	public List<ProblemAttachmentFolder> getProblemAttachmentFolders() {
		return problemAttachmentFolders;
	}

	public void setProblemAttachmentFolders(List<ProblemAttachmentFolder> problemAttachmentFolders) {
		this.problemAttachmentFolders = problemAttachmentFolders;
	}

	public List<ProblemAlbum> getProblemAlbums() {
		return problemAlbums;
	}

	public void setProblemAlbums(List<ProblemAlbum> problemAlbums) {
		this.problemAlbums = problemAlbums;
	}

	public List<ProblemOwner> getProblemOwners() {
		return problemOwners;
	}

	public void setProblemOwners(List<ProblemOwner> problemOwners) {
		this.problemOwners = problemOwners;
	}

	
}
