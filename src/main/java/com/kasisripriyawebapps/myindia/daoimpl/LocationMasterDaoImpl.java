package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.LocationMasterDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.entity.LocationMaster;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

@Repository
public class LocationMasterDaoImpl extends BaseDaoImpl<Long, LocationMaster> implements LocationMasterDao {

	@Override
	public void saveAllMasterLocations(List<LocationMaster> allMasterLocations) throws InternalServerException {
		saveBatch(allMasterLocations);
	}

	@Override
	public List<LocationMaster> getAllMasterLocationsByTypes(List<String> locationTypes)
			throws InternalServerException {

		Criterion criterionObj = Restrictions.in("locationType", locationTypes);
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("locationName");
		sortCriteria.setIsAscending(true);
		return getAllByConditions(criterions, sortCriteria);
	}

	@Override
	public void deleteMasterLocations(List<LocationMaster> existingMasterLocations) throws InternalServerException {
		deleteBatch(existingMasterLocations);
	}

	@Override
	public List<LocationMaster> getAllMasterLocationsByType(String locationType) throws InternalServerException {
		Criterion criterionObj = Restrictions.eq("locationType", locationType);
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("locationName");
		sortCriteria.setIsAscending(true);
		return getAllByConditions(criterions, sortCriteria);
	}

	@Override
	public void updateAllMasterLocations(List<LocationMaster> updatedMasterLocations) throws InternalServerException {
		mergeBatch(updatedMasterLocations);

	}

	@Override
	public LocationMaster getLocationMasterData(Long locationCodeLong) throws InternalServerException {
		Criterion criterionObj = Restrictions.eq("locationCode", locationCodeLong);
		return getByCondition(criterionObj);
	}

	@Override
	public List<LocationMaster> getMasterLocationsByTypes(List<String> locationTypes, List<String> stateNames)
			throws InternalServerException {

		Criterion criterionObj = Restrictions.in("locationType", locationTypes);
		Criterion criterionObj1 = Restrictions.in("locationName", stateNames);

		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		criterions.add(criterionObj1);

		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("locationName");
		sortCriteria.setIsAscending(true);
		return getAllByConditions(criterions, sortCriteria);

	}

	@Override
	public List<LocationMaster> getLocationsMasterData(List<Long> eachOffSetLocationCodes)
			throws InternalServerException {
		Criterion criterionObj = Restrictions.in("locationCode", eachOffSetLocationCodes);
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("locationName");
		sortCriteria.setIsAscending(true);
		return getAllByConditions(criterions, sortCriteria);
	}

	@Override
	public List<LocationMaster> getAllMasterLocationsByTypeAndParentLocation(String locationDistrictType,
			Long parentLocationGuid) throws InternalServerException {

		Criterion criterionObj = Restrictions.eq("locationType", locationDistrictType);
		Criterion criterionObj1 = Restrictions.eq("parentLocationGuid", parentLocationGuid);

		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		criterions.add(criterionObj1);

		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("locationName");
		sortCriteria.setIsAscending(true);
		return getAllByConditions(criterions, sortCriteria);
	}

	@Override
	public List<LocationMaster> getAllMasterLocationsByTypeAndParentLocations(String locationSubDistrictType,
			List<Long> distirctGuids) throws InternalServerException {
		Criterion criterionObj = Restrictions.eq("locationType", locationSubDistrictType);
		Criterion criterionObj1 = Restrictions.in("parentLocationGuid", distirctGuids);

		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		criterions.add(criterionObj1);

		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("locationName");
		sortCriteria.setIsAscending(true);
		return getAllByConditions(criterions, sortCriteria);
	}

	@Override
	public List<LocationMaster> getAllMasterLocationsByTypesAndParentLocation(List<String> urbanLocationTypes,
			Long parentLocationGuid) throws InternalServerException {
		Criterion criterionObj = Restrictions.in("locationType", urbanLocationTypes);
		Criterion criterionObj1 = Restrictions.eq("parentLocationGuid", parentLocationGuid);

		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		criterions.add(criterionObj1);

		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("locationName");
		sortCriteria.setIsAscending(true);
		return getAllByConditions(criterions, sortCriteria);
	}

	@Override
	public LocationMaster getLocationByGuid(Long locationGuid) throws InternalServerException {
		return getById(locationGuid);
	}
}
