/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.constants.ProblemStatusParameters;
import com.kasisripriyawebapps.myindia.dao.LocationMasterDao;
import com.kasisripriyawebapps.myindia.dao.ProblemDao;
import com.kasisripriyawebapps.myindia.dao.ProblemTypeDao;
import com.kasisripriyawebapps.myindia.entity.LocationMaster;
import com.kasisripriyawebapps.myindia.entity.Problem;
import com.kasisripriyawebapps.myindia.entity.ProblemHistory;
import com.kasisripriyawebapps.myindia.entity.ProblemOwner;
import com.kasisripriyawebapps.myindia.entity.ProblemType;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ActivityRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.BaseUserInformation;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CreateUpdateProblemRequestData;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ProblemResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ProblemTypeResponse;
import com.kasisripriyawebapps.myindia.service.AccountService;
import com.kasisripriyawebapps.myindia.service.ActivityService;
import com.kasisripriyawebapps.myindia.service.ImageService;
import com.kasisripriyawebapps.myindia.service.ProblemService;
import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;
import com.kasisripriyawebapps.myindia.solr.service.GlobalSearchMasterService;
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
	AccountService accountService;

	@Autowired
	private LocationMasterDao locationMasterDao;

	@Autowired
	ImageService imageService;

	@Autowired
	ActivityService activityService;

	@Resource
	private GlobalSearchMasterService solrGlobalSearchService;

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
		problemHistory.setAccountId(loggedInUserDetails.getGuid());
		problemHistory.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
		problemHistory.setComments(ProblemStatusParameters.CREATED);
		problemHistory.setStatus(ProblemStatusParameters.CREATED);

		List<ProblemHistory> problemHistoryList = new ArrayList<ProblemHistory>();
		problemHistoryList.add(problemHistory);
		problem.setProblemHistory(problemHistoryList);

		problemGuid = problemDao.saveProblem(problem);

		problem.setGuid(problemGuid);

		// Save into solr repository for global search
		solrGlobalSearchService.addToIndex(problem);

		ActivityRequest activityReq = preapreActivityRequest(problem);

		// Save For Activity Feed
		activityService.saveActivity(activityReq);

		return problemGuid;
	}

	private ActivityRequest preapreActivityRequest(Problem problem) {

		ActivityRequest activityRequest = new ActivityRequest();

		activityRequest.setActivityContent(problem.getProblemShortDescription());

		activityRequest.setActivityName(ApplicationConstants.CREATED_PROBLEM);

		// Problem
		activityRequest.setActivityObjectGuid(problem.getGuid());
		activityRequest.setActivityObjectType(ApplicationConstants.OBJECT_TYPE_PROBLEM);

		// Commented By
		activityRequest.setCreatedBy(problem.getCreatedBy());
		activityRequest.setCreatedTimeStamp(problem.getCreatedTimeStamp());

		return activityRequest;
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
	public ProblemResponse retreiveProblem(Long problemGuid) throws InternalServerException, RecordNotFoundException {

		Problem problem = problemDao.getProblemByGuid(problemGuid);

		ProblemResponse problemResponse = null;

		List<Problem> problems = new ArrayList<Problem>();
		problems.add(problem);

		List<ProblemResponse> problemResponses = prepareProblemResponse(problems);

		if (problemResponses != null && problemResponses.size() > 0) {
			problemResponse = problemResponses.get(0);
		}

		// Prepare Problem Owners Response

		List<BaseUserInformation> problemCurrentOwnersResponse = getProblemOwners(problem,
				ApplicationConstants.OBJECT_TYPE_POLTIICIAN);
		BaseUserInformation currentlyWith = null;
		if (CommonUtil.isListNotNullAndNotEmpty(problemCurrentOwnersResponse)) {
			currentlyWith = problemCurrentOwnersResponse.get(0);
		}
		problemResponse.setCurrentlyWith(currentlyWith);

		List<BaseUserInformation> problemContributorsResponse = getProblemOwners(problem,
				ApplicationConstants.CONTRIBUTOR);

		problemResponse.setContributors(problemContributorsResponse);
		return problemResponse;
	}

	private List<BaseUserInformation> getProblemOwners(Problem problem, String category)
			throws InternalServerException, RecordNotFoundException {
		List<ProblemOwner> problemOwners = problem.getProblemOwners();

		List<BaseUserInformation> problemOwnersResponse = null;

		if (CommonUtil.isListNotNullAndNotEmpty(problemOwners)) {
			if (category.equalsIgnoreCase(ApplicationConstants.OBJECT_TYPE_POLTIICIAN)) {
				problemOwners = problemOwners.stream().filter(getOwnerByCategory(category))
						.collect(Collectors.toList());
			}

			Set<Long> accountIds = problemOwners.stream().filter(q -> q.getAccountId() != null)
					.collect(Collectors.groupingBy(problemHistoryObj -> problemHistoryObj.getAccountId())).keySet();

			if (accountIds != null && !accountIds.isEmpty())
				problemOwnersResponse = accountService.getAccountsByIds(accountIds);
		}
		return problemOwnersResponse;
	}

	private Predicate<? super ProblemOwner> getOwnerByCategory(String category) {
		return u -> (u.getCategory().equalsIgnoreCase(category));
	}

	private List<ProblemResponse> prepareProblemResponse(List<Problem> problems)
			throws InternalServerException, RecordNotFoundException {

		List<ProblemResponse> problemResponses = new ArrayList<ProblemResponse>();

		for (Problem problem : problems) {
			ProblemResponse problemResponse = new ProblemResponse();

			problemResponse.setAmountInvolved(problem.getAmountInvolved());
			// Here we wont get?
			problemResponse.setCreatedLocation(prepareSolrLocationMaster(problem.getCreatedLocation()));
			problemResponse.setCreatedTimeStamp(problem.getCreatedTimeStamp());
			problemResponse.setEscalationEnabled(problem.getEscalationEnabled());
			problemResponse.setGuid(problem.getGuid());
			problemResponse.setNoOfAffectedPeople(problem.getNoOfAffectedPeople());
			problemResponse.setPhotoURL(problem.getPhotoURL());
			problemResponse.setProblemLongDescription(problem.getProblemLongDescription());
			problemResponse.setProblemSeverity(problem.getProblemSeverity());
			problemResponse.setProblemShortDescription(problem.getProblemShortDescription());
			problemResponse.setProblemStatus(problem.getProblemStatus());
			problemResponse.setProblemType(prepareProblemTypeResponse(problem.getProblemType()));
			problemResponse.setRootCause(problem.getRootCause());

			// problemResponse.setOwner(owner);
			problemResponse.setCreatedBy(accountService.getAccountByGuid(problem.getCreatedBy()));

			problemResponse.setFollowingCount(problem.getFollowingCount());
			problemResponse.setShareCount(problem.getShareCount());
			problemResponse.setSupportCount(problem.getSupportCount());
			problemResponse.setViewCount(problem.getViewCount());
			problemResponse.setPopularityCount(problem.getPopularityCount());

			problemResponses.add(problemResponse);
		}

		return problemResponses;
	}

	private ProblemTypeResponse prepareProblemTypeResponse(ProblemType problemType) {

		ProblemTypeResponse problemTypeResponse = new ProblemTypeResponse();
		problemTypeResponse.setProblemTypeGuid(problemType.getGuid());
		problemTypeResponse.setProblemCategory(problemType.getProblemCategory());
		problemTypeResponse.setProblemTypeMinistry(problemType.getProblemTypeMinistry());
		problemTypeResponse.setProblemTypeName(problemType.getProblemTypeName());
		problemTypeResponse.setProblemTypePhotoURL(problemType.getProblemTypePhotoURL());

		return problemTypeResponse;
	}

	private SolrLocationMaster prepareSolrLocationMaster(LocationMaster createdLocation) {

		SolrLocationMaster location = new SolrLocationMaster();
		location.setLocationGuid(createdLocation.getGuid());
		location.setLocationCode(createdLocation.getLocationCode());
		location.setLocationName(createdLocation.getLocationName());
		location.setLocationType(createdLocation.getLocationType());
		location.setParentLocationGuid(createdLocation.getParentLocationGuid());
		return location;
	}

	@Override
	@Transactional
	public List<ProblemResponse> retreiveProblemsByType(Long problemTypeGuid, LoggedInUserDetails loggedInUserDetails)
			throws InternalServerException, RecordNotFoundException {
		ProblemType problemType = problemTypeDao.getProblemTypeById(problemTypeGuid);
		List<Problem> probObj = problemType.getProblems();
		List<ProblemResponse> problemResponse = prepareProblemResponse(probObj);
		return problemResponse;
	}

	@Override
	@Transactional
	public List<ProblemResponse> retreiveProblemsByTypeCategory(String problemTypeCategory,
			LoggedInUserDetails loggedInUserDetails) throws InternalServerException, RecordNotFoundException {
		List<ProblemType> problemTypes = problemTypeDao.getProblemTypesByCategory(problemTypeCategory);

		List<Problem> problems = new ArrayList<Problem>();

		for (ProblemType problemType : problemTypes) {
			problems.addAll(problemType.getProblems());
		}

		List<ProblemResponse> problemResponse = prepareProblemResponse(problems);
		return problemResponse;
	}

	@Override
	@Transactional
	public List<ProblemResponse> filterProblems(Set<String> tokens, Integer pageNo, Integer pageLimit)
			throws InternalServerException, RecordNotFoundException {

		List<Problem> problems = problemDao.filterProblems(tokens, pageNo, pageLimit);

		List<ProblemResponse> filteredProblems = prepareProblemResponse(problems);

		return filteredProblems;
	}

	@Override
	@Transactional
	public List<BaseUserInformation> retreiveProblemContributorsByGuid(Long problemGuid)
			throws InternalServerException, RecordNotFoundException {

		Problem problem = problemDao.getProblemByGuid(problemGuid);

		List<ProblemHistory> problemHistory = problem.getProblemHistory();

		Set<Long> accountIds = problemHistory.stream().filter(q -> q.getAccountId() != null)
				.collect(Collectors.groupingBy(problemHistoryObj -> problemHistoryObj.getAccountId())).keySet();

		List<BaseUserInformation> contributors = null;

		if (accountIds != null && !accountIds.isEmpty())
			contributors = accountService.getAccountsByIds(accountIds);

		return contributors;
	}

	@Override
	public ProblemResponse retreiveProblemBaseInfo(Long problemGuid)
			throws InternalServerException, RecordNotFoundException {

		Problem problem = problemDao.getProblemByGuid(problemGuid);

		ProblemResponse problemResponse = null;

		if (problem != null) {
			problemResponse = new ProblemResponse();
			problemResponse.setProblemShortDescription(problem.getProblemShortDescription());
			problemResponse.setProblemLongDescription(problem.getProblemLongDescription());
			problemResponse.setPhotoURL(problem.getPhotoURL());
			problemResponse.setGuid(problem.getGuid());
		}

		return problemResponse;
	}

}
