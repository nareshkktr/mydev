package com.kasisripriyawebapps.myindia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MINISTRY")
public class Ministry {

	@Id
	@Column(name = "MINISTRY_DEPARTMENT_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@Column(name = "MINISTRY_DEPARTMENT_NAME")
	private String name;

	@Column(name = "MINISTRY_DEPARTMENT_LEVEL")
	private String level;

	@Column(name = "MINISTRY_DEPARTMENT_PARENT_GUID")
	private Long parentGuid;

	public Ministry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ministry(Long guid, String name, String level, Long parentGuid) {
		super();
		this.guid = guid;
		this.name = name;
		this.level = level;
		this.parentGuid = parentGuid;
	}

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Long getParentGuid() {
		return parentGuid;
	}

	public void setParentGuid(Long parentGuid) {
		this.parentGuid = parentGuid;
	}

}
