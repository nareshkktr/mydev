/*
 * 
 */
package com.kasisripriyawebapps.myindia.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class LocationEntity.
 */
@Entity
@Table(name = "LOCATION_REFERENCE")
@NamedQueries({ @NamedQuery(name = "DELETE_ALL_LOCATIONS", query = "delete from Location") })
public class Location implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1804800536922129035L;

	/**
	 * Instantiates a new location entity.
	 */
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** The guid. */
	@Id
	@Column(name = "LOCATION_REF_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	/** The location state. */
	@Column(name = "LOCATION_COUNTRY")
	private Long locationCountry;

	/** The location state. */
	@Column(name = "LOCATION_STATE")
	private Long locationState;

	/** The location district. */
	@Column(name = "LOCATION_DISTRICT")
	private Long locationDistrict;

	/** The location mandal. */
	@Column(name = "LOCATION_SUB_DISTIRCT")
	private Long locationSubDistrict;

	/** The location muncipal corporation. */
	@Column(name = "LOCATION_MUNICIPAL_CORPORATION")
	private Long locationMunicipalCorporation;

	/** The location corporation. */
	@Column(name = "LOCATION_MUNICIPALITY")
	private Long locationMunicipality;

	/** The location corporation. */
	@Column(name = "LOCATION_TOWN_PANCHAYAT")
	private Long locationTownPanchayat;

	/** The location panchayath. */
	@Column(name = "LOCATION_VILLAGE_PANCHAYATH")
	private Long locationVillagePanchayat;

	/** The location village. */
	@Column(name = "LOCATION_VILLAGE")
	private Long locationVillage;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "nativeLocation", cascade = CascadeType.ALL)
	private UserInfo userInfo;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
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

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Long getLocationCountry() {
		return locationCountry;
	}

	public void setLocationCountry(Long locationCountry) {
		this.locationCountry = locationCountry;
	}

}
