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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Politician.
 */
@Entity
@Table(name = "POLITICIAN_MASTER")
public class Politician implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6939818540547757814L;

	/**
	 * Instantiates a new politician entity.
	 */
	public Politician() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Politician(Long guid, String fullName, String designation, String bannerPhotoURL, String photoURL,
			LocationMaster electedLocation, Long popularityCount, Long supportingCount, Long followingCount,
			Long shareCount) {
		super();
		this.guid = guid;
		this.fullName = fullName;
		this.designation = designation;
		this.bannerPhotoURL = bannerPhotoURL;
		this.photoURL = photoURL;
		this.electedLocation = electedLocation;
		this.popularityCount = popularityCount;
		this.supportingCount = supportingCount;
		this.followingCount = followingCount;
		this.shareCount = shareCount;
	}

	@Id
	@Column(name = "POLITICIAN_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@Column(name = "FULL_NAME")
	private String fullName;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "BANNER_PHOTO_URL")
	private String bannerPhotoURL;

	@Column(name = "PHOTO_URL")
	private String photoURL;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCATION_GUID")
	private LocationMaster electedLocation;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCATION_REF_GUID")
	private Location nativeLocation;

	@Column(name = "POPULARITY_COUNT")
	private Long popularityCount;

	@Column(name = "SUPPORTING_COUNT")
	private Long supportingCount;

	@Column(name = "FOLLOWING_COUNT")
	private Long followingCount;

	@Column(name = "SHARE_COUNT")
	private Long shareCount;

	@OneToMany(mappedBy = "politician", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PoliticianImage> politicianImages = new ArrayList<PoliticianImage>(0);

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARTY_GUID")
	private Party party;

	@Column(name = "POLITICIAN_TYPE")
	private String politicianType;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getBannerPhotoURL() {
		return bannerPhotoURL;
	}

	public void setBannerPhotoURL(String bannerPhotoURL) {
		this.bannerPhotoURL = bannerPhotoURL;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
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

	public List<PoliticianImage> getPoliticianImages() {
		return politicianImages;
	}

	public void setPoliticianImages(List<PoliticianImage> politicianImages) {
		this.politicianImages.clear();
		if (politicianImages != null) {
			this.politicianImages.addAll(politicianImages);
		}
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

	public Location getNativeLocation() {
		return nativeLocation;
	}

	public void setNativeLocation(Location nativeLocation) {
		this.nativeLocation = nativeLocation;
	}

}
