package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.ProblemAlbumDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.entity.ProblemAlbum;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

@Repository
public class ProblemAlbumDaoImpl extends BaseDaoImpl<Long, ProblemAlbum> implements ProblemAlbumDao {

	@Override
	public ProblemAlbum getProblemAlbumByGuid(Long objectId) throws InternalServerException {
		return getById(objectId);
	}

	@Override
	public Long saveProblemAlbum(ProblemAlbum problemAlbum) throws InternalServerException {
		return save(problemAlbum);
	}

	@Override
	public void updateProblemAlbum(ProblemAlbum problemAlbum) throws InternalServerException {
		saveOrUpdate(problemAlbum);
	}

	@Override
	public void mergeProblemAlbum(ProblemAlbum problemAlbum) throws InternalServerException {
		merge(problemAlbum);
	}

	@Override
	public List<ProblemAlbum> getAllAlbumsByGuid(Long objectGuid, Integer pageLimit, Integer pageOffset)
			throws InternalServerException {

		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("createdTimeStamp");
		sortCriteria.setIsAscending(false);

		// Restriction on onObjectGuid
		Criterion criteria = Restrictions.eq("problem.guid", objectGuid);

		return getAllByConditionsByPage(criteria, sortCriteria, pageOffset, pageLimit);
	}

}
