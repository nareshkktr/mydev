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

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ActivityResponse;
import com.kasisripriyawebapps.myindia.service.ActivityService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// TODO: Auto-generated Javadoc
/**
 * The Class ActivityEndPoint.
 */

@Path(value = EndPointConstants.ACTIVITY_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.ACTIVITY_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.ACTIVITY_ENDPOINT_API_TAGS }, description = EndPointConstants.ACTIVITY_ENDPOINT_API_DESCRIPTION)
public class ActivityEndPoint {

	/** The activity service. */
	@Autowired
	ActivityService activityService;

	@GET
	@ApiOperation(value = EndPointConstants.GET_ALL_ACTIVITIES_API_VALUE, nickname = EndPointConstants.GET_ALL_ACTIVITIES_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_ALL_ACTIVITIES_API_DESCRIPTION)
	@Path(EndPointConstants.GET_ALL_ACTIVITIES_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllActivites() throws InternalServerException {
		return Response.status(Status.OK).entity(null).build();
	}
	
	@GET
	@ApiOperation(value = EndPointConstants.GET_ACTIVITIES_API_VALUE, nickname = EndPointConstants.GET_ACTIVITIES_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_ACTIVITIES_API_DESCRIPTION)
	@Path(EndPointConstants.GET_ACTIVITIES_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getActivities(@QueryParam("pageNo") Integer pageNo,@QueryParam("pageLimit") Integer pageLimit) throws InternalServerException, RecordNotFoundException {
		
		//Validate input
		if(pageNo == null){
			pageNo=ApplicationConstants.PAGE_START;
		}
		if(pageLimit == null){
			pageLimit = ApplicationConstants.PAGE_LIMIT;
		}
		List<ActivityResponse> activities = activityService.getActivities(pageNo,pageLimit);
		
		return Response.status(Status.OK).entity(activities).build();
	}
	
	@GET
	@ApiOperation(value = EndPointConstants.GET_ACTIVITIES_BY_OBJECT_API_VALUE, nickname = EndPointConstants.GET_ACTIVITIES_BY_OBJECT_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_ACTIVITIES_BY_OBJECT_API_DESCRIPTION)
	@Path(EndPointConstants.GET_ACTIVITIES_BY_OBJECT_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getActivitiesByObject(@QueryParam("objectGuid") Long objectGuid,@QueryParam("pageNo") Integer pageNo,@QueryParam("pageLimit") Integer pageLimit) throws InternalServerException, RecordNotFoundException {
		
		//Validate input
		if(pageNo == null){
			pageNo=ApplicationConstants.PAGE_START;
		}
		if(pageLimit == null){
			pageLimit = ApplicationConstants.PAGE_LIMIT;
		}
		List<ActivityResponse> activities = activityService.getActivitiesByObjectGuid(objectGuid,pageNo,pageLimit);
		
		return Response.status(Status.OK).entity(activities).build();
	}
}
