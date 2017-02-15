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
@Table(name = "PROBLEM_OWNER")
public class ProblemOwner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 451773781485333068L;

	@Id
	@Column(name = "PROBLEM_OWNER_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@Column(name = "IMAGE_URL")
	private String imageURL;

	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	@Column(name = "CREATED_BY")
	private Long createdBy;
	
	@Column(name = "MODIFIED_TIMESTAMP")
	private Timestamp modifiedTimestamp;

	@Column(name = "MODIFIED_BY")
	private Long modifiedBy;
	
	@Column(name = "CATEGORY")
	private Long category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROBLEM_GUID")
	private Problem problem;


}
