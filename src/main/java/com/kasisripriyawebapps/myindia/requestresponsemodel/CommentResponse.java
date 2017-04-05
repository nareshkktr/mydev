package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentResponse {
	
	/** The guid. */
	private Long guid;

	/** The commentor object type. */
	private BaseUserInformation commentor;

	/** The object type. */
	private String objectType;

	/** The object guid. */
	private Long objectGuid;

	/** The comment text. */
	private String commentText;

	/** The parent comment id. */
	private Long parentCommentId;

	/** The created time stamp. */
	@JsonFormat(pattern = "EEE, MMM dd yyyy HH:mm:ss")
	private Timestamp createdTimeStamp;
	
	/** The created time stamp. */
	@JsonFormat(pattern = "EEE, MMM dd yyyy HH:mm:ss")
	private Timestamp updatedTimeStamp;
	
	/** The number of replies for the given comment. */
	private Integer replyCount;
	
	/** Type of comment **/
	private String commentType;
	
	

	public CommentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentResponse(Long guid, BaseUserInformation commentor, String objectType, Long objectGuid,
			String commentText, Long parentCommentId, Timestamp createdTimeStamp, Timestamp updatedTimeStamp,
			Integer replyCount, String commentType) {
		super();
		this.guid = guid;
		this.commentor = commentor;
		this.objectType = objectType;
		this.objectGuid = objectGuid;
		this.commentText = commentText;
		this.parentCommentId = parentCommentId;
		this.createdTimeStamp = createdTimeStamp;
		this.updatedTimeStamp = updatedTimeStamp;
		this.replyCount = replyCount;
		this.commentType = commentType;
	}



	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public BaseUserInformation getCommentor() {
		return commentor;
	}

	public void setCommentor(BaseUserInformation commentor) {
		this.commentor = commentor;
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

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public String getCommentType() {
		return commentType;
	}

	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}

}
