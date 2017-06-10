/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import java.util.List;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.PartyResponse;

/**
 * The Interface PartyService.
 */
public interface PartyService {

	void importParties() throws InternalServerException;

	List<PartyResponse> getAllParties() throws InternalServerException, RecordNotFoundException;

}
