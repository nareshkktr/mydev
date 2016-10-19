package com.kasisripriyawebapps.myindia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "POST_IMAGE")
public class PostImage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 451773781485333068L;

	@Id
	@Column(name = "POST_IMAGE_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@Column(name = "IMAGE_NAME")
	private String imageName;

	@Column(name = "IMAGE_URL")
	private String imageURL;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POST_GUID")
	@JsonBackReference
	private Post post;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
