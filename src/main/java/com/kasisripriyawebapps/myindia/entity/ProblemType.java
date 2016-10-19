package com.kasisripriyawebapps.myindia.entity;

import java.io.Serializable;
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

@Entity
@Table(name = "PROBLEM_TYPE")
public class ProblemType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7050566653663372683L;

	@Id
	@Column(name = "PROBLEM_TYPE_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@Column(name = "PROBLEM_TYPE_NAME")
	private String problemTypeName;

	@Column(name = "PROBLEM_TYPE_PHOTO_URL")
	private String problemTypePhotoURL;

	@OneToMany(mappedBy = "problemType", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Problem> problems = new ArrayList<Problem>(0);

	public ProblemType(Long guid, String problemTypeName, String problemTypePhotoURL) {
		super();
		this.guid = guid;
		this.problemTypeName = problemTypeName;
		this.problemTypePhotoURL = problemTypePhotoURL;
	}

	public ProblemType() {
		// TODO Auto-generated constructor stub
	}

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getProblemTypeName() {
		return problemTypeName;
	}

	public void setProblemTypeName(String problemTypeName) {
		this.problemTypeName = problemTypeName;
	}

	public String getProblemTypePhotoURL() {
		return problemTypePhotoURL;
	}

	public void setProblemTypePhotoURL(String problemTypePhotoURL) {
		this.problemTypePhotoURL = problemTypePhotoURL;
	}

	public List<Problem> getProblems() {
		return problems;
	}

	public void setProblems(List<Problem> problems) {
		this.problems.clear();
		if (problems != null) {
			this.problems.addAll(problems);
		}
	}

}
