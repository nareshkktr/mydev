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

import com.kasisripriyawebapps.myindia.constants.ServiceConstants;
import com.kasisripriyawebapps.myindia.dao.AccountDao;
import com.kasisripriyawebapps.myindia.dao.UserDao;
import com.kasisripriyawebapps.myindia.entity.Account;
import com.kasisripriyawebapps.myindia.entity.Location;
import com.kasisripriyawebapps.myindia.entity.UserInfo;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.UserLocationDetails;
import com.kasisripriyawebapps.myindia.service.ExternalService;
import com.kasisripriyawebapps.myindia.service.UserService;
import com.kasisripriyawebapps.myindia.solr.entity.SolrLocationMaster;
import com.kasisripriyawebapps.myindia.solr.repository.LocationMasterRepository;
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
	private LocationMasterRepository locationMasterRepository;

	@Override
	@Transactional
	public UserLocationDetails getLoggedInUserLocation(Long guid)
			throws RecordNotFoundException, InternalServerException {
		UserLocationDetails userLocationDetails = new UserLocationDetails();
		Account account = accountDao.getAccountById(guid);
		UserInfo userInfo = account.getUserInfo();
		Location nativeLocation = userInfo.getNativeLocation();
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
