/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import java.util.Map;

import com.kasisripriyawebapps.myindia.dto.ExternalServiceResponse;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExternalService.
 */
public interface ExternalService {

	/**
	 * Invoke external service.
	 *
	 * @param serviceParams
	 *            the service params
	 * @return the external service response
	 * @throws CommonException
	 *             the common exception
	 */
	ExternalServiceResponse invokeExternalService(Map<String, Object> serviceParams) throws InternalServerException;
}
