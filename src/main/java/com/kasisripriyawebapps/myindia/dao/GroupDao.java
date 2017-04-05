package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.entity.Groups;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GroupMemberRequest;

public interface GroupDao {
	Long createGroup(Groups groups) throws InternalServerException;
	void updateGroup(Groups groups) throws InternalServerException;
	Groups getGroupById(Long eventGuid) throws InternalServerException, RecordNotFoundException;
	void deleteGroupById(Groups groups)  throws InternalServerException, RecordNotFoundException;
	Long addGroupMember(GroupMemberRequest request,LoggedInUserDetails loggedInUserDetails);
	void deleteGroupMemberById(Long groupMemberId) throws InternalServerException, RecordNotFoundException;
	List<Long> getGruopById(Long eventRecipientId) throws InternalServerException, RecordNotFoundException;
	
	

}
