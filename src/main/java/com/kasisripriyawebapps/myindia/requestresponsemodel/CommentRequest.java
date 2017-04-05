package com.kasisripriyawebapps.myindia.requestresponsemodel;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;

public class CommentRequest {

	/** The commentor object type. */
	private String commentorObjectType = ApplicationConstants.VOTER_ACCOUNT_TYPE;

	/** The commentor object guid. */
	private Long commentorObjectGuid;

	/** The object type. */
	private String objectType;

	/** The object guid. */
	private Long objectGuid;

	/** The comment text. */
	private String commentText;

	/** The parent comment id. */
	private Long parentCommentId;

	private String commentType = "Text";

	public CommentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentRequest(String commentorObjectType, Long commentorObjectGuid, String objectType, Long objectGuid,
			String commentText, Long parentCommentId, String commentType) {
		super();
		this.commentorObjectType = commentorObjectType;
		this.commentorObjectGuid = commentorObjectGuid;
		this.objectType = objectType;
		this.objectGuid = objectGuid;
		this.commentText = commentText;
		this.parentCommentId = parentCommentId;
		this.commentType = commentType;
	}

	public String getCommentorObjectType() {
		if (commentorObjectType == null || commentorObjectType.isEmpty()) {
			commentorObjectType = ApplicationConstants.VOTER_ACCOUNT_TYPE;
		}
		return commentorObjectType;
	}

	public void setCommentorObjectType(String commentorObjectType) {
		this.commentorObjectType = commentorObjectType;
	}

	public Long getCommentorObjectGuid() {
		return commentorObjectGuid;
	}

	public void setCommentorObjectGuid(Long commentorObjectGuid) {
		this.commentorObjectGuid = commentorObjectGuid;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public Long getObjectGuid() {
		return objectGuid;
	}

	public void setObjectGuid(Long objectGuid) {
		this.objectGuid = objectGuid;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Long getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(Long parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

	public String getCommentType() {
		if (commentType == null || commentType.isEmpty()) {
			commentType = "Text";
		}
		return commentType;
	}

	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}

}
