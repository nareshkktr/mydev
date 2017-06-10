package com.kasisripriyawebapps.myindia.dao;

import com.kasisripriyawebapps.myindia.entity.PoliticianAccount;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface PoliticianAccountDao {

	void savePoliticianAccount(PoliticianAccount politicianAccount) throws InternalServerException;

}
