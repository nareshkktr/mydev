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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATION_MASTER")
public class LocationMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8443244270848172413L;
	@Id
	@Column(name = "LOCATION_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	/** The location type. */
	@Column(name = "LOCATION_CODE")
	private Long locationCode;

	/** The location name. */
	@Column(name = "LOCATION_NAME")
	private String locationName;

	/** The location type. */
	@Column(name = "LOCATION_TYPE")
	private String locationType;

	@Column(name = "PARENT_LOCATION_CODE")
	private Long parentLocationCode;

	@OneToMany(mappedBy = "createdLocation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Event> events = new ArrayList<Event>(0);

	@OneToMany(mappedBy = "createdLocation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Problem> problems = new ArrayList<Problem>(0);

	@OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LocationImage> locationImages = new ArrayList<LocationImage>(0);

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "locatedIn")
	private List<Party> parties = new ArrayList<Party>(0);

	@OneToMany(mappedBy = "electedLocation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Politician> politicians = new ArrayList<Politician>(0);

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "userPoliticalLocations")
	private List<UserInfo> locationUsers = new ArrayList<UserInfo>(0);

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "masterLocation", cascade = CascadeType.ALL)
	private UserInfo userInfo;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public Long getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(Long locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
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
		this.problems = problems;
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

	public List<Party> getParties() {
		return parties;
	}

	public void setParties(List<Party> parties) {
		this.parties.clear();
		if (parties != null) {
			this.parties.addAll(parties);
		}
	}

	public List<Politician> getPoliticians() {
		return politicians;
	}

	public void setPoliticians(List<Politician> politicians) {
		this.politicians.clear();
		if (politicians != null) {
			this.politicians.addAll(politicians);
		}
	}

	public Long getParentLocationCode() {
		return parentLocationCode;
	}

	public void setParentLocationCode(Long parentLocationCode) {
		this.parentLocationCode = parentLocationCode;
	}

	public List<UserInfo> getLocationUsers() {
		return locationUsers;
	}

	public void setLocationUsers(List<UserInfo> locationUsers) {
		this.locationUsers.clear();
		if (locationUsers != null) {
			this.locationUsers.addAll(locationUsers);
		}
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationCode == null) ? 0 : locationCode.hashCode());
		result = prime * result + ((locationName == null) ? 0 : locationName.hashCode());
		result = prime * result + ((locationType == null) ? 0 : locationType.hashCode());
		result = prime * result + ((parentLocationCode == null) ? 0 : parentLocationCode.hashCode());
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
		LocationMaster other = (LocationMaster) obj;
		if (locationCode == null) {
			if (other.locationCode != null)
				return false;
		} else if (!locationCode.equals(other.locationCode))
			return false;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		if (locationType == null) {
			if (other.locationType != null)
				return false;
		} else if (!locationType.equals(other.locationType))
			return false;
		if (parentLocationCode == null) {
			if (other.parentLocationCode != null)
				return false;
		} else if (!parentLocationCode.equals(other.parentLocationCode))
			return false;
		return true;
	}

}
