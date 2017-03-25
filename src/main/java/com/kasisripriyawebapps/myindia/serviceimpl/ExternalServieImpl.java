/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.constants.ServiceConstants;
import com.kasisripriyawebapps.myindia.dto.ExternalServiceResponse;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.service.ExternalService;

// TODO: Auto-generated Javadoc
/**
 * The Class ExternalServieImpl.
 */
@Service
public class ExternalServieImpl implements ExternalService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kasisripriyawebapps.myindia.service.ExternalService#
	 * invokeExternalService(java.util.Map)
	 */
	@Override
	public ExternalServiceResponse invokeExternalService(Map<String, Object> serviceParams)
			throws InternalServerException {

		int statusCode = 0;
		String line = null;
		String message = "";
		String response = "";
		String serviceUrl = (String) serviceParams.get(ServiceConstants.SERVICE_URL);
		String baseURL = (String) serviceParams.get(ServiceConstants.BASE_URL);
		String requestType = (String) serviceParams.get(ServiceConstants.REQUEST_TYPE);
		@SuppressWarnings("unchecked")
		Map<String, Object> queryParams = (HashMap<String, Object>) serviceParams
				.get(ServiceConstants.REQUEST_PARAMS_INFO);
		String contentType = (String) serviceParams.get(ServiceConstants.CONTENT_TYPE);
		String cookies = (String) serviceParams.get(ServiceConstants.COOKIES);

		StringBuilder urlParameters = new StringBuilder();
		boolean first = true;
		if (queryParams != null) {
			for (Entry<String, Object> pair : queryParams.entrySet()) {
				if (first) {
					first = false;
				} else {
					urlParameters.append("&");
				}
				try {
					urlParameters.append(URLEncoder.encode(pair.getKey(), "UTF-8"));
					urlParameters.append("=");
					urlParameters.append(URLEncoder.encode("" + pair.getValue(), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					new InternalServerException(e.getMessage());
				}

			}
		}
		String requestURL = ServiceConstants.SCHEME_HTTP + "://" + baseURL + serviceUrl;
		if (requestType.equalsIgnoreCase("GET")) {
			if (urlParameters != null && urlParameters.length() > 0) {
				requestURL += "?" + urlParameters.toString();
			}
		} else {
			StringBuffer sb = new StringBuffer();
			if (queryParams != null) {
				for (String param : queryParams.keySet()) {
					sb.append(queryParams.get(param));
					sb.append("/");
				}
			}
			requestURL += "/" + sb.toString();
		}
		URL url = null;
		try {
			url = new URL(requestURL);
		} catch (MalformedURLException e) {
			new InternalServerException(e.getMessage());
		}
		HttpURLConnection connection = null;
		try {
			connection = getConnectionObject(requestType, url, contentType, cookies);
			statusCode = connection.getResponseCode();
			message = connection.getResponseMessage();
			InputStream content = connection.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(content));
			while ((line = in.readLine()) != null) {
				response = line;
			}
		} catch (IOException e) {
			new InternalServerException(e.getMessage());
		}
		return new ExternalServiceResponse(statusCode, message, response, connection.getHeaderFields());

	}

	/**
	 * Gets the connection object.
	 *
	 * @param requestType
	 *            the request type
	 * @param url
	 *            the url
	 * @param contentType
	 *            the content type
	 * @param cookies
	 *            the cookies
	 * @return the connection object
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ProtocolException
	 *             the protocol exception
	 */
	private HttpURLConnection getConnectionObject(String requestType, URL url, String contentType, String cookies)
			throws IOException, ProtocolException {
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setConnectTimeout(50000);
		if (contentType != null && !contentType.isEmpty()) {
			connection.setRequestProperty("Content-Type", contentType);
		}
		if (cookies != null && !cookies.isEmpty()) {
			connection.setRequestProperty("Cookie", cookies);
		}
		connection.setDoOutput(true);
		connection.setRequestMethod(requestType);
		return connection;
	}

}
