package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.PoliticianAuthority;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface PoliticianAuthorityDao {

	List<PoliticianAuthority> getActivePoliticianAuthhoritiesByDesignation(String sittingLoksabhaMpDesignation) throws InternalServerException;

	void saveOrUpdatePolitician(List<PoliticianAuthority> activePoliticianAuthorities) throws InternalServerException;

	List<PoliticianAuthority> getActivePoliticianAuthhoritiesByDesignationAndLocations(String politicianType,
			List<Long> applicableLocationGuids) throws InternalServerException;

}
