/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.EventDao;
import com.kasisripriyawebapps.myindia.entity.Event;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;

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
}
