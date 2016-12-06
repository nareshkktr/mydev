/*
 * 
 */
package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.ShareDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.entity.Share;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

/**
 * The Class ShareDaoImpl.
 */
@Repository
public class ShareDaoImpl extends BaseDaoImpl<Long, Share> implements ShareDao {

	@Override
	public Long shareObject(Share share) throws InternalServerException {
		return save(share);
	}

	@Override
	public Integer getShareCount(String shareObjectType, Long shareObjectGuid) throws InternalServerException {
		Integer shareCount = 0;
		Criterion criterionObj = Restrictions.eq("objectType", shareObjectType);
		Criterion criterionObjOne = Restrictions.eq("objectGuid", shareObjectGuid);
		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		criterions.add(criterionObjOne);
		SortCriteriaData sortCriteriaData = new SortCriteriaData("objectType", true);
		List<Share> shareObjects = getAllByConditions(criterions, sortCriteriaData);
		if (shareObjects != null && !shareObjects.isEmpty()) {
			shareCount = shareObjects.size();
		}
		return shareCount;
	}

}
