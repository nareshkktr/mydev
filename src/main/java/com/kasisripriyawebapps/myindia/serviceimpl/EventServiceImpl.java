/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.dao.EventDao;
import com.kasisripriyawebapps.myindia.entity.Account;
import com.kasisripriyawebapps.myindia.entity.Event;
import com.kasisripriyawebapps.myindia.entity.EventRecipients;
import com.kasisripriyawebapps.myindia.entity.EventType;
import com.kasisripriyawebapps.myindia.entity.LocationMaster;
import com.kasisripriyawebapps.myindia.exception.ConflictException;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.EventInviteeStatusRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.EventRecipientRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.EventRequest;
import com.kasisripriyawebapps.myindia.service.EventService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class EventServiceImpl.
 */
@Service
public class EventServiceImpl implements EventService {

	/** The event dao. */
	@Autowired
	EventDao eventDao;

	@Transactional
	public Long createEvent(EventRequest eventRequest, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException, ConflictException {
		Event event = new Event();
		EventType eventType = new EventType();
		LocationMaster createdLocation = new LocationMaster();
		EventRecipients recipients=null;
		Account account=null;
		List<EventRecipients> eventRecipientList=null;
		Long eventId = 0l;
		List<EventRecipientRequest> eventRecipientRequestList=eventRequest.getEventRecipientRequests();
		eventRecipientList=new ArrayList<EventRecipients>();
		for(EventRecipientRequest eventRecipientRequest:eventRecipientRequestList){
			account=new Account();
			recipients=new EventRecipients();
			account.setGuid(eventRecipientRequest.getAccountId());
			recipients.setEvent(event);
			recipients.setRecipientType(eventRecipientRequest.getRecipientType());
			recipients.setCreatedBy(loggedInUserDetails.getGuid());
	    	recipients.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
	    	recipients.setAccount(account);
	    	eventRecipientList.add(recipients);
		}
		if ((eventRequest != null && !eventRequest.equals(""))){
			eventType.setGuid(eventRequest.getEventTypeGuId());
			event.setEventType(eventType);
			createdLocation.setGuid(eventRequest.getCreatedLocationGuId());
			event.setCreatedLocation(createdLocation);
		}
		event.setEventRecipients(eventRecipientList);
		event.setEventName(eventRequest.getEventName());
		event.setEventDescription(eventRequest.getEventDescription());
		event.setEventLocationDetails(eventRequest.getEventLocationDetails());
		event.setPhotoURL(eventRequest.getPhotoURL());
		event.setEventStartDate(eventRequest.getEventStartDate());
		event.setEventEndDate(eventRequest.getEventEndDate());
		event.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
		event.setUpdatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
		event.setCreatedBy(loggedInUserDetails.getGuid());
		event.setUpdatedBy(loggedInUserDetails.getGuid());
		eventId = eventDao.createEvent(event);

		return eventId;

	}

	@Override
	@Transactional
	public Long updateEvent(EventRequest eventRequest, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException, ConflictException, RecordNotFoundException {
		// TODO Auto-generated method stub
		Event event = null;
		EventType eventType = new EventType();
		List<EventRecipients> eventRecipientList=null;
		event = getEventById(eventRequest.getGuid());
		LocationMaster createdLocation = new LocationMaster();
		Long eventId = 0l;
		if ((eventRequest != null && !eventRequest.equals(""))){
			eventType.setGuid(eventRequest.getEventTypeGuId());
			event.setEventType(eventType);
			createdLocation.setGuid(eventRequest.getCreatedLocationGuId());
			event.setCreatedLocation(createdLocation);
		}
		
		event.setEventRecipients(eventRecipientList);
		event.setEventName(eventRequest.getEventName());
		event.setEventDescription(eventRequest.getEventDescription());
		event.setEventLocationDetails(eventRequest.getEventLocationDetails());
		event.setPhotoURL(eventRequest.getPhotoURL());
		event.setEventStartDate(eventRequest.getEventStartDate());
		event.setEventEndDate(eventRequest.getEventEndDate());
		event.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
		event.setUpdatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
		event.setCreatedBy(loggedInUserDetails.getGuid());
		event.setUpdatedBy(loggedInUserDetails.getGuid());

		eventId = eventDao.createEvent(event);

		return eventId;
	}

	@Override
	@Transactional
	public Event getEventById(Long eventGuid)
			throws InternalServerException, RecordNotFoundException {
		Event event = null;
		event = eventDao.getEventById(eventGuid);
		if (event == null) {
			throw new RecordNotFoundException(ExceptionConstants.EVENT_NOT_FOUND);
		}
		return event;

	}
	@Override
	@Transactional
	public EventRequest getEventId(Long eventGuid)
			throws InternalServerException, RecordNotFoundException {
		Event event = null;
		EventRequest eventRequest=new EventRequest();
		List<EventRecipientRequest> eventRecipientRequestsList=new ArrayList<>();
		event = eventDao.getEventById(eventGuid);
		if (event == null) {
			throw new RecordNotFoundException(ExceptionConstants.EVENT_NOT_FOUND);
		}
		eventRequest.setGuid(event.getGuid());
		eventRequest.setEventTypeGuId(event.getEventType().getGuid());
		eventRequest.setCreatedLocationGuId(event.getCreatedLocation().getGuid());
		List<EventRecipients> eventRecipientsList=event.getEventRecipients();
		for(EventRecipients eventRecipients:eventRecipientsList){
			EventRecipientRequest eventRecipientRequest=new EventRecipientRequest();
			eventRecipientRequest.setGuid(eventRecipients.getGuid());
			eventRecipientRequest.setAccountId(eventRecipients.getAccount().getGuid());
			eventRecipientRequest.setCreatedBy(eventRecipients.getCreatedBy());
			eventRecipientRequest.setEventId(eventRecipients.getEvent().getGuid());
			eventRecipientRequest.setRecipientType(eventRecipients.getRecipientType());
			eventRecipientRequest.setCreatedTimeStamp(eventRecipients.getCreatedTimeStamp());
			eventRecipientRequestsList.add(eventRecipientRequest);
		}
		eventRequest.setEventRecipientRequests(eventRecipientRequestsList);
		eventRequest.setEventName(event.getEventName());
		eventRequest.setEventDescription(event.getEventDescription());
		eventRequest.setEventLocationDetails(event.getEventLocationDetails());
		eventRequest.setPhotoURL(event.getPhotoURL());
		eventRequest.setCreatedBy(event.getCreatedBy());
		eventRequest.setUpdatedBy(event.getUpdatedBy());
		eventRequest.setCreatedTimeStamp(event.getCreatedTimeStamp());
		eventRequest.setUpdatedTimeStamp(event.getUpdatedTimeStamp());
		eventRequest.setEventStartDate(event.getEventStartDate());
		eventRequest.setEventEndDate(event.getEventEndDate());
		
		return eventRequest;

	}

	@Override
	@Transactional
	public Long deleteEventById(Long eventGuid)
			throws InternalServerException, RecordNotFoundException {
		Long eventId = 0l;
		Event event = new Event();
		event = getEventById(eventGuid);
		if (event == null) {
			throw new RecordNotFoundException(ExceptionConstants.EVENT_NOT_FOUND);
		}
		eventDao.deleteEventById(event);
		return eventId;

	}

	@Override
	@Transactional
	public Long addEventRecipient(EventRecipientRequest request, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException {
		Long responseId=eventDao.addEventRecipient(request,loggedInUserDetails);
		return responseId;
	}

	@Override
	@Transactional
	public Long removeEventRecipientById(Long eventRecipientGuid) throws InternalServerException, RecordNotFoundException {
		eventDao.removeEventRecipientById(eventRecipientGuid);
		return eventRecipientGuid;
	}

	@Override
	@Transactional
	public Long addEventInviteeStatus(EventInviteeStatusRequest request, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException {
		
		return eventDao.addEventInviteeStatus(request,loggedInUserDetails);
	}

	@Override
	@Transactional
	public Long removeEventInviteeStatusById(Long eventRecipientId) throws InternalServerException, RecordNotFoundException {
		eventDao.getEventRecipientById(eventRecipientId);
		return eventRecipientId;
	}
}
