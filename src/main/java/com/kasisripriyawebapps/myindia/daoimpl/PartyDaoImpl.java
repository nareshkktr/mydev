/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.PartyDao;
import com.kasisripriyawebapps.myindia.entity.Party;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Class PartyDaoImpl.
 */
@Repository
public class PartyDaoImpl extends BaseDaoImpl<Long, Party> implements PartyDao {

	@Override
	public void importParties(List<Party> politicalParties) throws InternalServerException {
		saveBatch(politicalParties);
	}

}
