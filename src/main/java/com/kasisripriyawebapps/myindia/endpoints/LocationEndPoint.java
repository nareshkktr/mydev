/*
 * 
 */
package com.kasisripriyawebapps.myindia.endpoints;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.service.LocationService;
import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
	
	@GET
	@ApiOperation(value = EndPointConstants.GET__SEARCH_RESULTS_BY_LOCATION_NAME_API_VALUE, nickname = EndPointConstants.GET__SEARCH_RESULTS_BY_LOCATION_NAME_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET__SEARCH_RESULTS_BY_LOCATION_NAME_API_DESCRIPTION)
	@Path(EndPointConstants.GET__SEARCH_RESULTS_BY_LOCATION_NAME_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSearchResultsByLocationName(@QueryParam("searchTerm") String searchTerm)
			throws InternalServerException {
		List<SolrLocationMaster> searchResults = locationService.getSearchResultsByLocationName(searchTerm);
		return Response.status(Status.OK).entity(searchResults).build();
	}

}
