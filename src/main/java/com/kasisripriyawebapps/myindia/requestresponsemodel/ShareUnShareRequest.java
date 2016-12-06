package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.io.Serializable;

public class ShareUnShareRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1891856605609525811L;

	private String shareObjectType;
	private Long shareObjectGuid;
	private String shareTo;
	private String sharingObjectType;
	private Long sharingObjectGuid;

	public String getShareObjectType() {
		return shareObjectType;
	}

	public void setShareObjectType(String shareObjectType) {
		this.shareObjectType = shareObjectType;
	}

	public Long getShareObjectGuid() {
		return shareObjectGuid;
	}

	public void setShareObjectGuid(Long shareObjectGuid) {
		this.shareObjectGuid = shareObjectGuid;
	}

	public String getShareTo() {
		return shareTo;
	}

	public void setShareTo(String shareTo) {
		this.shareTo = shareTo;
	}

	public String getSharingObjectType() {
		return sharingObjectType;
	}

	public void setSharingObjectType(String sharingObjectType) {
		this.sharingObjectType = sharingObjectType;
	}

	public Long getSharingObjectGuid() {
		return sharingObjectGuid;
	}

	public void setSharingObjectGuid(Long sharingObjectGuid) {
		this.sharingObjectGuid = sharingObjectGuid;
	}

}
