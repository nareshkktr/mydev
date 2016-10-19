/*
 * 
 */
package com.kasisripriyawebapps.myindia.requestresponsemodel;

/**
 * The Class SaveOrUpdateObjectResponse.
 */
public class SaveOrUpdateDeleteObjectResponse {

	/** The save update delete record id. */
	private Long saveUpdateDeleteRecordId;

	/**
	 * Instantiates a new save or update object response.
	 *
	 * @param saveUpdateDeleteRecordId
	 *            the save update delete record id
	 */
	public SaveOrUpdateDeleteObjectResponse(Long saveUpdateDeleteRecordId) {
		this.saveUpdateDeleteRecordId = saveUpdateDeleteRecordId;
	}

	/**
	 * Gets the saved record id.
	 *
	 * @return the saved record id
	 */
	public Long getSaveUpdateDeleteRecordId() {
		return saveUpdateDeleteRecordId;
	}

	/**
	 * Sets the saved record id.
	 *
	 * @param saveUpdateDeleteRecordId
	 *            the new saved record id
	 */
	public void setSaveUpdateDeleteRecordId(Long saveUpdateDeleteRecordId) {
		this.saveUpdateDeleteRecordId = saveUpdateDeleteRecordId;
	}

}
