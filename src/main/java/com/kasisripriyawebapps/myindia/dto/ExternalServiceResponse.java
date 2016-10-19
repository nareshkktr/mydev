/*
 * 
 */
package com.kasisripriyawebapps.myindia.dto;

import java.util.List;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class ExternalServiceResponse.
 */
public class ExternalServiceResponse {

	/** The status code. */
	private int statusCode;
	
	/** The error message. */
	private String errorMessage;
	
	/** The response. */
	private String response;
	
	/** The response headers. */
	private Map<String, List<String>> responseHeaders;

	/**
	 * Instantiates a new external service response.
	 */
	public ExternalServiceResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new external service response.
	 *
	 * @param statusCode
	 *            the status code
	 * @param errorMessage
	 *            the error message
	 * @param response
	 *            the response
	 * @param responseHeaders
	 *            the response headers
	 */
	public ExternalServiceResponse(int statusCode, String errorMessage, String response,
			Map<String, List<String>> responseHeaders) {
		super();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
		this.response = response;
		this.responseHeaders = responseHeaders;
	}

	/**
	 * Gets the status code.
	 *
	 * @return the status code
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets the status code.
	 *
	 * @param statusCode
	 *            the new status code
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message.
	 *
	 * @param errorMessage
	 *            the new error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the response.
	 *
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * Sets the response.
	 *
	 * @param response
	 *            the new response
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	/**
	 * Gets the response headers.
	 *
	 * @return the response headers
	 */
	public Map<String, List<String>> getResponseHeaders() {
		return responseHeaders;
	}

	/**
	 * Sets the response headers.
	 *
	 * @param responseHeaders
	 *            the response headers
	 */
	public void setResponseHeaders(Map<String, List<String>> responseHeaders) {
		this.responseHeaders = responseHeaders;
	}

}
