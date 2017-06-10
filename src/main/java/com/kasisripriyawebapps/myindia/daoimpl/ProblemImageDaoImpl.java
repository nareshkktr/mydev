package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.ProblemImageDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.entity.ProblemImage;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

@Repository
public class ProblemImageDaoImpl extends BaseDaoImpl<Long, ProblemImage> implements ProblemImageDao {

	@Override
	public Long saveProblemImage(ProblemImage problemImage) throws InternalServerException {
		return save(problemImage);
	}

	@Override
	public List<ProblemImage> getAllPhotosByGuid(Long objectGuid, Integer pageLimit, Integer pageOffset)
			throws InternalServerException {
		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("createdTimeStamp");
		sortCriteria.setIsAscending(false);

		Criterion criterionObj = Restrictions.eq("problem.guid", objectGuid);
		Criterion criterionObj1 = Restrictions.isNull("problemAlbum.guid");

		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		criterions.add(criterionObj1);

		return getAllByConditionsByPage(criterions, sortCriteria, pageOffset, pageLimit);
	}

	@Override
	public List<ProblemImage> getAlbumPhotosByGuid(Long subObjectGuid, Long objectGuid, Integer pageLimit,
			Integer pageOffset) throws InternalServerException {

		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("createdTimeStamp");
		sortCriteria.setIsAscending(false);

		Criterion criterionObj = Restrictions.eq("problem.guid", objectGuid);
		Criterion criterionObj1 = Restrictions.eq("problemAlbum.guid", subObjectGuid);

		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(criterionObj);
		criterions.add(criterionObj1);

		return getAllByConditionsByPage(criterions, sortCriteria, pageOffset, pageLimit);
	}

}
