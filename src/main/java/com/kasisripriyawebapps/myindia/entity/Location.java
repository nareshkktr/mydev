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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

// TODO: Auto-generated Javadoc
/**
 * The Class LocationEntity.
 */
@Entity
@Table(name = "LOCATION_REFERENCE")
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

	public Location(Long guid, String locationType, String locationName, String locationCountry, String locationState,
			String locationMuncipalCorporation, String locationCorporation, String locationMpConstituency,
			String locationMlaConstituency, String locationDistrict, String locationMandal, String locationPanchayath,
			String locationVillage, List<Event> events) {
		super();
		this.guid = guid;
		this.locationType = locationType;
		this.locationName = locationName;
		this.locationCountry = locationCountry;
		this.locationState = locationState;
		this.locationMuncipalCorporation = locationMuncipalCorporation;
		this.locationCorporation = locationCorporation;
		this.locationMpConstituency = locationMpConstituency;
		this.locationMlaConstituency = locationMlaConstituency;
		this.locationDistrict = locationDistrict;
		this.locationMandal = locationMandal;
		this.locationPanchayath = locationPanchayath;
		this.locationVillage = locationVillage;
		this.events = events;
	}

	/** The guid. */
	@Id
	@Column(name = "LOCATION_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	/** The location type. */
	@Column(name = "LOCATION_TYPE")
	private String locationType;

	/** The location name. */
	@Column(name = "LOCATION_NAME")
	private String locationName;

	/** The location country. */
	@Column(name = "LOCATION_COUNTRY")
	private String locationCountry;

	/** The location state. */
	@Column(name = "LOCATION_STATE")
	private String locationState;

	/** The location muncipal corporation. */
	@Column(name = "LOCATION_MUNCIPAL_CORPORATION")
	private String locationMuncipalCorporation;

	/** The location corporation. */
	@Column(name = "LOCATION_CORPORATION")
	private String locationCorporation;

	/** The location country. */
	@Column(name = "LOCATION_MP_CONSTITUENCY")
	private String locationMpConstituency;

	/** The location state. */
	@Column(name = "LOCATION_MLA_CONSTITUENCY")
	private String locationMlaConstituency;

	/** The location district. */
	@Column(name = "LOCATION_DISTRICT")
	private String locationDistrict;

	/** The location mandal. */
	@Column(name = "LOCATION_MANDAL")
	private String locationMandal;

	/** The location panchayath. */
	@Column(name = "LOCATION_PANCHAYATH")
	private String locationPanchayath;

	/** The location village. */
	@Column(name = "LOCATION_VILLAGE")
	private String locationVillage;

	@OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Event> events = new ArrayList<Event>(0);

	@OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<Problem> problems = new ArrayList<Problem>(0);

	@OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<LocationImage> locationImages = new ArrayList<LocationImage>(0);

	@OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<UserInfo> users = new ArrayList<UserInfo>(0);

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationCountry() {
		return locationCountry;
	}

	public void setLocationCountry(String locationCountry) {
		this.locationCountry = locationCountry;
	}

	public String getLocationState() {
		return locationState;
	}

	public void setLocationState(String locationState) {
		this.locationState = locationState;
	}

	public String getLocationMuncipalCorporation() {
		return locationMuncipalCorporation;
	}

	public void setLocationMuncipalCorporation(String locationMuncipalCorporation) {
		this.locationMuncipalCorporation = locationMuncipalCorporation;
	}

	public String getLocationCorporation() {
		return locationCorporation;
	}

	public void setLocationCorporation(String locationCorporation) {
		this.locationCorporation = locationCorporation;
	}

	public String getLocationMpConstituency() {
		return locationMpConstituency;
	}

	public void setLocationMpConstituency(String locationMpConstituency) {
		this.locationMpConstituency = locationMpConstituency;
	}

	public String getLocationMlaConstituency() {
		return locationMlaConstituency;
	}

	public void setLocationMlaConstituency(String locationMlaConstituency) {
		this.locationMlaConstituency = locationMlaConstituency;
	}

	public String getLocationDistrict() {
		return locationDistrict;
	}

	public void setLocationDistrict(String locationDistrict) {
		this.locationDistrict = locationDistrict;
	}

	public String getLocationMandal() {
		return locationMandal;
	}

	public void setLocationMandal(String locationMandal) {
		this.locationMandal = locationMandal;
	}

	public String getLocationPanchayath() {
		return locationPanchayath;
	}

	public void setLocationPanchayath(String locationPanchayath) {
		this.locationPanchayath = locationPanchayath;
	}

	public String getLocationVillage() {
		return locationVillage;
	}

	public void setLocationVillage(String locationVillage) {
		this.locationVillage = locationVillage;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events.clear();
		if (events != null) {
			this.events.addAll(events);
		}
	}

	public List<Problem> getProblems() {
		return problems;
	}

	public void setProblems(List<Problem> problems) {
		this.problems.clear();
		if (problems != null) {
			this.problems.addAll(problems);
		}
	}

	public List<LocationImage> getLocationImages() {
		return locationImages;
	}

	public void setLocationImages(List<LocationImage> locationImages) {
		this.locationImages.clear();
		if (locationImages != null) {
			this.locationImages.addAll(locationImages);
		}
	}

	public List<UserInfo> getUsers() {
		return users;
	}

	public void setUsers(List<UserInfo> users) {
		this.users.clear();
		if (users != null) {
			this.users.addAll(users);
		}
	}

}
