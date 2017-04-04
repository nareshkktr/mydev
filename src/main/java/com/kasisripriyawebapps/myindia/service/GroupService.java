package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.entity.Groups;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GroupMemberRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GroupRequest;

public interface GroupService {
	Long createGroup(GroupRequest reuest,LoggedInUserDetails loggedInUserDetails) throws InternalServerException;
	Long updateGroup(GroupRequest reuest,LoggedInUserDetails loggedInUserDetails) throws InternalServerException, RecordNotFoundException;
	Groups getGroupById(Long eventGuid) throws InternalServerException, RecordNotFoundException;
	Long deleteGroupById(Long eventGuid) throws InternalServerException,RecordNotFoundException;
	Long addGroupMember(GroupMemberRequest reuest,LoggedInUserDetails loggedInUserDetails) throws InternalServerException;
	Long deleteGroupMemberById(Long eventGuid) throws InternalServerException,RecordNotFoundException;
}
