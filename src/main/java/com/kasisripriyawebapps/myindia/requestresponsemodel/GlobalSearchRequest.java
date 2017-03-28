package com.kasisripriyawebapps.myindia.requestresponsemodel;

public class GlobalSearchRequest {

	private String searchText;
	private String searchObjectType;
	private Integer pageLimit;
	private Integer pageOffset;

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getSearchObjectType() {
		if (searchObjectType == null || searchObjectType.isEmpty()) {
			searchObjectType = "ALL";
		}
		return searchObjectType;
	}

	public void setSearchObjectType(String searchObjectType) {
		this.searchObjectType = searchObjectType;
	}

	public Integer getPageLimit() {
		if (pageLimit == null || pageLimit == 0) {
			pageLimit = 25;
		}
		return pageLimit;
	}

	public void setPageLimit(Integer pageLimit) {
		this.pageLimit = pageLimit;
	}

	public Integer getPageOffset() {
		if (pageOffset == null) {
			pageOffset = 1;
		} else if (pageOffset > 0) {
			pageOffset = pageOffset - 1;
		}
		return pageOffset;
	}

	public void setPageOffset(Integer pageOffset) {
		this.pageOffset = pageOffset;
	}

}
