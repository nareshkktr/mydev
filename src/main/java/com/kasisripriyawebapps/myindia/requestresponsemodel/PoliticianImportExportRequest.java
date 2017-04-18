package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.util.List;

public class PoliticianImportExportRequest {
	
	List<String> states;
	List<String> districts;

	public List<String> getStates() {
		return states;
	}

	public void setStates(List<String> states) {
		this.states = states;
	}

	public List<String> getDistricts() {
		return districts;
	}

	public void setDistricts(List<String> districts) {
		this.districts = districts;
	}	
	
	

}
