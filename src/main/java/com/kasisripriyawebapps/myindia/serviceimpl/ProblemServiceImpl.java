/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.dao.ProblemDao;
import com.kasisripriyawebapps.myindia.entity.Problem;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateProblemRequest;
import com.kasisripriyawebapps.myindia.service.ProblemService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ProblemServiceImpl.
 */
@Service
public class ProblemServiceImpl implements ProblemService {

	/** The problem dao. */
	@Autowired
	ProblemDao problemDao;

	@Override
	public Long create(CreateProblemRequest problem, LoggedInUserDetails loggedInUserDetails) throws InternalServerException {
		
		Problem problemObj = new Problem();
		problemObj.setAmountInvolved(problem.getAmountInvolved());
		problemObj.setCreatedLocation(problem.getCreatedLocation());
		problemObj.setNoOfAffectedPeople(problem.getNoOfAffectedPeople());
		problemObj.setProblemLongDescription(problem.getProblemLongDescription());
		problemObj.setProblemShortDescription(problem.getProblemShortDescription());
		problemObj.setProblemType(problem.getProblemType());
		
		//Determine Severity (need some logics)
		String severity = determineProblemSeverity(problem.getAmountInvolved(),problem.getNoOfAffectedPeople());
		
		problemObj.setProblemSeverity(severity);
		
		//Set Status while creation
		problemObj.setProblemStatus("Active");
		
		//Set createdBy modified by etc.
		problemObj.setCreatedBy(loggedInUserDetails.getGuid());
		problemObj.setUpdatedBy(loggedInUserDetails.getGuid());
		
		Timestamp currentTime = CommonUtil.getCurrentGMTTimestamp();
		
		//Set created timestamps
		problemObj.setCreatedTimeStamp(currentTime);
		problemObj.setUpdatedTimeStamp(currentTime);
		
		// Set Escalation enabled.
		problemObj.setEscalationEnabled(false);
		
		//set one entry in problem history
		
		
		return problemDao.createProblem(problemObj);
	}

	private String determineProblemSeverity(Long amountInvolved, Long noOfAffectedPeople) {
		return null;
	}
	
	
	
}
