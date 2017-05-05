/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.PoliticianRequest;

/**
 * The Interface PoliticianService.
 */
public interface PoliticianService {

	void deactivatePoliticians(PoliticianRequest politicianRequest) throws InternalServerException;

}
