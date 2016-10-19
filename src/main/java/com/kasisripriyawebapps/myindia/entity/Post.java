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

import com.fasterxml.jackson.annotation.JsonManagedReference;

// TODO: Auto-generated Javadoc
/**
 * The Class Post.
 */
@Entity
@Table(name = "POST_MASTER")
public class Post implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7688678629691760137L;

	/**
	 * Instantiates a new post entity.
	 */
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(Long guid, String postToObjectType, Long postToObjectGuid, String postText,
			String postContentObjectType, Long postContentObjectGuid, Timestamp createdTimeStamp, Long createdBy) {
		super();
		this.guid = guid;
		this.postToObjectType = postToObjectType;
		this.postToObjectGuid = postToObjectGuid;
		this.postText = postText;
		this.postContentObjectType = postContentObjectType;
		this.postContentObjectGuid = postContentObjectGuid;
		this.createdTimeStamp = createdTimeStamp;
		this.createdBy = createdBy;
	}

	/** The guid. */
	@Id
	@Column(name = "POST_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	/** The object type. */
	@Column(name = "POST_TO_OBJECT_TYPE")
	private String postToObjectType;

	/** The object type. */
	@Column(name = "POST_TO_OBJECT_GUID")
	private Long postToObjectGuid;

	@Column(name = "POST_TEXT")
	private String postText;

	/** The object type. */
	@Column(name = "POST_CONTENT_OBJECT_TYPE")
	private String postContentObjectType;

	/** The object type. */
	@Column(name = "POST_CONTENT_OBJECT_GUID")
	private Long postContentObjectGuid;

	/** The created time stamp. */
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	/** The created by. */
	@Column(name = "CREATED_BY")
	private Long createdBy;

	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<PostImage> postImages = new ArrayList<PostImage>(0);

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getPostToObjectType() {
		return postToObjectType;
	}

	public void setPostToObjectType(String postToObjectType) {
		this.postToObjectType = postToObjectType;
	}

	public Long getPostToObjectGuid() {
		return postToObjectGuid;
	}

	public void setPostToObjectGuid(Long postToObjectGuid) {
		this.postToObjectGuid = postToObjectGuid;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public String getPostContentObjectType() {
		return postContentObjectType;
	}

	public void setPostContentObjectType(String postContentObjectType) {
		this.postContentObjectType = postContentObjectType;
	}

	public Long getPostContentObjectGuid() {
		return postContentObjectGuid;
	}

	public void setPostContentObjectGuid(Long postContentObjectGuid) {
		this.postContentObjectGuid = postContentObjectGuid;
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

	public List<PostImage> getPostImages() {
		return postImages;
	}

	public void setPostImages(List<PostImage> postImages) {
		this.postImages.clear();
		if (postImages != null) {
			this.postImages.addAll(postImages);
		}
	}

}
