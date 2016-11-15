/*
 * 
 */
package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.Party;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Interface PartyDao.
 */
public interface PartyDao {

	void importParties(List<Party> politicalParties) throws InternalServerException;

}
