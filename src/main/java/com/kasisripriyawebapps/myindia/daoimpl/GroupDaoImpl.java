package com.kasisripriyawebapps.myindia.daoimpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.dao.GroupDao;
import com.kasisripriyawebapps.myindia.entity.Account;
import com.kasisripriyawebapps.myindia.entity.GroupMembers;
import com.kasisripriyawebapps.myindia.entity.Groups;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GroupMemberRequest;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Repository
public class GroupDaoImpl extends BaseDaoImpl<Long, Groups> implements GroupDao {

	@Override
	public Long createGroup(Groups group) throws InternalServerException {
		return save(group);
	}

	@Override
	public void updateGroup(Groups groups) throws InternalServerException {
		update(groups);
	}

	@Override
	public Groups getGroupById(Long eventGuid) throws InternalServerException, RecordNotFoundException {
		return getById(eventGuid);

	}

	@Override
	public void deleteGroupById(Groups groups) throws InternalServerException, RecordNotFoundException {
		delete(groups);
	}

	@Override
	public Long addGroupMember(GroupMemberRequest request, LoggedInUserDetails loggedInUserDetails) {
			Session session = getSession();
			GroupMembers members = new GroupMembers();
			Groups groups=new Groups();
			Account account=new Account();
			members.setCreatedBy(loggedInUserDetails.getGuid());
			account.setGuid(loggedInUserDetails.getGuid());
			groups.setGuid(request.getGroupGuid());
			members.setGroups(groups);
			members.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
			members.setAccount(account);
		return (Long) session.save(members);
	}

	@Override
	public void deleteGroupMemberById(Long groupMemberId) {
		Session session = getSession();
		final Query query = session.getNamedQuery("removeGroupMember");
		query.setParameter("groupMemberId", groupMemberId);
		query.executeUpdate();
	}

}
