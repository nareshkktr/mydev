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
	private String objectId;

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

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

}
