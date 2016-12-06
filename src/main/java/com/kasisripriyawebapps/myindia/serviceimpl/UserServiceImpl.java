/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.constants.ServiceConstants;
import com.kasisripriyawebapps.myindia.dao.UserDao;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GetUserByPropertyRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GetUserByPropertyResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.LocationReferenceMasterResponse;
import com.kasisripriyawebapps.myindia.service.ExternalService;
import com.kasisripriyawebapps.myindia.service.UserService;
import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;
import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationReference;
import com.kasisripriyawebapps.myindia.solr.entity.SolrUserMaster;
import com.kasisripriyawebapps.myindia.solr.repository.LocationMasterRepository;
import com.kasisripriyawebapps.myindia.solr.repository.LocationReferenceRepository;
import com.kasisripriyawebapps.myindia.solr.repository.UserMasterRepository;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	ExternalService externalService;

	@Autowired
	private UserMasterRepository userMasterRepository;

	@Autowired
	private LocationMasterRepository locationMasterRepository;

	@Autowired
	private LocationReferenceRepository locationReferenceRepository;

	@Transactional
	@Override
	public GetUserByPropertyResponse getUserByVoterIdAndName(GetUserByPropertyRequest getUserByPropertyRequest)
			throws RecordNotFoundException {
		GetUserByPropertyResponse response = null;
		SolrUserMaster solrUser = userMasterRepository.findByIdCardTypeAndIdCardNo(
				getUserByPropertyRequest.getIdCardType(), getUserByPropertyRequest.getIdCardNo());
		if (solrUser != null) {
			solrUser = userMasterRepository.findByUserGuidAndElectorName(solrUser.getUserGuid(),
					getUserByPropertyRequest.getUserName());
			if (solrUser != null) {
				response = new GetUserByPropertyResponse();
				response.setUserGuid(solrUser.getUserGuid());
				response.setReferenceType(solrUser.getReferenceType());
			} else {
				throw new RecordNotFoundException(ExceptionConstants.INVALID_ID_CARD_NO_NAME);
			}
		} else {
			throw new RecordNotFoundException(ExceptionConstants.INVALID_ID_CARD_NO);
		}
		return response;
	}

	@Transactional
	@Override
	public GetUserByPropertyResponse getUserByVoterReferenceAndAge(GetUserByPropertyRequest getUserByPropertyRequest)
			throws RecordNotFoundException {
		GetUserByPropertyResponse response = null;
		SolrUserMaster solrUser = userMasterRepository.findByUserGuidAndReferenceName(
				getUserByPropertyRequest.getUserGuid(), getUserByPropertyRequest.getReferenceName());
		if (solrUser != null) {
			response = new GetUserByPropertyResponse();
			response.setUserGuid(getUserByPropertyRequest.getUserGuid());
			response.setLocationState(solrUser.getState());
			response.setLocationDistrict(solrUser.getDistrict());
			response.setLocationMandal(solrUser.getMandal());
			int currentYear = CommonUtil.getCurrentYear();
			int yearOfBirth = getUserByPropertyRequest.getYearOfBirth();
			if ((currentYear - yearOfBirth - 1) == solrUser.getAge()) {
				setLocationInformationToRequest(response, solrUser);
			} else {
				throw new RecordNotFoundException(ExceptionConstants.INVALID_YEAR_OF_BIRTH);
			}
		} else {
			throw new RecordNotFoundException(ExceptionConstants.INVALID_REFERENCE_DETAILS_NAME);
		}
		return response;
	}

	private void setLocationInformationToRequest(GetUserByPropertyResponse response, SolrUserMaster solrUser) {
		SolrLocationMaster mandalLocationMaster = locationMasterRepository
				.findByLocationTypeAndLocationName(ServiceConstants.LOCATION_SUB_DISTRICT_TYPE, solrUser.getMandal());
		List<SolrLocationMaster> villageLocations = locationMasterRepository.findByLocationTypeAndParentLocationGuid(
				ServiceConstants.LOCATION_VILLAGE_TYPE, mandalLocationMaster.getLocationGuid());
		response.setVillageLocations(villageLocations);

		List<String> stateLocationTypes = new ArrayList<String>();
		stateLocationTypes.add(ServiceConstants.LOCATION_STATE_TYPE);
		stateLocationTypes.add(ServiceConstants.LOCATION_UNION_TERRITORY_TYPE);

		SolrLocationMaster stateLocationMaster = locationMasterRepository
				.findByLocationTypeInAndLocationName(stateLocationTypes, solrUser.getState().toUpperCase());

		List<String> urbanLocationTypes = new ArrayList<String>();
		urbanLocationTypes.add(ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE);
		urbanLocationTypes.add(ServiceConstants.LOCATION_MUNCIPALITY_TYPE);
		urbanLocationTypes.add(ServiceConstants.LOCATION_TOWN_PANCHAYATH_TYPE);

		List<SolrLocationMaster> urbanLocations = locationMasterRepository
				.findByLocationTypeInAndParentLocationGuid(urbanLocationTypes, stateLocationMaster.getLocationGuid());

		final Map<String, List<SolrLocationMaster>> urbanLocationsMap = urbanLocations.stream()
				.collect(Collectors.groupingBy(urbanLocation -> urbanLocation.getLocationType()));
		response.setUrbanLocations(urbanLocationsMap);
	}

	@Override
	public LocationReferenceMasterResponse getReferenceLocationForMaster(SolrLocationMaster solrLocationMaster)
			throws RecordNotFoundException {
		LocationReferenceMasterResponse locationReferenceMasterResponse = new LocationReferenceMasterResponse();
		locationReferenceMasterResponse.setChildLocation(solrLocationMaster);
		List<SolrLocationReference> referenceLocations = new ArrayList<SolrLocationReference>();
		if (solrLocationMaster.getLocationType().equalsIgnoreCase(ServiceConstants.LOCATION_VILLAGE_TYPE)) {
			referenceLocations = locationReferenceRepository
					.findByLocationVillage(solrLocationMaster.getLocationGuid());
			if (referenceLocations != null) {
				List<Long> villagePanchayathGuids = referenceLocations.stream()
						.map(SolrLocationReference::getLocationVillagePanchayat).collect(Collectors.toList());
				List<SolrLocationMaster> villagePanchayathMasterLocations = locationMasterRepository
						.findByLocationGuidIn(villagePanchayathGuids);
				locationReferenceMasterResponse.setParentLocations(villagePanchayathMasterLocations);
			}
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
		return locationReferenceMasterResponse;
	}
}
