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

	public Politician(Long guid, String fullName, String bannerPhotoURL, String photoURL,
			 Long supportingCount, Long followingCount,
			Long shareCount) {
		super();
		this.guid = guid;
		this.fullName = fullName;
		this.bannerPhotoURL = bannerPhotoURL;
		this.photoURL = photoURL;
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

	@Column(name = "BANNER_PHOTO_URL")
	private String bannerPhotoURL;

	@Column(name = "PHOTO_URL")
	private String photoURL;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCATION_REF_GUID")
	private Location nativeLocation;

	@Column(name = "SUPPORTING_COUNT")
	private Long supportingCount;

	@Column(name = "FOLLOWING_COUNT")
	private Long followingCount;

	@Column(name = "SHARE_COUNT")
	private Long shareCount;
	
	@Column(name = "CURRENT_DESIGNATION")
	private String currentDesignation;
	
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

	@OneToMany(mappedBy = "politician", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PoliticianImage> politicianImages = new ArrayList<PoliticianImage>(0);

	@OneToMany(mappedBy = "politician", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PoliticianAuthority> politicianAuthorities = new ArrayList<PoliticianAuthority>(0);

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

	public Location getNativeLocation() {
		return nativeLocation;
	}

	public void setNativeLocation(Location nativeLocation) {
		this.nativeLocation = nativeLocation;
	}
	
	public List<PoliticianAuthority> getPoliticianAuthorities() {
		return politicianAuthorities;
	}

	public void setPoliticianAuthorities(List<PoliticianAuthority> politicianAuthorities) {
			this.politicianAuthorities.addAll(politicianAuthorities);
	}

	public String getCurrentDesignation() {
		return currentDesignation;
	}

	public void setCurrentDesignation(String currentDesignation) {
		this.currentDesignation = currentDesignation;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
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
		Politician other = (Politician) obj;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equalsIgnoreCase(other.fullName))
			return false;
		return true;
	}

	
	
}
