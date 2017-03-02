/*
 * 
 */
package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.constants.ExceptionConstants;
import com.kasisripriyawebapps.myindia.constants.ServiceConstants;
import com.kasisripriyawebapps.myindia.dao.AccountDao;
import com.kasisripriyawebapps.myindia.dao.UserDao;
import com.kasisripriyawebapps.myindia.entity.Account;
import com.kasisripriyawebapps.myindia.entity.Location;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GetUserByPropertyRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.GetUserByPropertyResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.LocationReferenceMasterResponse;
import com.kasisripriyawebapps.myindia.requestresponsemodel.UserLocationDetails;
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
	AccountDao accountDao;

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
	@Transactional
	public LocationReferenceMasterResponse getReferenceLocationForMaster(SolrLocationMaster solrLocationMaster)
			throws RecordNotFoundException {
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

	@Transactional
	@Override
	public GetUserByPropertyResponse getUserByVoterCardDetails(GetUserByPropertyRequest getUserByPropertyRequest)
			throws RecordNotFoundException {
		GetUserByPropertyResponse response = new GetUserByPropertyResponse();
		SolrUserMaster solrUser = userMasterRepository.findByIdCardNo(getUserByPropertyRequest.getIdCardNo());
		if (solrUser != null) {
			if (getUserByPropertyRequest.getUserName().equalsIgnoreCase(solrUser.getElectorName())) {
				if (getUserByPropertyRequest.getReferenceName().equalsIgnoreCase(solrUser.getReferenceName())) {
					if (getUserByPropertyRequest.getGender().equalsIgnoreCase(solrUser.getGender())) {
						int currentYear = CommonUtil.getCurrentYear();
						int yearOfBirth = getUserByPropertyRequest.getYearOfBirth();
						if ((currentYear - yearOfBirth - 1) == solrUser.getAge()) {
							response.setUserGuid(solrUser.getUserGuid());
							response.setLocationState(solrUser.getState());
							response.setLocationDistrict(solrUser.getDistrict());
							response.setLocationMandal(solrUser.getMandal());
							setLocationInformationToRequest(response, solrUser);
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

	@Override
	@Transactional
	public UserLocationDetails getLoggedInUserLocation(Long guid)
			throws RecordNotFoundException, InternalServerException {
		UserLocationDetails userLocationDetails = new UserLocationDetails();
		Account account = accountDao.getAccountById(guid);
		Location nativeLocation = account.getUserInfo().getNativeLocation();
		List<Long> allLocationsGuids = new ArrayList<Long>();

		allLocationsGuids.add(nativeLocation.getLocationCountry());
		allLocationsGuids.add(nativeLocation.getLocationDistrict());
		allLocationsGuids.add(nativeLocation.getLocationMunicipalCorporation());
		allLocationsGuids.add(nativeLocation.getLocationMunicipality());
		allLocationsGuids.add(nativeLocation.getLocationState());
		allLocationsGuids.add(nativeLocation.getLocationSubDistrict());
		allLocationsGuids.add(nativeLocation.getLocationTownPanchayat());
		allLocationsGuids.add(nativeLocation.getLocationVillage());
		allLocationsGuids.add(nativeLocation.getLocationVillagePanchayat());

		allLocationsGuids.removeAll(Collections.singleton(null));
		List<SolrLocationMaster> allLocations = locationMasterRepository.findByLocationGuidIn(allLocationsGuids);

		if (CommonUtil.isListNotNullAndNotEmpty(allLocations)) {

			Map<String, List<SolrLocationMaster>> allLocationsMap = allLocations.stream()
					.collect(Collectors.groupingBy(locationObject -> locationObject.getLocationType()));

			String locationName = "";
			Long locationGuid = null;
			if (allLocationsMap != null) {
				if (allLocationsMap.containsKey(ServiceConstants.LOCATION_VILLAGE_TYPE)) {
					List<SolrLocationMaster> villageLocations = allLocationsMap
							.get(ServiceConstants.LOCATION_VILLAGE_TYPE);
					if (CommonUtil.isListNotNullAndNotEmpty(villageLocations)) {
						locationName = villageLocations.get(0).getLocationName();
						locationGuid = villageLocations.get(0).getLocationGuid();
					}
				}

				if (allLocationsMap.containsKey(ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE)) {
					List<SolrLocationMaster> municipalCorporationLocations = allLocationsMap
							.get(ServiceConstants.LOCATION_MUNCIPAL_CORPORATION_TYPE);
					if (CommonUtil.isListNotNullAndNotEmpty(municipalCorporationLocations)) {
						locationName = municipalCorporationLocations.get(0).getLocationName();
						locationGuid = municipalCorporationLocations.get(0).getLocationGuid();
					}
				}

				if (allLocationsMap.containsKey(ServiceConstants.LOCATION_MUNCIPALITY_TYPE)) {
					List<SolrLocationMaster> muncipalityLocations = allLocationsMap
							.get(ServiceConstants.LOCATION_MUNCIPALITY_TYPE);
					if (CommonUtil.isListNotNullAndNotEmpty(muncipalityLocations)) {
						locationName = muncipalityLocations.get(0).getLocationName();
						locationGuid = muncipalityLocations.get(0).getLocationGuid();
					}
				}

				if (allLocationsMap.containsKey(ServiceConstants.LOCATION_NAGAR_PANCHAYAT_TYPE)) {
					List<SolrLocationMaster> nagarPanchatathLocations = allLocationsMap
							.get(ServiceConstants.LOCATION_NAGAR_PANCHAYAT_TYPE);
					if (CommonUtil.isListNotNullAndNotEmpty(nagarPanchatathLocations)) {
						locationName = nagarPanchatathLocations.get(0).getLocationName();
						locationGuid = nagarPanchatathLocations.get(0).getLocationGuid();
					}
				}

				if (allLocationsMap.containsKey(ServiceConstants.LOCATION_DISTRICT_TYPE)) {
					List<SolrLocationMaster> districtLocations = allLocationsMap
							.get(ServiceConstants.LOCATION_DISTRICT_TYPE);
					if (CommonUtil.isListNotNullAndNotEmpty(districtLocations)) {
						locationName += ", " + districtLocations.get(0).getLocationName();
					}
				}
				userLocationDetails.setLocationGuid(locationGuid);
				userLocationDetails.setLocationName(locationName);
			}
		}
		return userLocationDetails;
	}
}
