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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
			Location location, Long popularityCount, Long supportingCount, Long followingCount, Long shareCount) {
		super();
		this.guid = guid;
		this.fullName = fullName;
		this.designation = designation;
		this.bannerPhotoURL = bannerPhotoURL;
		this.photoURL = photoURL;
		this.location = location;
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
	@JsonBackReference
	private Location location;

	@Column(name = "POPULARITY_COUNT")
	private Long popularityCount;

	@Column(name = "SUPPORTING_COUNT")
	private Long supportingCount;

	@Column(name = "FOLLOWING_COUNT")
	private Long followingCount;

	@Column(name = "SHARE_COUNT")
	private Long shareCount;

	@OneToMany(mappedBy = "politician", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<PoliticianImage> politicianImages = new ArrayList<PoliticianImage>(0);

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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
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

}
