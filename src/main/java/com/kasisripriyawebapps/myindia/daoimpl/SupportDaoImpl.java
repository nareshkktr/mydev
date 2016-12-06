package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.SupportDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.entity.Support;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.SupportUnSupportRequest;

@Repository
public class SupportDaoImpl extends BaseDaoImpl<Long, Support> implements SupportDao {

	@Override
	public Long supportObject(Support supportObject) throws InternalServerException {
		return save(supportObject);
	}

	@Override
	public Integer getSupportCount(String supportObjectType, Long supportObjectGuid) throws InternalServerException {
		Integer supportCount = 0;
		Criterion criterionObj = Restrictions.eq("objectType", supportObjectType);
		Criterion criterionObjOne = Restrictions.eq("objectGuid", supportObjectGuid);
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		criterions.add(criterionObjOne);
		SortCriteriaData sortCriteriaData = new SortCriteriaData("objectType", true);
		List<Support> supportObjects = getAllByConditions(criterions, sortCriteriaData);
		if (supportObjects != null && !supportObjects.isEmpty()) {
			supportCount = supportObjects.size();
		}
		return supportCount;
	}

	@Override
	public Support getSupportObject(SupportUnSupportRequest supportUnSupportRequest) throws InternalServerException {
		Criterion criterionObj = Restrictions.eq("objectType", supportUnSupportRequest.getSupportObjectType());
		Criterion criterionObjOne = Restrictions.eq("objectGuid", supportUnSupportRequest.getSupportObjectGuid());
		Criterion criterionObjTwo = Restrictions.eq("supportObjectType",
				supportUnSupportRequest.getSupportingObjectType());
		Criterion criterionObjThree = Restrictions.eq("supportObjectGuid",
				supportUnSupportRequest.getSupportingObjectGuid());
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		criterions.add(criterionObjOne);
		criterions.add(criterionObjTwo);
		criterions.add(criterionObjThree);
		return getByConditions(criterions);
	}

	@Override
	public void unSupportObject(Support supportObject) throws InternalServerException {
		delete(supportObject);
	}

}
