package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.Arrays;
import java.util.LinkedHashMap;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.service.OAuthService;

@Service
public class OAuthServiceImpl implements OAuthService {

	@Autowired
	private Environment env;

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	private HttpHeaders getHeadersWithClientCredentials() {
		String plainClientCredentials = env.getProperty("oauth.client_id") + ":"
				+ env.getProperty("oauth.client_secret");
		String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));
		HttpHeaders headers = getHeaders();
		headers.add("Authorization", "Basic " + base64ClientCredentials);
		return headers;
	}

	@Override
	@SuppressWarnings({ "unchecked" })
	public JSONObject getAuthTokenInfo(String userName, String password) throws InternalServerException {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeadersWithClientCredentials());
		String grantTypeURL = String.format(env.getProperty("oauth.grant_type_url"), userName, password);
		ResponseEntity<Object> response = restTemplate.exchange(
				env.getProperty("oauth.authorization_url") + grantTypeURL, HttpMethod.POST, request, Object.class);
		LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) response.getBody();
		JSONObject tokenInfo = null;
		if (map != null) {
			tokenInfo = new JSONObject();
			try {
				tokenInfo.put("access_token", (String) map.get("access_token"));
				tokenInfo.put("token_type", (String) map.get("token_type"));
				tokenInfo.put("refresh_token", (String) map.get("refresh_token"));
				tokenInfo.put("expires_in", (int) map.get("expires_in"));
				tokenInfo.put("scope", (String) map.get("scope"));
			} catch (JSONException e) {
				throw new InternalServerException(e.getMessage());
			}
		}
		return tokenInfo;
	}

	@Override
	public JSONObject getAccessTokenByRefreshToken(String refreshToken) throws InternalServerException {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(getHeadersWithClientCredentials());
		String grantTypeURL = String.format(env.getProperty("oauth.grant_type_refresh_url"),refreshToken);
		ResponseEntity<Object> response = restTemplate.exchange(
				env.getProperty("oauth.authorization_url") + grantTypeURL, HttpMethod.POST, request, Object.class);
		LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) response.getBody();
		JSONObject tokenInfo = null;
		if (map != null) {
			tokenInfo = new JSONObject();
			try {
				tokenInfo.put("accessToken", (String) map.get("access_token"));
				tokenInfo.put("refreshToken", (String) map.get("refresh_token"));
				tokenInfo.put("expirationTimeInSeconds", (Integer) map.get("expires_in"));
			} catch (JSONException e) {
				throw new InternalServerException(e.getMessage());
			}
		}
		return tokenInfo;
	}
}
