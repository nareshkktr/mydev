package com.kasisripriyawebapps.myindia.entity;

import java.sql.Timestamp;
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

@Entity
@Table(name = "PROBLEM_ALBUM")
public class ProblemAlbum {

	@Id
	@Column(name = "PROBLEM_ALBUM_GUID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guid;

	@Column(name = "IMAGE_URL")
	private String imageURL;

	@Column(name = "ALBUM_NAME")
	private String albumName;

	@Column(name = "CREATED_TIMESTAMP")
	private Timestamp createdTimeStamp;

	@Column(name = "CREATED_BY")
	private Long createdBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROBLEM_GUID")
	private Problem problem;

	@OneToMany(mappedBy = "problemAlbum", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProblemImage> problemAlbumImages = new ArrayList<ProblemImage>(0);

	@Column(name = "IMAGES_COUNT")
	private Integer imagesCount = 0;

	/** The following count. */
	@Column(name = "THUMBS_UP_COUNT")
	private Integer thumbsUpCount = 0;

	/** The share count. */
	@Column(name = "THUMBS_DOWN_COUNT")
	private Integer thumbsDownCount = 0;

	/** The Support count. */
	@Column(name = "COMMENTS_COUNT")
	private Integer commentsCount = 0;

	/** The view count. */
	@Column(name = "SHARE_COUNT")
	private Integer shareCount = 0;

	/** The popularity count. */
	@Column(name = "REPORT_ABUSE_COUNT")
	private Integer reportAbuseCount = 0;

	@Column(name = "MODIFIED_TIMESTAMP")
	private Timestamp updatedTimeStamp;

	@Column(name = "MODIFIED_BY")
	private Long updatedBy;

	public Long getGuid() {
		return guid;
	}

	public void setGuid(Long guid) {
		this.guid = guid;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public Timestamp getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	public List<ProblemImage> getProblemAlbumImages() {
		return problemAlbumImages;
	}

	public void setProblemAlbumImages(List<ProblemImage> problemAlbumImages) {
		this.problemAlbumImages = problemAlbumImages;
	}

	public Integer getImagesCount() {
		return imagesCount;
	}

	public void setImagesCount(Integer imagesCount) {
		this.imagesCount = imagesCount;
	}

	public Integer getThumbsUpCount() {
		return thumbsUpCount;
	}

	public void setThumbsUpCount(Integer thumbsUpCount) {
		this.thumbsUpCount = thumbsUpCount;
	}

	public Integer getThumbsDownCount() {
		return thumbsDownCount;
	}

	public void setThumbsDownCount(Integer thumbsDownCount) {
		this.thumbsDownCount = thumbsDownCount;
	}

	public Integer getCommentsCount() {
		return commentsCount;
	}

	public void setCommentsCount(Integer commentsCount) {
		this.commentsCount = commentsCount;
	}

	public Integer getShareCount() {
		return shareCount;
	}

	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}

	public Integer getReportAbuseCount() {
		return reportAbuseCount;
	}

	public void setReportAbuseCount(Integer reportAbuseCount) {
		this.reportAbuseCount = reportAbuseCount;
	}

	public Timestamp getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}

	public void setUpdatedTimeStamp(Timestamp updatedTimeStamp) {
		this.updatedTimeStamp = updatedTimeStamp;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

}
