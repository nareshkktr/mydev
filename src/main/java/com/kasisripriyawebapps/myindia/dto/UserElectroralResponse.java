/*
 * 
 */
package com.kasisripriyawebapps.myindia.dto;

import java.io.Serializable;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class UserElectroralResponse.
 */
public class UserElectroralResponse implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9061086966534579546L;

	/** The num found. */
	private int numFound;
	
	/** The start. */
	private int start;
	
	/** The docs. */
	private List<UserElectroralData> docs;

	/**
	 * Gets the num found.
	 *
	 * @return the num found
	 */
	public int getNumFound() {
		return numFound;
	}

	/**
	 * Sets the num found.
	 *
	 * @param numFound
	 *            the new num found
	 */
	public void setNumFound(int numFound) {
		this.numFound = numFound;
	}

	/**
	 * Gets the start.
	 *
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * Sets the start.
	 *
	 * @param start
	 *            the new start
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * Gets the docs.
	 *
	 * @return the docs
	 */
	public List<UserElectroralData> getDocs() {
		return docs;
	}

	/**
	 * Sets the docs.
	 *
	 * @param docs
	 *            the new docs
	 */
	public void setDocs(List<UserElectroralData> docs) {
		this.docs = docs;
	}

}
