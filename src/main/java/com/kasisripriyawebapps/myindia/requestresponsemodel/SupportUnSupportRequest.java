package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.io.Serializable;

public class SupportUnSupportRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1891856605609525811L;

	private String supportObjectType;
	private Long supportObjectGuid;
	private String supportingObjectType;
	private Long supportingObjectGuid;

	public String getSupportObjectType() {
		return supportObjectType;
	}

	public void setSupportObjectType(String supportObjectType) {
		this.supportObjectType = supportObjectType;
	}

	public Long getSupportObjectGuid() {
		return supportObjectGuid;
	}

	public void setSupportObjectGuid(Long supportObjectGuid) {
		this.supportObjectGuid = supportObjectGuid;
	}

	public String getSupportingObjectType() {
		return supportingObjectType;
	}

	public void setSupportingObjectType(String supportingObjectType) {
		this.supportingObjectType = supportingObjectType;
	}

	public Long getSupportingObjectGuid() {
		return supportingObjectGuid;
	}

	public void setSupportingObjectGuid(Long supportingObjectGuid) {
		this.supportingObjectGuid = supportingObjectGuid;
	}

}
