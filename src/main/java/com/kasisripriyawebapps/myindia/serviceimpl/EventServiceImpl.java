/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.dao.EventDao;
import com.kasisripriyawebapps.myindia.entity.Event;
import com.kasisripriyawebapps.myindia.entity.EventType;
import com.kasisripriyawebapps.myindia.entity.LocationMaster;
import com.kasisripriyawebapps.myindia.exception.ConflictException;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
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
		Long eventId = 0l;
		if ((eventRequest != null && !eventRequest.equals(""))
				|| (createdLocation != null && createdLocation.equals(""))) {
			eventType.setGuid(eventRequest.getEventTypeGuId());
			event.setEventType(eventType);
			createdLocation.setGuid(eventRequest.getCreatedLocationGuId());
			event.setCreatedLocation(createdLocation);
		}
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
		Event event = new Event();
		EventType eventType = new EventType();
		event = getEventById(eventRequest.getGuid());
		LocationMaster createdLocation = new LocationMaster();
		Long eventId = 0l;
		if ((eventRequest != null && !eventRequest.equals(""))
				|| (createdLocation != null && createdLocation.equals(""))) {
			eventType.setGuid(eventRequest.getEventTypeGuId());
			event.setEventType(eventType);
			createdLocation.setGuid(eventRequest.getCreatedLocationGuId());
			event.setCreatedLocation(createdLocation);
		}
		event.setEventName(eventRequest.getEventName());
		event.setEventDescription(eventRequest.getEventDescription());
		event.setEventLocationDetails(eventRequest.getEventLocationDetails());
		event.setPhotoURL(eventRequest.getPhotoURL());
		event.setEventStartDate(eventRequest.getEventStartDate());
		event.setEventEndDate(eventRequest.getEventEndDate());
		event.setCreatedTimeStamp(loggedInUserDetails.getCreatedTimeStamp());
		event.setUpdatedTimeStamp(loggedInUserDetails.getCreatedTimeStamp());
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
		event = eventDao.getEventById(eventGuid);
		if (event == null) {
			throw new RecordNotFoundException(ExceptionConstants.EVENT_NOT_FOUND);
		}
		eventRequest.setGuid(event.getGuid());
		eventRequest.setEventTypeGuId(event.getEventType().getGuid());
		eventRequest.setCreatedLocationGuId(event.getCreatedLocation().getGuid());
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
}
