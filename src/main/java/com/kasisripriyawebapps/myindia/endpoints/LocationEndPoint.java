/*
 * 
 */
package com.kasisripriyawebapps.myindia.endpoints;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.service.LocationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// TODO: Auto-generated Javadoc
/**
 * The Class LocationEndPoint.
 */

@Path(value = EndPointConstants.LOCATION_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.LOCATION_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.LOCATION_ENDPOINT_API_TAGS }, description = EndPointConstants.LOCATION_ENDPOINT_API_DESCRIPTION)
public class LocationEndPoint {

	/** The location service. */
	@Autowired
	LocationService locationService;

	@POST
	@ApiOperation(value = EndPointConstants.UPLOAD_ALL_LOCATIONS_API_VALUE, nickname = EndPointConstants.UPLOAD_ALL_USERS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.UPLOAD_ALL_LOCATIONS_API_DESCRIPTION)
	@Path(EndPointConstants.UPLOAD_ALL_LOCATIONS_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response uploadLocations() throws InternalServerException {
		locationService.uploadLocations();
		return Response.status(Status.OK).entity(ApplicationConstants.SUCCESS_MESSAGE).build();
	}

}
