package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.LocationMaster;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface LocationMasterDao {

	void saveAllMasterLocations(List<LocationMaster> allMasterLocations) throws InternalServerException;

	List<LocationMaster> getAllMasterLocationsByTypes(List<String> locationTypes) throws InternalServerException;

	void deleteMasterLocations(List<LocationMaster> existingMasterLocations) throws InternalServerException;

	List<LocationMaster> getAllMasterLocationsByType(String locationType) throws InternalServerException;

	void updateAllMasterLocations(List<LocationMaster> updatedMasterLocations) throws InternalServerException;

	LocationMaster getLocationMasterData(Long locationCodeLong) throws InternalServerException;

	List<LocationMaster> getMasterLocationsByTypes(List<String> locationTypes, List<String> stateNames)
			throws InternalServerException;

	List<LocationMaster> getLocationsMasterData(List<Long> eachOffSetLocationCodes) throws InternalServerException;

	List<LocationMaster> getAllMasterLocationsByTypeAndParentLocation(String locationDistrictType,
			Long parentLocationGuid) throws InternalServerException;

	List<LocationMaster> getAllMasterLocationsByTypeAndParentLocations(String locationSubDistrictType,
			List<Long> distirctGuids) throws InternalServerException;

	List<LocationMaster> getAllMasterLocationsByTypesAndParentLocation(List<String> urbanLocationTypes, Long parentLocationGuid) throws InternalServerException;

}
