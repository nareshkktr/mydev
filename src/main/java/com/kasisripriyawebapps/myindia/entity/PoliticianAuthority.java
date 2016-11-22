package com.kasisripriyawebapps.myindia.entity;

/*
 * 
 */

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Politician Authority.
 */
@Entity
@Table(name = "POLITICIAN_AUTHORITY")
public class PoliticianAuthority implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9067128188640228442L;

	/**
	 * Instantiates a new politician Authority entity.
	 */
	public PoliticianAuthority() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PoliticianAuthority(Long guid, String designation,
			LocationMaster electedLocation, Long popularityCount) {
		super();
		this.guid = guid;
		this.designation = designation;
		this.electedLocation = electedLocation;
		this.popularityCount = popularityCount;
	}

	@Id
	@Column(name = "POLITICIAN_AUTHORITY_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@Column(name = "DESIGNATION")
	private String designation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCATION_GUID")
	private LocationMaster electedLocation;


	@Column(name = "POPULARITY_COUNT")
	private Long popularityCount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARTY_GUID")
	private Party party;

	@Column(name = "POLITICIAN_TYPE")
	private String politicianType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POLITICIAN_GUID")
	private Politician politician;
	
	@Column(name = "ACTIVE")
	private boolean isActive;
	
	@Column(name = "START_DATE")
	private Date startDate;
	
	@Column(name = "END_DATE")
	private Date endDate;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}


	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public LocationMaster getElectedLocation() {
		return electedLocation;
	}

	public void setElectedLocation(LocationMaster electedLocation) {
		this.electedLocation = electedLocation;
	}

	public Long getPopularityCount() {
		return popularityCount;
	}

	public void setPopularityCount(Long popularityCount) {
		this.popularityCount = popularityCount;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public String getPoliticianType() {
		return politicianType;
	}

	public void setPoliticianType(String politicianType) {
		this.politicianType = politicianType;
	}
	
	public Politician getPolitician() {
		return politician;
	}

	public void setPolitician(Politician politician) {
		this.politician = politician;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((electedLocation == null) ? 0 : electedLocation.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((party == null) ? 0 : party.hashCode());
		result = prime * result + ((politician == null) ? 0 : politician.hashCode());
		result = prime * result + ((politicianType == null) ? 0 : politicianType.hashCode());
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
		PoliticianAuthority other = (PoliticianAuthority) obj;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (electedLocation == null) {
			if (other.electedLocation != null)
				return false;
		} else if (!electedLocation.equals(other.electedLocation))
			return false;
		if (isActive != other.isActive)
			return false;
		if (party == null) {
			if (other.party != null)
				return false;
		} else if (!party.equals(other.party))
			return false;
		if (politician == null) {
			if (other.politician != null)
				return false;
		} else if (!politician.equals(other.politician))
			return false;
		if (politicianType == null) {
			if (other.politicianType != null)
				return false;
		} else if (!politicianType.equals(other.politicianType))
			return false;
		return true;
	}
	
	
}

