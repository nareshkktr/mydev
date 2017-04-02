/*
 * 
 */
package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.entity.Event;
import com.kasisripriyawebapps.myindia.exception.ConflictException;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.EventRequest;

/**
 * The Interface EventService.
 */
public interface EventService {
	Long createEvent(EventRequest event,LoggedInUserDetails loggedInUserDetails) throws InternalServerException,ConflictException;
	Long updateEvent(EventRequest event,LoggedInUserDetails loggedInUserDetails) throws InternalServerException,ConflictException, RecordNotFoundException;
	Long deleteEventById(Long eventGuid)throws InternalServerException,RecordNotFoundException;
	Event getEventById(Long eventGuid)throws InternalServerException,RecordNotFoundException;
	EventRequest getEventId(Long eventGuid)throws InternalServerException,RecordNotFoundException;

}
