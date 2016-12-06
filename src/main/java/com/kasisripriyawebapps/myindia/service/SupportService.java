package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.SupportUnSupportRequest;

public interface SupportService {

	Integer supportObject(SupportUnSupportRequest supportUnSupportRequest) throws InternalServerException;

	Integer unSupportObject(SupportUnSupportRequest supportUnSupportRequest) throws InternalServerException;

}
