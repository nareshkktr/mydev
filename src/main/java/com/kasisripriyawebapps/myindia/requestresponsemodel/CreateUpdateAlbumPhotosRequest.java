package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.util.List;

public class CreateUpdateAlbumPhotosRequest {

	private Long albumGuid;
	private String albumName;
	private CreateUpdateImageRequest albumImageData;
	private List<CreateUpdateImageRequest> albumPhotosData;

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

	public CreateUpdateImageRequest getAlbumImageData() {
		return albumImageData;
	}

	public void setAlbumImageData(CreateUpdateImageRequest albumImageData) {
		this.albumImageData = albumImageData;
	}

	public List<CreateUpdateImageRequest> getAlbumPhotosData() {
		return albumPhotosData;
	}

	public void setAlbumPhotosData(List<CreateUpdateImageRequest> albumPhotosData) {
		this.albumPhotosData = albumPhotosData;
	}

}
