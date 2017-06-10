/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.UserLocationDetails;

public interface UserService {


	UserLocationDetails getLoggedInUserLocation(Long guid) throws RecordNotFoundException, InternalServerException;
}
