package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.dao.GroupDao;
import com.kasisripriyawebapps.myindia.entity.Account;
import com.kasisripriyawebapps.myindia.entity.GroupMembers;
import com.kasisripriyawebapps.myindia.entity.Groups;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GroupMemberRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GroupRequest;
import com.kasisripriyawebapps.myindia.service.GroupService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Service
public class GroupServiceImpl implements GroupService {
	@Autowired
	private GroupDao groupDao;

	@Override
	@Transactional
	public Long createGroup(GroupRequest request, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException {
		Groups groups = null;
		GroupMembers groupMembers = null;
		List<GroupMembers> groupMembersList = null;
		Account account = new Account();
		if (request != null && !request.equals("")) {
			groups = new Groups();

			groups.setGroupName(request.getGroupName());
			groups.setGroupImageURL(request.getGroupImageURL());
			groups.setCreatedBy(loggedInUserDetails.getGuid());
			groups.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			groups.setModifiedBy(loggedInUserDetails.getGuid());
			groups.setModifiedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			List<GroupMemberRequest> groupMemberRequestList = request.getGroupMemberRequest();
			groupMembersList = new ArrayList<GroupMembers>();

			for (GroupMemberRequest groupMemberRequest : groupMemberRequestList) {
				groupMembers = new GroupMembers();
				account.setGuid(loggedInUserDetails.getGuid());
				groupMembers.setAccount(account);
				groupMembers.setGroups(groups);
				groupMembers.setCreatedBy(groupMemberRequest.getCreatedBy());
				groupMembers.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
				groupMembers.setGroups(groups);
				groupMembersList.add(groupMembers);
			}
			groups.setGroupMembers(groupMembersList);

		}
		Long groupId = groupDao.createGroup(groups);
		return groupId;
	}

	@Override
	@Transactional
	public Long updateGroup(GroupRequest request, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException, RecordNotFoundException {
		Groups groups = new Groups();
		Long groupId = 0l;
		groups = getGroupById(request.getGuid());

		if (request != null && !request.equals("")) {

			groups.setGroupName(request.getGroupName());
			groups.setGroupImageURL(request.getGroupImageURL());
			groups.setCreatedBy(loggedInUserDetails.getGuid());
			groups.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			groups.setModifiedBy(loggedInUserDetails.getGuid());
			groups.setModifiedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
		}
		groupDao.updateGroup(groups);
		return groupId;
	}

	@Override
	@Transactional
	public Groups getGroupById(Long groupGuid) throws InternalServerException, RecordNotFoundException {
		Groups groups = null;
		groups = groupDao.getGroupById(groupGuid);
		if (groups == null) {
			throw new RecordNotFoundException(ExceptionConstants.GROUP_NOT_FOUND);
		}
		return groups;

	}

	@Override
	@Transactional
	public Long deleteGroupById(Long groupGuid) throws InternalServerException, RecordNotFoundException {
		Long deletedId = null;
		Groups groups = getGroupById(groupGuid);
		groupDao.deleteGroupById(groups);
	 return deletedId;

	}

	@Override
	@Transactional
	public Long addGroupMember(GroupMemberRequest reuest, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException {
		Long memberId=groupDao.addGroupMember(reuest,loggedInUserDetails);
		return memberId;
	}

	@Override
	@Transactional
	public Long deleteGroupMemberById(Long groupMemberId) throws InternalServerException, RecordNotFoundException {
		groupDao.deleteGroupMemberById(groupMemberId);
		return groupMemberId;
	}
}
