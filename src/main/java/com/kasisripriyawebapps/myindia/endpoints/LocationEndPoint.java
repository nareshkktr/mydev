/*
 * 
 */
package com.kasisripriyawebapps.myindia.endpoints;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.service.LocationService;

import io.swagger.annotations.Api;

// TODO: Auto-generated Javadoc
/**
 * The Class LocationEndPoint.
 */

@Path(value = EndPointConstants.LOCATION_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.LOCATION_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.LOCATION_ENDPOINT_API_TAGS }, description = EndPointConstants.LOCATION_ENDPOINT_API_DESCRIPTION)
public class LocationEndPoint extends BaseEndPoint {

	/** The location service. */
	@Autowired
	LocationService locationService;

}
