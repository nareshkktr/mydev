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
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.PreConditionFailedException;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CommentRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.EventRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.SaveOrUpdateDeleteObjectResponse;
import com.kasisripriyawebapps.myindia.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(value = EndPointConstants.COMMENT_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.COMMENT_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.COMMENT_ENDPOINT_API_TAGS }, description = EndPointConstants.COMMENT_ENDPOINT_API_DESCRIPTION)
public class CommentEndPoint {

	/** The Comment service. */
	@Autowired
	CommentService commentService;
	
	@POST
	@ApiOperation(value = EndPointConstants.POST_COMMENT_API_VALUE, nickname = EndPointConstants.POST_COMMENT_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.POST_COMMENT_API_DESCRIPTION)
	@Path(EndPointConstants.POST_COMMENT_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postComment(CommentRequest commentRequest) throws InternalServerException, PreConditionFailedException, PreConditionRequiredException {
		
		Long commentGuid = null;
		if (validateCreateUpdateCommentRequest(commentRequest)) {
			commentGuid = commentService.postComment(commentRequest);
		}
		SaveOrUpdateDeleteObjectResponse comemntObjResponse = new SaveOrUpdateDeleteObjectResponse(commentGuid);
		return Response.status(Status.OK).entity(comemntObjResponse).build();
	}
	
	private boolean validateCreateUpdateCommentRequest(CommentRequest commentRequest)
			throws PreConditionFailedException, PreConditionRequiredException {
		if (commentRequest == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		} else if (commentRequest.getObjectGuid() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.COMMENT_OBJECT_GUID_REQUIRED);
		} else if (commentRequest.getObjectType() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.COMMENT_OBJECT_TYPE_REQUIRED);
		} else if (commentRequest.getCommentorObjectGuid() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.COMMENTOR_OBJECT_GUID_REQUIRED);
		} else if (commentRequest.getCommentorObjectType() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.COMMENTOR_OBJECT_TYPE_REQUIRED);
		} else if (commentRequest.getCommentType() == null) {
			throw new PreConditionRequiredException(ExceptionConstants.COMMENT_TYPE_REQUIRED);
		} else if (commentRequest.getCommentType().equalsIgnoreCase(ApplicationConstants.COMMENT_TEXT) && commentRequest.getCommentText()  == null) {
			throw new PreConditionRequiredException(ExceptionConstants.COMMENT_TEXT_REQUIRED);
		} else if (commentRequest.getCommentType().equalsIgnoreCase(ApplicationConstants.COMMENT_TEXT) && commentRequest.getCommentText().isEmpty()) {
			throw new PreConditionRequiredException(ExceptionConstants.COMMENT_TEXT_SHOULD_NOT_BE_EMPTY);
		} 
		
		//Add validations for other comment types.
		return true;
	}

}
