package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.constants.ServiceConstants;
import com.kasisripriyawebapps.myindia.dao.UserOccupationDao;
import com.kasisripriyawebapps.myindia.entity.UserOccupation;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.LocationReferenceMasterResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.UserOccupationResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ValidateElectorDetailsRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ValidateElectorDetailsResponse;
import com.kasisripriyawebapps.myindia.service.SignUpService;
import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;
import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationReference;
import com.kasisripriyawebapps.myindia.solr.entity.SolrPoliticianAuthorityMaster;
import com.kasisripriyawebapps.myindia.solr.entity.SolrPoliticianMaster;
import com.kasisripriyawebapps.myindia.solr.entity.SolrUserMaster;
import com.kasisripriyawebapps.myindia.solr.repository.LocationMasterRepository;
import com.kasisripriyawebapps.myindia.solr.repository.LocationReferenceRepository;
import com.kasisripriyawebapps.myindia.solr.repository.PoliticianAuthorityRepository;
import com.kasisripriyawebapps.myindia.solr.repository.PoliticianMasterRepository;
import com.kasisripriyawebapps.myindia.solr.repository.UserMasterRepository;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private UserMasterRepository userMasterRepository;

	@Autowired
	private LocationMasterRepository locationMasterRepository;

	@Autowired
	private LocationReferenceRepository locationReferenceRepository;

	@Autowired
	private UserOccupationDao userOccupationDao;

	@Autowired
	private PoliticianMasterRepository politicianMasterRepository;

	@Autowired
	private PoliticianAuthorityRepository politicianAuthorityRepository;

	@Override
	@Transactional
	public ValidateElectorDetailsResponse validateElectorDetails(
			ValidateElectorDetailsRequest validateElectorDetailsRequest)
			throws RecordNotFoundException, InternalServerException {

		ValidateElectorDetailsResponse response = new ValidateElectorDetailsResponse();
		SolrUserMaster solrUser = userMasterRepository.findByIdCardNo(validateElectorDetailsRequest.getIdCardNo());
		if (solrUser != null) {
			if (validateElectorDetailsRequest.getElectorName().equalsIgnoreCase(solrUser.getElectorName())) {
				if (validateElectorDetailsRequest.getReferenceName().equalsIgnoreCase(solrUser.getReferenceName())) {
					if (validateElectorDetailsRequest.getGender().equalsIgnoreCase(solrUser.getGender())) {
						int currentYear = CommonUtil.getCurrentYear();
						int yearOfBirth = validateElectorDetailsRequest.getYearOfBirth();
						if ((currentYear - yearOfBirth - 1) == solrUser.getAge()) {
							response.setUserGuid(solrUser.getUserGuid());
							response.setLocationState(solrUser.getState());
							response.setLocationDistrict(solrUser.getDistrict());
							response.setLocationMandal(solrUser.getMandal());
							response.setMainTown(solrUser.getMainTwon());

							setLocationInformationToResponse(response, solrUser);
							setOccupationsToResponse(response);

						} else {
							throw new RecordNotFoundException(ExceptionConstants.INVALID_YEAR_OF_BIRTH);
						}
					} else {
						throw new RecordNotFoundException(ExceptionConstants.INVALID_GENDER);
					}
				} else {
					throw new RecordNotFoundException(ExceptionConstants.INVALID_REFERENCE_DETAILS_NAME);
				}
			} else {
				throw new RecordNotFoundException(ExceptionConstants.INVALID_ID_CARD_NO_NAME);
			}
		} else {
			throw new RecordNotFoundException(ExceptionConstants.INVALID_ID_CARD_NO);
		}
		return response;
	}

	private void setOccupationsToResponse(ValidateElectorDetailsResponse response) throws InternalServerException {

		List<UserOccupation> userOccupationList = userOccupationDao.getAllUserOccupations();
		if (CommonUtil.isListNotNullAndNotEmpty(userOccupationList)) {
			List<UserOccupationResponse> userOccupationResponseList = new ArrayList<UserOccupationResponse>();
			for (UserOccupation userOccupation : userOccupationList) {
				UserOccupationResponse userOccupationResponse = new UserOccupationResponse();
				userOccupationResponse.setGuid(userOccupation.getGuid());
				userOccupationResponse.setOccupation(userOccupation.getOccupation());
				userOccupationResponseList.add(userOccupationResponse);
			}
			response.setOccupations(userOccupationResponseList);
		}
	}

	private void setLocationInformationToResponse(ValidateElectorDetailsResponse response, SolrUserMaster solrUser) {

		SolrLocationMaster mandalLocationMaster = locationMasterRepository
				.findByLocationTypeAndLocationName(ServiceConstants.LOCATION_SUB_DISTRICT_TYPE, solrUser.getMandal());

		List<SolrLocationReference> referenceLocations = locationReferenceRepository
				.findByLocationSubDistrict(mandalLocationMaster.getLocationGuid());

		List<Long> allLocationsGuids = new ArrayList<Long>();

		List<Long> villageLocationGuids = referenceLocations.stream().map(SolrLocationReference::getLocationVillage)
				.collect(Collectors.toList());

		List<Long> municipalCorporationLocationGuids = referenceLocations.stream()
				.map(SolrLocationReference::getLocationMunicipalCorporation).collect(Collectors.toList());

		List<Long> municipalityLocationGuids = referenceLocations.stream()
				.map(SolrLocationReference::getLocationMunicipality).collect(Collectors.toList());

		List<Long> townPanchyathLocationGuids = referenceLocations.stream()
				.map(SolrLocationReference::getLocationTownPanchayat).collect(Collectors.toList());

		allLocationsGuids.addAll(villageLocationGuids);
		allLocationsGuids.addAll(municipalCorporationLocationGuids);
		allLocationsGuids.addAll(municipalityLocationGuids);
		allLocationsGuids.addAll(townPanchyathLocationGuids);

		allLocationsGuids.removeAll(Collections.singleton(null));

		List<SolrLocationMaster> allLocations = locationMasterRepository.findByLocationGuidIn(allLocationsGuids);

		response.setLocations(allLocations);
	}

	@Override
	public LocationReferenceMasterResponse getReferenceLocationForMaster(SolrLocationMaster solrLocationMaster)
			throws RecordNotFoundException, InternalServerException {
		LocationReferenceMasterResponse locationReferenceMasterResponse = new LocationReferenceMasterResponse();
		locationReferenceMasterResponse.setChildLocation(solrLocationMaster);
		List<SolrLocationReference> referenceLocations = new ArrayList<SolrLocationReference>();
		if (solrLocationMaster.getLocationType().equalsIgnoreCase(ServiceConstants.LOCATION_VILLAGE_TYPE)) {
			referenceLocations = locationReferenceRepository
					.findByLocationVillage(solrLocationMaster.getLocationGuid());

		} else if (solrLocationMaster.getLocationType()
				.equalsIgnoreCase(ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE)) {
			referenceLocations = locationReferenceRepository
					.findByLocationMunicipalCorporation(solrLocationMaster.getLocationGuid());
		} else if (solrLocationMaster.getLocationType().equalsIgnoreCase(ServiceConstants.LOCATION_MUNCIPALITY_TYPE)) {
			referenceLocations = locationReferenceRepository
					.findByLocationMunicipality(solrLocationMaster.getLocationGuid());
		} else if (solrLocationMaster.getLocationType()
				.equalsIgnoreCase(ServiceConstants.LOCATION_TOWN_PANCHAYATH_TYPE)) {
			referenceLocations = locationReferenceRepository
					.findByLocationTownPanchayat(solrLocationMaster.getLocationGuid());
		}
		if (referenceLocations != null) {
			List<Long> referenceGuids = referenceLocations.stream()
					.map(SolrLocationReference::getLocationVillagePanchayat).collect(Collectors.toList());
			List<SolrLocationMaster> masterLocations = locationMasterRepository.findByLocationGuidIn(referenceGuids);
			locationReferenceMasterResponse.setParentLocations(masterLocations);
		}
		return locationReferenceMasterResponse;
	}

	@Override
	public List<SolrPoliticianMaster> getPoliticiansByName(Long userGuid)
			throws RecordNotFoundException, InternalServerException {
		SolrUserMaster userMaster = userMasterRepository.findByUserGuid(userGuid);
		List<SolrPoliticianMaster> allPoliticians = politicianMasterRepository.findAll();

		allPoliticians = allPoliticians.stream().filter(getMatchingNamePoliticians(userMaster.getElectorName()))
				.collect(Collectors.toList());

		return allPoliticians;
	}

	private Predicate<? super SolrPoliticianMaster> getMatchingNamePoliticians(String politicianName) {
		return u -> (computeNameDistance(politicianName, u.getFullName()));
	}

	private Boolean computeNameDistance(String politicianName, String eachPolitician) {
		double min = 9999;
		Boolean matchFound = false;
		double minDistance = StringUtils.getLevenshteinDistance(eachPolitician, politicianName);
		if (minDistance <= 5 && minDistance < min) {
			matchFound = true;
		}
		return matchFound;
	}

	@Override
	public SolrPoliticianAuthorityMaster validatePoliticianSelection(
			SolrPoliticianAuthorityMaster solrPoliticianAuthorityMaster)
			throws RecordNotFoundException, InternalServerException {

		List<SolrPoliticianAuthorityMaster> politicianAuthorities = politicianAuthorityRepository
				.findAllByPoliticianGuid(solrPoliticianAuthorityMaster.getPoliticianGuid());

		if (CommonUtil.isListNotNullAndNotEmpty(politicianAuthorities)) {
			for (SolrPoliticianAuthorityMaster eachSolrPoliticianAuthorityMaster : politicianAuthorities) {
				if (eachSolrPoliticianAuthorityMaster.getLocationGuid() != null && eachSolrPoliticianAuthorityMaster
						.getLocationGuid().equals(solrPoliticianAuthorityMaster.getLocationGuid())) {
					break;
				} else {
					throw new RecordNotFoundException(ExceptionConstants.INVALID_DETAILS);
				}
			}
		} else {
			throw new RecordNotFoundException(ExceptionConstants.INVALID_DETAILS);
		}

		return solrPoliticianAuthorityMaster;
	}

}
