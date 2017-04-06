/*
 * 
 */
package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.entity.Event;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.EventInviteeStatusRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.EventRecipientRequest;

/**
 * The Interface EventDao.
 */
public interface EventDao {
	Long createEvent(Event event) throws InternalServerException;
	Long updateEvent(Event event) throws InternalServerException;
	Event getEventById(Long eventGuid) throws InternalServerException, RecordNotFoundException;
	void deleteEventById(Event event) throws InternalServerException, RecordNotFoundException;
	Long addEventRecipient(EventRecipientRequest eventRecipientRequest,LoggedInUserDetails loggedInUserDetails) throws InternalServerException;
	void removeEventRecipientById(Long eventGuid) throws InternalServerException, RecordNotFoundException;
	List<Long> getEventRecipientById(Long eventRecipientId) throws InternalServerException, RecordNotFoundException;
	Long addEventInviteeStatus(EventInviteeStatusRequest request,LoggedInUserDetails loggedInUserDetails) throws InternalServerException;
	Long removeEventInviteeStatusById(Long eventGuid)throws InternalServerException,RecordNotFoundException;
	List<Long> getEventInviteeStatusById(Long eventGuid)throws InternalServerException,RecordNotFoundException;
}
