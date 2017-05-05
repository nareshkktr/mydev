/*
 * 
 */
package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.Politician;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.PoliticianRequest;

/**
 * The Interface PoliticianDao.
 */
public interface PoliticianDao {

	List<Politician> getAllPoliticians() throws InternalServerException;

	void saveOrUpdatePolitician(List<Politician> newPolitician) throws InternalServerException;

	List<Politician> getAllPoliticians(PoliticianRequest politicianRequest) throws InternalServerException;

}
