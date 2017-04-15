/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ThumbsUpDownRequest;

/**
 * The Interface ThumbsUpDownService.
 */
public interface ThumbsUpDownService {
	Long createThumbsUpDown(ThumbsUpDownRequest request,LoggedInUserDetails loggedInUserDetails)throws InternalServerException;

}
