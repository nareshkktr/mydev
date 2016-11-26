package com.kasisripriyawebapps.myindia.solr.entity;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "locationReference")
public class SolrLocationReference {

	@Id
	@Field
	private Long locationRefGuid;
	@Field
	private Long locationCountry;
	@Field
	private Long locationState;
	@Field
	private Long locationDistrict;
	@Field
	private Long locationSubDistrict;
	@Field
	private Long locationMunicipalCorporation;
	@Field
	private Long locationMunicipality;
	@Field
	private Long locationTownPanchayat;
	@Field
	private Long locationVillagePanchayat;
	@Field
	private Long locationVillage;

	public Long getLocationRefGuid() {
		return locationRefGuid;
	}

	public void setLocationRefGuid(Long locationRefGuid) {
		this.locationRefGuid = locationRefGuid;
	}

	public Long getLocationCountry() {
		return locationCountry;
	}

	public void setLocationCountry(Long locationCountry) {
		this.locationCountry = locationCountry;
	}

	public Long getLocationState() {
		return locationState;
	}

	public void setLocationState(Long locationState) {
		this.locationState = locationState;
	}

	public Long getLocationDistrict() {
		return locationDistrict;
	}

	public void setLocationDistrict(Long locationDistrict) {
		this.locationDistrict = locationDistrict;
	}

	public Long getLocationSubDistrict() {
		return locationSubDistrict;
	}

	public void setLocationSubDistrict(Long locationSubDistrict) {
		this.locationSubDistrict = locationSubDistrict;
	}

	public Long getLocationMunicipalCorporation() {
		return locationMunicipalCorporation;
	}

	public void setLocationMunicipalCorporation(Long locationMunicipalCorporation) {
		this.locationMunicipalCorporation = locationMunicipalCorporation;
	}

	public Long getLocationMunicipality() {
		return locationMunicipality;
	}

	public void setLocationMunicipality(Long locationMunicipality) {
		this.locationMunicipality = locationMunicipality;
	}

	public Long getLocationTownPanchayat() {
		return locationTownPanchayat;
	}

	public void setLocationTownPanchayat(Long locationTownPanchayat) {
		this.locationTownPanchayat = locationTownPanchayat;
	}

	public Long getLocationVillagePanchayat() {
		return locationVillagePanchayat;
	}

	public void setLocationVillagePanchayat(Long locationVillagePanchayat) {
		this.locationVillagePanchayat = locationVillagePanchayat;
	}

	public Long getLocationVillage() {
		return locationVillage;
	}

	public void setLocationVillage(Long locationVillage) {
		this.locationVillage = locationVillage;
	}

}
