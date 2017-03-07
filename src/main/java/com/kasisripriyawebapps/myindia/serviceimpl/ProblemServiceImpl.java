/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.dao.LocationMasterDao;
import com.kasisripriyawebapps.myindia.dao.ProblemDao;
import com.kasisripriyawebapps.myindia.dao.ProblemTypeDao;
import com.kasisripriyawebapps.myindia.entity.LocationMaster;
import com.kasisripriyawebapps.myindia.entity.Problem;
import com.kasisripriyawebapps.myindia.entity.ProblemType;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateProblemRequestData;
import com.kasisripriyawebapps.myindia.service.ImageService;
import com.kasisripriyawebapps.myindia.service.ProblemService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

/**
 * The Class ProblemServiceImpl.
 */
@Service
public class ProblemServiceImpl implements ProblemService {

	/** The problem dao. */
	@Autowired
	ProblemDao problemDao;

	@Autowired
	ProblemTypeDao problemTypeDao;

	@Autowired
	private LocationMasterDao locationMasterDao;

	@Autowired
	ImageService imageService;

	@Override
	@Transactional
	public Long createProblem(CreateUpdateProblemRequestData createUpdateProblemRequestData,
			LoggedInUserDetails loggedInUserDetails) throws InternalServerException {
		Long problemGuid = null;
		Problem problem = new Problem();
		problem.setAmountInvolved(createUpdateProblemRequestData.getMoneyAtStake());
		problem.setCreatedBy(loggedInUserDetails.getGuid());
		LocationMaster createdLocation = locationMasterDao
				.getLocationByGuid(createUpdateProblemRequestData.getProblemLocation().getLocationGuid());
		problem.setCreatedLocation(createdLocation);
		problem.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
		problem.setNoOfAffectedPeople(createUpdateProblemRequestData.getNoOfAffectdCitizens());
		problem.setProblemLongDescription(createUpdateProblemRequestData.getProblemDesc());
		problem.setProblemShortDescription(createUpdateProblemRequestData.getProblemName());
		ProblemType problemType = problemTypeDao
				.getProblemTypeById(createUpdateProblemRequestData.getProblemType().getGuid());
		problem.setProblemType(problemType);
		problemGuid = problemDao.saveProblem(problem);
		return problemGuid;
	}

}
