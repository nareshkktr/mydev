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
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class CommentEntity.
 */
@Entity
@Table(name = "COMMENT_MASTER")
public class Comment implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5746691738240394211L;

	/** The guid. */
	@Id
	@Column(name = "COMEMNT_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	/** The commentor object type. */
	@Column(name = "COMMENTOR_OBJECT_TYPE")
	private String commentorObjectType;

	/** The commentor object guid. */
	@Column(name = "COMMENTOR_OBJECT_GUID")
	private Long commentorObjectGuid;

	/** The object type. */
	@Column(name = "OBJECT_TYPE")
	private String objectType;

	/** The object guid. */
	@Column(name = "OBJECT_GUID")
	private Long objectGuid;

	/** The comment text. */
	@Column(name = "COMMENT_TEXT")
	private String commentText;

	/** The parent comment id. */
	@Column(name = "PARENT_COMMENT_ID")
	private Long parentCommentId;

	/** The created time stamp. */
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	@OneToMany(mappedBy = "comment", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CommentImage> commentImages = new ArrayList<CommentImage>(0);

	/**
	 * Gets the guid.
	 *
	 * @return the guid
	 */
	public Long getGuid() {
		return guid;
	}

	/**
	 * Sets the guid.
	 *
	 * @param guid
	 *            the new guid
	 */
	public void setGuid(Long guid) {
		this.guid = guid;
	}

	/**
	 * Gets the commentor object type.
	 *
	 * @return the commentor object type
	 */
	public String getCommentorObjectType() {
		return commentorObjectType;
	}

	/**
	 * Sets the commentor object type.
	 *
	 * @param commentorObjectType
	 *            the new commentor object type
	 */
	public void setCommentorObjectType(String commentorObjectType) {
		this.commentorObjectType = commentorObjectType;
	}

	/**
	 * Gets the commentor object guid.
	 *
	 * @return the commentor object guid
	 */
	public Long getCommentorObjectGuid() {
		return commentorObjectGuid;
	}

	/**
	 * Sets the commentor object guid.
	 *
	 * @param commentorObjectGuid
	 *            the new commentor object guid
	 */
	public void setCommentorObjectGuid(Long commentorObjectGuid) {
		this.commentorObjectGuid = commentorObjectGuid;
	}

	/**
	 * Gets the object type.
	 *
	 * @return the object type
	 */
	public String getObjectType() {
		return objectType;
	}

	/**
	 * Sets the object type.
	 *
	 * @param objectType
	 *            the new object type
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	/**
	 * Gets the object guid.
	 *
	 * @return the object guid
	 */
	public Long getObjectGuid() {
		return objectGuid;
	}

	/**
	 * Sets the object guid.
	 *
	 * @param objectGuid
	 *            the new object guid
	 */
	public void setObjectGuid(Long objectGuid) {
		this.objectGuid = objectGuid;
	}

	/**
	 * Gets the comment text.
	 *
	 * @return the comment text
	 */
	public String getCommentText() {
		return commentText;
	}

	/**
	 * Sets the comment text.
	 *
	 * @param commentText
	 *            the new comment text
	 */
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	/**
	 * Gets the parent comment id.
	 *
	 * @return the parent comment id
	 */
	public Long getParentCommentId() {
		return parentCommentId;
	}

	/**
	 * Sets the parent comment id.
	 *
	 * @param parentCommentId
	 *            the new parent comment id
	 */
	public void setParentCommentId(Long parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

	/**
	 * Gets the created time stamp.
	 *
	 * @return the created time stamp
	 */
	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	/**
	 * Sets the created time stamp.
	 *
	 * @param createdTimeStamp
	 *            the new created time stamp
	 */
	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public List<CommentImage> getCommentImages() {
		return commentImages;
	}

	public void setCommentImages(List<CommentImage> commentImages) {
		this.commentImages.clear();
		if (commentImages != null) {
			this.commentImages.addAll(commentImages);
		}
	}

}
