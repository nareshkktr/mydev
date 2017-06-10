package com.kasisripriyawebapps.myindia.requestresponsemodel;

public class AddPhotoToAlbumRequest {

	private String imageName;
	private String imageData;
	private String objectType;
	private Long objectGuId;
	private Long albumGuid;
	private String albumName;
	private String albumDescription;

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

	public Long getAlbumGuid() {
		return albumGuid;
	}

	public void setAlbumGuid(Long albumGuid) {
		this.albumGuid = albumGuid;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumDescription() {
		return albumDescription;
	}

	public void setAlbumDescription(String albumDescription) {
		this.albumDescription = albumDescription;
	}

}
