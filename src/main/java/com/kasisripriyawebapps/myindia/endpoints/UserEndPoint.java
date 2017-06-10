/*
 * 
 */
package com.kasisripriyawebapps.myindia.endpoints;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.UserLocationDetails;
import com.kasisripriyawebapps.myindia.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(value = EndPointConstants.USER_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.USER_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.USER_ENDPOINT_API_TAGS }, description = EndPointConstants.USER_ENDPOINT_API_DESCRIPTION)
public class UserEndPoint extends BaseEndPoint {

	@Autowired
	UserService userService;

	private @Autowired HttpServletRequest servletRequest;

	@GET
	@ApiOperation(value = EndPointConstants.GET_LOGGED_IN_USER_LOCATION_DETAILS_API_VALUE, nickname = EndPointConstants.GET_LOGGED_IN_USER_LOCATION_DETAILS_DETAILS_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_LOGGED_IN_USER_LOCATION_DETAILS_DETAILS_API_DESCRIPTION)
	@Path(EndPointConstants.GET_LOGGED_IN_USER_LOCATION_DETAILS_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLoggedInUserLocation() throws InternalServerException, RecordNotFoundException {
		LoggedInUserDetails loggedInUserDetails = getLoggedInUserDetails();
		UserLocationDetails userLocationDetails = userService.getLoggedInUserLocation(loggedInUserDetails.getGuid());
		HttpSession session = servletRequest.getSession(true);
		session.setAttribute("userLocationDetails", userLocationDetails);
		return Response.status(Status.OK).entity(userLocationDetails).build();
	}

}
