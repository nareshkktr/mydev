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

	
}
