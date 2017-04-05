/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.dao.EventDao;
import com.kasisripriyawebapps.myindia.entity.Account;
import com.kasisripriyawebapps.myindia.entity.Event;
import com.kasisripriyawebapps.myindia.entity.EventRecipients;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.EventRecipientRequest;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

/**
 * The Class EventDaoImpl.
 */
@Repository
public class EventDaoImpl extends BaseDaoImpl<Long, Event> implements EventDao {
	@Override
	public Long createEvent(Event event) throws InternalServerException {
		return save(event);
	}

	@Override
	public Long updateEvent(Event event) throws InternalServerException {
		return save(event);
	}

	@Override
	public Event getEventById(Long eventGuid)
			throws InternalServerException, RecordNotFoundException {
		return getById(eventGuid);
	}

	@Override
	public void deleteEventById(Event event)
			throws InternalServerException, RecordNotFoundException {
		delete(event);
	}

	@Override
	public Long addEventRecipient(EventRecipientRequest eventRecipientRequest,LoggedInUserDetails loggedInUserDetails) throws InternalServerException {
		Session session = getSession();
		EventRecipients eventRecipients=new EventRecipients();
		Account account=new Account();
		Event event=new Event();
		account.setGuid(eventRecipientRequest.getAccountId());
		eventRecipients.setAccount(account);
		event.setGuid(eventRecipientRequest.getEventId());
		eventRecipients.setEvent(event);
		eventRecipients.setRecipientType(eventRecipientRequest.getRecipientType());
		eventRecipients.setCreatedBy(loggedInUserDetails.getGuid());
		eventRecipients.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
	 return (Long) session.save(eventRecipients);
	}

	@Override
	public void removeEventRecipientById(Long eventRecipientGuid) throws InternalServerException, RecordNotFoundException {
		getEventRecipientById(eventRecipientGuid);
		Session session = getSession();
		final Query query = session.getNamedQuery("removeEventRecipient");
		query.setParameter("eventRecipientGuid", eventRecipientGuid);
		query.executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Long> getEventRecipientById(Long eventRecipientId) throws InternalServerException, RecordNotFoundException {
		Session session = getSession();
		final Query query = session.getNamedQuery("getEventRecipient");
		query.setParameter("eventRecipientId", eventRecipientId);
		List<Long> eventRecipientList=query.list();
		if(eventRecipientList == null || eventRecipientList.isEmpty()){
			throw new RecordNotFoundException(ExceptionConstants.EVENT_RECIPIENT_NOT_FOUND);
		}
		return eventRecipientList;
	}
}
