/*
 * 
 */
package com.kasisripriyawebapps.myindia.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class LocationEntity.
 */
@Entity
@Table(name = "LOCATION_REFERENCE")
@NamedQueries({ @NamedQuery(name = "DELETE_ALL_LOCATIONS", query = "delete from Location"),
		@NamedQuery(name = "DELETE_RURAL_LOCATIONS", query = "delete from Location where locationVillage is not null"),
		@NamedQuery(name = "DELETE_URBAN_LOCATIONS", query = "delete from Location where locationVillage is null")})
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nativeLocation", cascade = CascadeType.ALL)
	private List<UserInfo> locationUsers =new ArrayList<UserInfo>(0);;

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

	

	public List<UserInfo> getLocationUsers() {
		return locationUsers;
	}

	public void setLocationUsers(List<UserInfo> locationUsers) {
		this.locationUsers = locationUsers;
	}

	public Long getLocationCountry() {
		return locationCountry;
	}

	public void setLocationCountry(Long locationCountry) {
		this.locationCountry = locationCountry;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationCountry == null) ? 0 : locationCountry.hashCode());
		result = prime * result + ((locationDistrict == null) ? 0 : locationDistrict.hashCode());
		result = prime * result
				+ ((locationMunicipalCorporation == null) ? 0 : locationMunicipalCorporation.hashCode());
		result = prime * result + ((locationMunicipality == null) ? 0 : locationMunicipality.hashCode());
		result = prime * result + ((locationState == null) ? 0 : locationState.hashCode());
		result = prime * result + ((locationSubDistrict == null) ? 0 : locationSubDistrict.hashCode());
		result = prime * result + ((locationTownPanchayat == null) ? 0 : locationTownPanchayat.hashCode());
		result = prime * result + ((locationVillage == null) ? 0 : locationVillage.hashCode());
		result = prime * result + ((locationVillagePanchayat == null) ? 0 : locationVillagePanchayat.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (locationCountry == null) {
			if (other.locationCountry != null)
				return false;
		} else if (!locationCountry.equals(other.locationCountry))
			return false;
		if (locationDistrict == null) {
			if (other.locationDistrict != null)
				return false;
		} else if (!locationDistrict.equals(other.locationDistrict))
			return false;
		if (locationMunicipalCorporation == null) {
			if (other.locationMunicipalCorporation != null)
				return false;
		} else if (!locationMunicipalCorporation.equals(other.locationMunicipalCorporation))
			return false;
		if (locationMunicipality == null) {
			if (other.locationMunicipality != null)
				return false;
		} else if (!locationMunicipality.equals(other.locationMunicipality))
			return false;
		if (locationState == null) {
			if (other.locationState != null)
				return false;
		} else if (!locationState.equals(other.locationState))
			return false;
		if (locationSubDistrict == null) {
			if (other.locationSubDistrict != null)
				return false;
		} else if (!locationSubDistrict.equals(other.locationSubDistrict))
			return false;
		if (locationTownPanchayat == null) {
			if (other.locationTownPanchayat != null)
				return false;
		} else if (!locationTownPanchayat.equals(other.locationTownPanchayat))
			return false;
		if (locationVillage == null) {
			if (other.locationVillage != null)
				return false;
		} else if (!locationVillage.equals(other.locationVillage))
			return false;
		if (locationVillagePanchayat == null) {
			if (other.locationVillagePanchayat != null)
				return false;
		} else if (!locationVillagePanchayat.equals(other.locationVillagePanchayat))
			return false;
		return true;
	}

}
