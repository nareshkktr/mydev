package com.kasisripriyawebapps.myindia.requestresponsemodel;

import java.io.Serializable;

public class ActionCountResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1107540467314753228L;
	private Integer count;

	public ActionCountResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActionCountResponse(Integer count) {
		super();
		this.count = count;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
