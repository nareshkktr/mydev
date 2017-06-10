package com.kasisripriyawebapps.myindia.requestresponsemodel;

public class AddPhotoRequest {

	private String imageName;
	private String imageData;
	private String objectType;
	private Long objectGuId;

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

	public Long getObjectGuId() {
		return objectGuId;
	}

	public void setObjectGuId(Long objectGuId) {
		this.objectGuId = objectGuId;
	}

}
