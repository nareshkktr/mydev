package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.UserImportDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.entity.ElectroralRollesURL;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

@Repository
public class UserImportDaoImpl extends BaseDaoImpl<Long, ElectroralRollesURL> implements UserImportDao {

	@Override
	public void saveElectroralRollesURLData(List<ElectroralRollesURL> electroralRollesUrlList)
			throws InternalServerException {
		saveBatch(electroralRollesUrlList);
	}

	@Override
	public List<ElectroralRollesURL> getElectroralRollesURLData(ElectroralRollesURL electroralRollesURL)
			throws InternalServerException {

		List<ElectroralRollesURL> returnList = new ArrayList<ElectroralRollesURL>();

		Criterion criterionObj = null;
		if (electroralRollesURL.getStateName() != null && !electroralRollesURL.getStateName().isEmpty()) {
			criterionObj = Restrictions.eq("stateName", electroralRollesURL.getStateName());
		}
		Criterion criterionObjOne = null;
		if (electroralRollesURL.getDistrictName() != null && !electroralRollesURL.getDistrictName().isEmpty()) {
			criterionObjOne = Restrictions.eq("districtName", electroralRollesURL.getDistrictName());
		}
		Criterion criterionObjTwo = null;
		if (electroralRollesURL.getMlaConstituencyName() != null
				&& !electroralRollesURL.getMlaConstituencyName().isEmpty()) {
			criterionObjTwo = Restrictions.eq("mlaConstituencyName", electroralRollesURL.getMlaConstituencyName());
		}
		Criterion criterionObjThree = null;
		if (electroralRollesURL.getPollingStationName() != null
				&& !electroralRollesURL.getPollingStationName().isEmpty()) {
			criterionObjThree = Restrictions.eq("pollingStationName", electroralRollesURL.getPollingStationName());
		}
		Criterion criterionObjFour = null;
		if (electroralRollesURL.getPollingStationAddress() != null
				&& !electroralRollesURL.getPollingStationAddress().isEmpty()) {
			criterionObjFour = Restrictions.eq("pollingStationAddress", electroralRollesURL.getPollingStationAddress());
		}
		List<Criterion> criterions = new ArrayList<Criterion>();
		if (criterionObj != null) {
			criterions.add(criterionObj);
		}
		if (criterionObjOne != null) {
			criterions.add(criterionObjOne);
		}
		if (criterionObjTwo != null) {
			criterions.add(criterionObjTwo);
		}
		if (criterionObjThree != null) {
			criterions.add(criterionObjThree);
		}
		if (criterionObjFour != null) {
			criterions.add(criterionObjFour);
		}
		SortCriteriaData sortCriteriaData = new SortCriteriaData("mlaConstituencyNo", true);
		if (!criterions.isEmpty()) {
			returnList = getAllByConditions(criterions, sortCriteriaData);
		}
		return returnList;
	}

	@Override
	public void updateElectroralRollesURLData(List<ElectroralRollesURL> updatedElectroralRollesUrlList)
			throws InternalServerException {
		mergeBatch(updatedElectroralRollesUrlList);
	}

	@Override
	public void deleteeElectroralRollesURLData(List<ElectroralRollesURL> existingElectroralRollesUrlList)
			throws InternalServerException {
		deleteBatch(existingElectroralRollesUrlList);
	}
}
