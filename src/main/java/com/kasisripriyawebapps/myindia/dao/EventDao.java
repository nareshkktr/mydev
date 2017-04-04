/*
 * 
 */
package com.kasisripriyawebapps.myindia.dao;

import com.kasisripriyawebapps.myindia.entity.Event;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;

/**
 * The Interface EventDao.
 */
public interface EventDao {
	Long createEvent(Event event) throws InternalServerException;

	Long updateEvent(Event event) throws InternalServerException;

	Event getEventById(Long eventGuid) throws InternalServerException, RecordNotFoundException;

	void deleteEventById(Event event) throws InternalServerException, RecordNotFoundException;

}
