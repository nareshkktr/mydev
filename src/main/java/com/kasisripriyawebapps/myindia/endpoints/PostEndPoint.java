/*
 * 
 */
package com.kasisripriyawebapps.myindia.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.service.PostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// TODO: Auto-generated Javadoc
/**
 * The Class PostEndPoint.
 */
@Path(value = EndPointConstants.POST_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.POST_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.POST_ENDPOINT_API_TAGS }, description = EndPointConstants.POST_ENDPOINT_API_DESCRIPTION)
public class PostEndPoint {

	/** The post service. */
	@Autowired
	PostService postService;

	@GET
	@ApiOperation(value = EndPointConstants.GET_ALL_POSTS_API_VALUE, nickname = EndPointConstants.GET_ALL_POSTS_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.GET_ALL_POSTS_API_DESCRIPTION)
	@Path(EndPointConstants.GET_ALL_POSTS_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPosts() throws InternalServerException {
		return Response.status(Status.OK).entity(null).build();
	}
}
