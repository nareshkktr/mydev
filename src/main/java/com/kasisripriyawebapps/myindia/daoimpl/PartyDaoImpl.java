/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.PartyDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.entity.Party;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Class PartyDaoImpl.
 */
@Repository
public class PartyDaoImpl extends BaseDaoImpl<Long, Party> implements PartyDao {

	@Override
	public void saveParties(List<Party> politicalParties) throws InternalServerException {
		saveBatch(politicalParties);
	}

	@Override
	public List<Party> getAllParties() throws InternalServerException {
		SortCriteriaData sortCriteria = new SortCriteriaData("partyName", true);
		return getAll(sortCriteria);
	}

	@Override
	public void updateParties(List<Party> updatedParties) throws InternalServerException {
		updateBatch(updatedParties);
	}

	@Override
	public void deleteParties(List<Party> existingParties) throws InternalServerException {
		deleteBatch(existingParties);
	}

}
