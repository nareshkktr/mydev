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
	private Long parent_guid;

	public Ministry() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ministry(Long guid, String name, String level, Long parent_guid) {
		super();
		this.guid = guid;
		this.name = name;
		this.level = level;
		this.parent_guid = parent_guid;
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

	public Long getParent_guid() {
		return parent_guid;
	}

	public void setParent_guid(Long parent_guid) {
		this.parent_guid = parent_guid;
	}

}
