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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

// TODO: Auto-generated Javadoc
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

	public Problem(Long guid, Location location, String problemShortDescription, String problemLongDescription,
			String photoURL, Long noOfAffectedPeople, Timestamp createdTimeStamp, Timestamp updatedTimeStamp,
			Long createdBy, Long updatedBy) {
		super();
		this.guid = guid;
		this.location = location;
		this.problemShortDescription = problemShortDescription;
		this.problemLongDescription = problemLongDescription;
		this.photoURL = photoURL;
		this.noOfAffectedPeople = noOfAffectedPeople;
		this.createdTimeStamp = createdTimeStamp;
		this.updatedTimeStamp = updatedTimeStamp;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	@Id
	@Column(name = "PROBLEM_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCATION_GUID")
	@JsonBackReference
	private Location location;

	@Column(name = "SHORT_DESCRIPTION")
	private String problemShortDescription;

	@Column(name = "LONG_DESCRIPTION")
	private String problemLongDescription;

	@Column(name = "PHOTO_URL")
	private String photoURL;

	@Column(name = "NO_OF_EFFECTED_PEOPLE")
	private Long noOfAffectedPeople;

	/** The created time stamp. */
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	/** The updated time stamp. */
	@Column(name = "UPDATED_TIMESTAMP")
	private Timestamp updatedTimeStamp;

	/** The created by. */
	@Column(name = "CREATED_BY")
	private Long createdBy;

	/** The updated by. */
	@Column(name = "UPDATED_BY")
	private Long updatedBy;

	@OneToMany(mappedBy = "problem", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<ProblemImage> problemImages = new ArrayList<ProblemImage>(0);

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "PROBLEM_TYPE_GUID")
	@JsonBackReference
	private ProblemType problemType;

	@OneToMany(mappedBy = "problem", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<ProblemHistory> problemHistory = new ArrayList<ProblemHistory>(0);

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
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

}
