package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.sql.Timestamp;
import java.util.List;

import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;

public class ProblemResponse {

	private Long guid;
	private SolrLocationMaster createdLocation;
	private String problemShortDescription;
	private String problemLongDescription;
	private String rootCause;
	private String problemStatus;
	private String problemSeverity;
	private String severityLevelCode;
	private String photoURL;
	private Long noOfAffectedPeople;
	private Long amountInvolved;
	private Timestamp createdTimeStamp;
	private Boolean escalationEnabled;
	private BaseUserInformation createdBy;
	private ProblemTypeResponse problemType;
	private Integer followingCount;
	private Integer supportCount;
	private Integer viewCount;
	private Integer shareCount;
	private Integer popularityCount;
	private String peopleEffected;
	private String moneyAtStake;
	private BaseUserInformation currentlyWith;
	private List<BaseUserInformation> contributors;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public SolrLocationMaster getCreatedLocation() {
		return createdLocation;
	}

	public void setCreatedLocation(SolrLocationMaster createdLocation) {
		this.createdLocation = createdLocation;
	}

	public String getProblemShortDescription() {
		return problemShortDescription;
	}

	public void setProblemShortDescription(String problemShortDescription) {
		this.problemShortDescription = problemShortDescription;
	}

	public String getProblemLongDescription() {
		problemLongDescription = problemLongDescription.startsWith("'") ? problemLongDescription.substring(1)
				: problemLongDescription;
		problemLongDescription = problemLongDescription.endsWith("'")
				? problemLongDescription.substring(0, problemLongDescription.length() - 1) : problemLongDescription;
		return problemLongDescription;
	}

	public void setProblemLongDescription(String problemLongDescription) {
		this.problemLongDescription = problemLongDescription;
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

	public Long getAmountInvolved() {
		return amountInvolved;
	}

	public void setAmountInvolved(Long amountInvolved) {
		this.amountInvolved = amountInvolved;
	}

	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public Boolean getEscalationEnabled() {
		return escalationEnabled;
	}

	public void setEscalationEnabled(Boolean escalationEnabled) {
		this.escalationEnabled = escalationEnabled;
	}

	public BaseUserInformation getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BaseUserInformation createdBy) {
		this.createdBy = createdBy;
	}

	public ProblemTypeResponse getProblemType() {
		return problemType;
	}

	public void setProblemType(ProblemTypeResponse problemType) {
		this.problemType = problemType;
	}

	public String getSeverityLevelCode() {
		if (this.problemSeverity != null)
			this.severityLevelCode = this.problemSeverity.equalsIgnoreCase("Critical") ? "C"
					: this.problemSeverity.equalsIgnoreCase("High") ? "H"
							: this.problemSeverity.equalsIgnoreCase("Medium") ? "M" : "L";
		return this.severityLevelCode;
	}

	public void setSeverityLevelCode(String severityLevelCode) {
		this.severityLevelCode = severityLevelCode;
	}

	public Integer getFollowingCount() {
		if (followingCount == null) {
			followingCount = 0;
		}
		return followingCount;
	}

	public void setFollowingCount(Integer followingCount) {
		this.followingCount = followingCount;
	}

	public Integer getSupportCount() {
		if (supportCount == null) {
			supportCount = 0;
		}
		return supportCount;
	}

	public void setSupportCount(Integer supportCount) {
		this.supportCount = supportCount;
	}

	public Integer getViewCount() {
		if (viewCount == null) {
			viewCount = 0;
		}
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public Integer getShareCount() {
		if (shareCount == null) {
			shareCount = 0;
		}
		return shareCount;
	}

	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}

	public Integer getPopularityCount() {
		if (popularityCount == null) {
			popularityCount = 0;
		}
		return popularityCount;
	}

	public void setPopularityCount(Integer popularityCount) {
		this.popularityCount = popularityCount;
	}

	public String getPeopleEffected() {
		if (amountInvolved.longValue() == 1) {
			peopleEffected = ">1000";
		} else if (amountInvolved.longValue() == 2) {
			peopleEffected = "<1000";
		} else if (amountInvolved.longValue() == 3) {
			peopleEffected = "<100";
		} else if (amountInvolved.longValue() == 4) {
			peopleEffected = "<5";
		}
		return peopleEffected;
	}

	public void setPeopleEffected(String peopleEffected) {
		this.peopleEffected = peopleEffected;
	}

	public String getMoneyAtStake() {
		if (amountInvolved.longValue() == 1) {
			moneyAtStake = ">50,00,000";
		} else if (amountInvolved.longValue() == 2) {
			moneyAtStake = "<50,00,000";
		} else if (amountInvolved.longValue() == 3) {
			moneyAtStake = "<10,00,000";
		} else if (amountInvolved.longValue() == 4) {
			moneyAtStake = "1,00,000";
		}
		return moneyAtStake;
	}

	public void setMoneyAtStake(String moneyAtStake) {
		this.moneyAtStake = moneyAtStake;
	}

	public BaseUserInformation getCurrentlyWith() {
		return currentlyWith;
	}

	public void setCurrentlyWith(BaseUserInformation currentlyWith) {
		this.currentlyWith = currentlyWith;
	}

	public List<BaseUserInformation> getContributors() {
		return contributors;
	}

	public void setContributors(List<BaseUserInformation> contributors) {
		this.contributors = contributors;
	}

}
