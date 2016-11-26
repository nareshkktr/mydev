package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.util.ArrayList;
import java.util.List;

import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;

public class LocationReferenceMasterResponse {

	private SolrLocationMaster childLocation = new SolrLocationMaster();
	private List<SolrLocationMaster> parentLocations = new ArrayList<SolrLocationMaster>();

	public SolrLocationMaster getChildLocation() {
		return childLocation;
	}

	public void setChildLocation(SolrLocationMaster childLocation) {
		this.childLocation = childLocation;
	}

	public List<SolrLocationMaster> getParentLocations() {
		return parentLocations;
	}

	public void setParentLocations(List<SolrLocationMaster> parentLocations) {
		this.parentLocations = parentLocations;
	}

}
