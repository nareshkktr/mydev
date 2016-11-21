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

	void saveParties(List<Party> politicalParties) throws InternalServerException;

	List<Party> getAllParties() throws InternalServerException;

	void updateParties(List<Party> updatedParties) throws InternalServerException;

	void deleteParties(List<Party> existingParties) throws InternalServerException;

}
