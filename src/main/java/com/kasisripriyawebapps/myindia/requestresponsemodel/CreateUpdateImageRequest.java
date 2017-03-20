package com.kasisripriyawebapps.myindia.requestresponsemodel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CreateUpdateImageRequest", description = "To Add/Update Image For An User,Politician,Party,Location,Problem,Event")
public class CreateUpdateImageRequest {

	@ApiModelProperty(value = "imageName", required = true)
	private String imageName;
	@ApiModelProperty(value = "imageData", required = true)
	private String imageData;
	@ApiModelProperty(value = "objectType", required = true)
	private String objectType;
	@ApiModelProperty(value = "objectId", required = true)
	private Long objectId;

	@ApiModelProperty(value = "category", required = true)
	private String category;

	@ApiModelProperty(value = "mainPhotoURL", required = true)
	private Boolean isMainPhotoURL;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getIsMainPhotoURL() {
		return isMainPhotoURL;
	}

	public void setIsMainPhotoURL(Boolean isMainPhotoURL) {
		this.isMainPhotoURL = isMainPhotoURL;
	}

}
