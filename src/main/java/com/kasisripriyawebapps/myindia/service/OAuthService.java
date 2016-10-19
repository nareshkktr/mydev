package com.kasisripriyawebapps.myindia.service;

import org.codehaus.jettison.json.JSONObject;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface OAuthService {

	JSONObject getAuthTokenInfo(String loginUserName, String password) throws InternalServerException;

}
