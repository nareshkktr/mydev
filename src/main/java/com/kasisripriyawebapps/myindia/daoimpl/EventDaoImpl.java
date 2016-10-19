/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.EventDao;
import com.kasisripriyawebapps.myindia.entity.Event;

/**
 * The Class EventDaoImpl.
 */
@Repository
public class EventDaoImpl extends BaseDaoImpl<Long, Event> implements EventDao {

}
