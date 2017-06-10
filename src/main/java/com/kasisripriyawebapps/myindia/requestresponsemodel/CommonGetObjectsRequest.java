package com.kasisripriyawebapps.myindia.requestresponsemodel;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;

public class CommonGetObjectsRequest {

	private String objectType;
	private Long objectGuid;
	private Integer pageOffset;
	private Integer pageLimit;
	private Long subObjectGuid;

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

	public Integer getPageOffset() {
		if (pageOffset == null) {
			pageOffset = ApplicationConstants.PAGE_START;
		}
		return pageOffset;
	}

	public void setPageOffset(Integer pageOffset) {
		this.pageOffset = pageOffset;
	}

	public Integer getPageLimit() {
		if (pageLimit == null) {
			pageLimit = ApplicationConstants.PAGE_LIMIT;
		}
		return pageLimit;
	}

	public void setPageLimit(Integer pageLimit) {
		this.pageLimit = pageLimit;
	}

	public Long getSubObjectGuid() {
		return subObjectGuid;
	}

	public void setSubObjectGuid(Long subObjectGuid) {
		this.subObjectGuid = subObjectGuid;
	}

}
