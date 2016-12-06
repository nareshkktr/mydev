/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ShareUnShareRequest;

/**
 * The Interface ShareService.
 */
public interface ShareService {

	Integer shareObject(ShareUnShareRequest shareUnShareRequest) throws InternalServerException;

}
