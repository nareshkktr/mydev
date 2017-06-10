package com.kasisripriyawebapps.myindia.daoimpl;

import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.PoliticianAccountDao;
import com.kasisripriyawebapps.myindia.entity.PoliticianAccount;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

@Repository
public class PoliticianAccountDaoImpl extends BaseDaoImpl<Long, PoliticianAccount> implements PoliticianAccountDao {

	@Override
	public void savePoliticianAccount(PoliticianAccount politicianAccount) throws InternalServerException {
		save(politicianAccount);
	}

}
