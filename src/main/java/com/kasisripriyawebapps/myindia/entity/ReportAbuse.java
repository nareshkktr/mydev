/*
 * 
 */
package com.kasisripriyawebapps.myindia.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class ReportAbuse.
 */
@Entity
@Table(name = "REPORT_ABUSE")
public class ReportAbuse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5677398172480352893L;

	public ReportAbuse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportAbuse(Long guid, String objectType, Long objectGuid, String reportObjectType,
			Long reportObjectGuid, Timestamp createdTimeStamp) {
		super();
		this.guid = guid;
		this.objectType = objectType;
		this.objectGuid = objectGuid;
		this.reportObjectType = reportObjectType;
		this.reportObjectGuid = reportObjectGuid;
		this.createdTimeStamp = createdTimeStamp;
	}

	/** The guid. */
	@Id
	@Column(name = "REPORT_ABUSE_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	/** The object type. */
	@Column(name = "OBJECT_TYPE")
	private String objectType;

	/** The object guid. */
	@Column(name = "OBJECT_GUID")
	private Long objectGuid;

	/** The share object type. */
	@Column(name = "REPORT_OBJECT_TYPE")
	private String reportObjectType;

	/** The share object guid. */
	@Column(name = "REPORT_OBJECT_GUID")
	private Long reportObjectGuid;

	/** The created time stamp. */
	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
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

	public String getReportObjectType() {
		return reportObjectType;
	}

	public void setReportObjectType(String reportObjectType) {
		this.reportObjectType = reportObjectType;
	}

	public Long getReportObjectGuid() {
		return reportObjectGuid;
	}

	public void setReportObjectGuid(Long reportObjectGuid) {
		this.reportObjectGuid = reportObjectGuid;
	}

	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

}
