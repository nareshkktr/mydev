/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.dao.PoliticianDao;
import com.kasisripriyawebapps.myindia.entity.Politician;
import com.kasisripriyawebapps.myindia.entity.PoliticianAuthority;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.PoliticianRequest;
import com.kasisripriyawebapps.myindia.service.PoliticianService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class PoliticianServiceImpl.
 */
@Service
public class PoliticianServiceImpl implements PoliticianService {

	/** The politician dao. */
	@Autowired
	PoliticianDao politicianDao;

	@Override
	@Transactional
	public void deactivatePoliticians(PoliticianRequest politicianRequest) throws InternalServerException {
		
		List<Politician> politiciansToDeactivate = politicianDao.getAllPoliticians(politicianRequest);
		
		for(Politician politician: politiciansToDeactivate){
			
			//Mark current designation as null
			politician.setCurrentDesignation(null);
			
			//Mark them as inactive
			politician.setIsActive(false);
			
			List<PoliticianAuthority> politicianAuthorities = politician.getPoliticianAuthorities();
			
			for(PoliticianAuthority pa: politicianAuthorities){
				if(pa.isActive()){
					pa.setActive(false);
					pa.setEndDate(CommonUtil.getCurrentGMTTimestamp());
				}
			}
			
		}
		
		//Update politicians
		politicianDao.saveOrUpdatePolitician(politiciansToDeactivate);
		
	}
	
}
