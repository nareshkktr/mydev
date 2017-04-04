package com.kasisripriyawebapps.myindia.endpoints;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.constants.EndPointConstants;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.exception.ConflictException;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.PreConditionFailedException;
import com.kasisripriyawebapps.myindia.exception.PreConditionRequiredException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GroupMemberRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GroupRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.SaveOrUpdateDeleteObjectResponse;
import com.kasisripriyawebapps.myindia.service.GroupService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path(value = EndPointConstants.GROUP_ENDPOINT_REQUEST_MAPPING)
@Api(value = EndPointConstants.GROUP_ENDPOINT_API_VALUE, tags = {
		EndPointConstants.GROUP_ENDPOINT_API_TAGS }, description = EndPointConstants.GROUP_ENDPOINT_API_DESCRIPTION)
public class GroupEndPoint extends BaseEndPoint {

	@Autowired
	private GroupService groupService;

	@POST
	@ApiOperation(value = EndPointConstants.CREATE_GROUP_API_VALUE, nickname = EndPointConstants.CREATE_GROUP_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.CREATE_GROUP_API_DESCRIPTION)
	@Path(EndPointConstants.CREATE_GROUP_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createGroup(final GroupRequest groupRequest) throws InternalServerException,
			PreConditionFailedException, PreConditionRequiredException, ConflictException {
		Long resposeId=null;
		LoggedInUserDetails loggedInUserDetails = getLoggedInUserDetails();
		if(validateCreateUpdateGroupRequest(groupRequest)){
		resposeId = groupService.createGroup(groupRequest, loggedInUserDetails);
		}
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(resposeId);
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}

	@PUT
	@ApiOperation(value = EndPointConstants.UPDATE_GROUP_API_VALUE, nickname = EndPointConstants.UPDATE_GROUP_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.CREATE_GROUP_API_DESCRIPTION)
	@Path(EndPointConstants.UPDATE_GROUP_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateGroup(final GroupRequest groupRequest) throws InternalServerException,
			PreConditionFailedException, PreConditionRequiredException, ConflictException, RecordNotFoundException {
		LoggedInUserDetails loggedInUserDetails = getLoggedInUserDetails();
		Long resposeId=null;
		if(validateCreateUpdateGroupRequest(groupRequest)){
		 resposeId = groupService.updateGroup(groupRequest, loggedInUserDetails);
		}
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(resposeId);
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}

	@DELETE
	@ApiOperation(value = EndPointConstants.DELETE_GROUP_API_VALUE, nickname = EndPointConstants.DELETE_GROUP_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.DELETE_GROUP_API_DESCRIPTION)
	@Path(EndPointConstants.DELETE_GROUP_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteGroupById(@PathParam(value = "groupGuid") Long groupGuid)
			throws InternalServerException, RecordNotFoundException, PreConditionFailedException {
		Long resposeId = null;
		if(validateUpdateDeleteGroupRequest(resposeId)){
			resposeId = groupService.deleteGroupById(groupGuid);
		}
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(resposeId);
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}
	@POST
	@ApiOperation(value = EndPointConstants.ADD_GROUP_MEMBER_API_VALUE, nickname = EndPointConstants.ADD_GROUP_MEMBER_API_NICKNAME, httpMethod = EndPointConstants.HTTP_POST, notes = EndPointConstants.ADD_GROUP_MEMBER_API_DESCRIPTION)
	@Path(EndPointConstants.ADD_GROUP_MEMBER_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addGroupMember(final GroupMemberRequest request) throws InternalServerException,
			PreConditionFailedException, PreConditionRequiredException, ConflictException {
		LoggedInUserDetails loggedInUserDetails = getLoggedInUserDetails();
		Long resposeId=null;
		if(validateCreateUpdateGroupRequest(request)){
		 resposeId = groupService.addGroupMember(request, loggedInUserDetails);
		}
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(resposeId);
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}
	@DELETE
	@ApiOperation(value = EndPointConstants.DELETE_GROUP_MEMBER_API_VALUE, nickname = EndPointConstants.DELETE_GROUP_MEMBER_API_NICKNAME, httpMethod = EndPointConstants.HTTP_GET, notes = EndPointConstants.DELETE_GROUP_MEMBER_API_DESCRIPTION)
	@Path(EndPointConstants.DELETE_GROUP_MEMBER_REQUEST_MAPPING)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteGroupMemberById(@PathParam(value = "groupGuid") Long groupGuid)
			throws InternalServerException, RecordNotFoundException, PreConditionFailedException {
		Long resposeId = null;
		if(validateUpdateDeleteGroupRequest(resposeId)){
			resposeId = groupService.deleteGroupMemberById(groupGuid);
		}
		SaveOrUpdateDeleteObjectResponse saveObjResponse = new SaveOrUpdateDeleteObjectResponse(resposeId);
		return Response.status(Status.OK).entity(saveObjResponse).build();
	}
	
	private boolean validateCreateUpdateGroupRequest(GroupRequest groupRequest)	throws PreConditionFailedException, PreConditionRequiredException {
		if (groupRequest == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		} 
		return true;
	}
	private boolean validateCreateUpdateGroupRequest(GroupMemberRequest groupRequest)	throws PreConditionFailedException, PreConditionRequiredException {
		if (groupRequest == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		} 
		return true;
	}
	
	private boolean validateUpdateDeleteGroupRequest(Long groupId) throws PreConditionFailedException {
		if (groupId == null) {
			throw new PreConditionFailedException(ExceptionConstants.REQUEST_NOT_NULL);
		}
		return true;
	}
}
