/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.constants.ProblemStatusParameters;
import com.kasisripriyawebapps.myindia.dao.LocationMasterDao;
import com.kasisripriyawebapps.myindia.dao.ProblemDao;
import com.kasisripriyawebapps.myindia.dao.ProblemTypeDao;
import com.kasisripriyawebapps.myindia.entity.LocationMaster;
import com.kasisripriyawebapps.myindia.entity.Problem;
import com.kasisripriyawebapps.myindia.entity.ProblemHistory;
import com.kasisripriyawebapps.myindia.entity.ProblemType;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateProblemRequestData;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ProblemResponse;
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
		problem.setProblemStatus(ProblemStatusParameters.CREATED);
		problem.setTags(createUpdateProblemRequestData.getTags());

		String problemSeverity = calculateProblemSeverity(createUpdateProblemRequestData);
		problem.setProblemSeverity(problemSeverity);

		ProblemHistory problemHistory = new ProblemHistory();
		problemHistory.setProblem(problem);
		problemHistory.setCreatedBy(loggedInUserDetails.getGuid());
		problemHistory.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
		problemHistory.setComments(ProblemStatusParameters.CREATED);
		problemHistory.setStatus(ProblemStatusParameters.CREATED);

		List<ProblemHistory> problemHistoryList = new ArrayList<ProblemHistory>();
		problemHistoryList.add(problemHistory);
		problem.setProblemHistory(problemHistoryList);

		problemGuid = problemDao.saveProblem(problem);
		return problemGuid;
	}

	private String calculateProblemSeverity(CreateUpdateProblemRequestData createUpdateProblemRequestData) {
		String problemSeverity = "";
		if (createUpdateProblemRequestData.getNoOfAffectdCitizens() != null) {
			if (createUpdateProblemRequestData.getMoneyAtStake() != null) {
				Long averageSeverityCount = (createUpdateProblemRequestData.getNoOfAffectdCitizens()
						+ createUpdateProblemRequestData.getMoneyAtStake()) / 2;
				Double averageSeverityCountDbl = Math.ceil(averageSeverityCount.doubleValue());
				problemSeverity = getSeverity(averageSeverityCountDbl.longValue());
			} else {
				problemSeverity = getSeverity(createUpdateProblemRequestData.getNoOfAffectdCitizens());
			}
		} else {
			if (createUpdateProblemRequestData.getMoneyAtStake() != null) {
				problemSeverity = getSeverity(createUpdateProblemRequestData.getMoneyAtStake());
			}
		}
		return problemSeverity;
	}

	private String getSeverity(Long severityLevel) {

		if (severityLevel == 1) {
			return "Critical";
		} else if (severityLevel == 2) {
			return "High";
		} else if (severityLevel == 3) {
			return "Medium";
		} else {
			return "Low";
		}
	}

	@Override
	@Transactional
	public ProblemResponse retreiveProblem(Long problemGuid, LoggedInUserDetails loggedInUserDetails) throws InternalServerException {
		
		Problem problem = problemDao.getProblemByGuid(problemGuid);
		
		ProblemResponse problemResponse = null;
		
		List<Problem> problems = new ArrayList<Problem>();
		problems.add(problem);
		
		List<ProblemResponse> problemResponses = prepareProblemResponse(problems);
		
		if(problemResponses != null && problemResponses.size()>0){
			problemResponse = problemResponses.get(0);
		}
		
		return problemResponse;
	}
	
	

	private List<ProblemResponse> prepareProblemResponse(List<Problem> problems) {

		List<ProblemResponse> problemResponses = new ArrayList<ProblemResponse>();
		
		for(Problem problem: problems){
			ProblemResponse problemResponse = new ProblemResponse();

			problemResponse.setAmountInvolved(problem.getAmountInvolved());
			// Here we wont get?
			problemResponse.setCreatedLocation(problem.getCreatedLocation());
			problemResponse.setCreatedTimeStamp(problem.getCreatedTimeStamp());
			problemResponse.setEscalationEnabled(problem.getEscalationEnabled());
			problemResponse.setGuid(problem.getGuid());
			problemResponse.setNoOfAffectedPeople(problem.getNoOfAffectedPeople());
			problemResponse.setPhotoURL(problem.getPhotoURL());
			problemResponse.setProblemLongDescription(problem.getProblemLongDescription());
			problemResponse.setProblemSeverity(problem.getProblemSeverity());
			problemResponse.setProblemShortDescription(problem.getProblemShortDescription());
			problemResponse.setProblemStatus(problem.getProblemStatus());
			problemResponse.setProblemType(problem.getProblemType());
			problemResponse.setRootCause(problem.getRootCause());
			
			//			problemResponse.setOwner(owner);
			//		problemResponse.setCreatedBy(createdBy);
			
			problemResponses.add(problemResponse);
		}

		return problemResponses;
	}

	@Override
	@Transactional
	public List<ProblemResponse> retreiveProblemsByType(Long problemTypeGuid, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException {
		// TODO Auto-generated method stub
		ProblemType problemType = problemTypeDao.getProblemTypeById(problemTypeGuid);
		List<Problem> probObj = problemType.getProblems();
		List<ProblemResponse> problemResponse = prepareProblemResponse(probObj);
		return problemResponse;
	}

}
