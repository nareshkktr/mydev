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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

// TODO: Auto-generated Javadoc
/**
 * The Class Party.
 */
@Entity
@Table(name = "PARTY_MASTER")
public class Party implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4964660007115077086L;

	/**
	 * Instantiates a new party entity.
	 */
	public Party() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "PARTY_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@Column(name = "PARTY_NAME")
	private String partyName;

	@Column(name = "PARTY_ABBREVATION")
	private String partyAbbrevation;

	@Column(name = "BANNER_PHOTO_URL")
	private String bannerPhotoUrl;

	@Column(name = "PHOTO_URL")
	private String photoURL;

	@Column(name = "FOUNDATION_YEAR")
	private Integer foundationYear;

	@Column(name = "POPULARITY_COUNT")
	private Long popularityCount;

	@Column(name = "SUPPORTING_COUNT")
	private Long supportingCount;

	@Column(name = "FOLLOWING_COUNT")
	private Long followingCount;

	@Column(name = "SHARE_COUNT")
	private Long shareCount;

	@Column(name = "IS_NATIONAL_PARTY")
	private Boolean isNationalParty;

	@OneToMany(mappedBy = "party", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<PartyImage> partyImages = new ArrayList<PartyImage>(0);

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "PARTY_LOCATION", catalog = "myindia", joinColumns = {
			@JoinColumn(name = "PARTY_GUID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "LOCATION_GUID", nullable = false, updatable = false) })
	private List<LocationMaster> locatedIn = new ArrayList<LocationMaster>(0);

	@OneToMany(mappedBy = "party", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Politician> politicians = new ArrayList<Politician>(0);

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getPartyAbbrevation() {
		return partyAbbrevation;
	}

	public void setPartyAbbrevation(String partyAbbrevation) {
		this.partyAbbrevation = partyAbbrevation;
	}

	public String getBannerPhotoUrl() {
		return bannerPhotoUrl;
	}

	public void setBannerPhotoUrl(String bannerPhotoUrl) {
		this.bannerPhotoUrl = bannerPhotoUrl;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public Long getPopularityCount() {
		return popularityCount;
	}

	public void setPopularityCount(Long popularityCount) {
		this.popularityCount = popularityCount;
	}

	public Long getSupportingCount() {
		return supportingCount;
	}

	public void setSupportingCount(Long supportingCount) {
		this.supportingCount = supportingCount;
	}

	public Long getFollowingCount() {
		return followingCount;
	}

	public void setFollowingCount(Long followingCount) {
		this.followingCount = followingCount;
	}

	public Long getShareCount() {
		return shareCount;
	}

	public void setShareCount(Long shareCount) {
		this.shareCount = shareCount;
	}

	public List<PartyImage> getPartyImages() {
		return partyImages;
	}

	public void setPartyImages(List<PartyImage> partyImages) {
		this.partyImages.clear();
		if (partyImages != null) {
			this.partyImages.addAll(partyImages);
		}
	}

	public Integer getFoundationYear() {
		return foundationYear;
	}

	public void setFoundationYear(Integer foundationYear) {
		this.foundationYear = foundationYear;
	}

	public List<LocationMaster> getLocatedIn() {
		return locatedIn;
	}

	public void setLocatedIn(List<LocationMaster> locatedIn) {

		this.locatedIn.clear();
		if (locatedIn != null) {
			this.locatedIn.addAll(locatedIn);
		}
	}

	public Boolean getIsNationalParty() {
		return isNationalParty;
	}

	public void setIsNationalParty(Boolean isNationalParty) {
		this.isNationalParty = isNationalParty;
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

}
