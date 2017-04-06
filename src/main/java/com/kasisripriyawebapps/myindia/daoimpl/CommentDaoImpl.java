package com.kasisripriyawebapps.myindia.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.CommentDao;
import com.kasisripriyawebapps.myindia.dto.SortCriteriaData;
import com.kasisripriyawebapps.myindia.entity.Comment;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

@Repository
public class CommentDaoImpl extends BaseDaoImpl<Long, Comment> implements CommentDao{

	@Override
	public Long saveComment(Comment comment) throws InternalServerException {
		return save(comment);
	}

	@Override
	public List<Comment> getCommentsByObjectGuid(Long objectGuid, Integer pageNo, Integer limit) throws InternalServerException {
		
		Criterion objectGuidCriterion = Restrictions.eq("objectGuid", objectGuid);
		Criterion firstLevelCommentCriterion = Restrictions.isNull("parentCommentId");
		List<Criterion> criterionList =  new ArrayList<Criterion>();
		
		criterionList.add(objectGuidCriterion);
		criterionList.add(firstLevelCommentCriterion);
		
		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("createdTimeStamp");
		sortCriteria.setIsAscending(true);
		return getAllByConditionsByPage(criterionList,sortCriteria,pageNo,limit);
	}

	@Override
	public List<Comment> getCommentsByObjectGuidAndParentId(Long objectGuid, Long parentCommentId, Integer pageNo,
			Integer limit) throws InternalServerException {
		
		Criterion objectGuidCriterion = Restrictions.eq("objectGuid", objectGuid);
		Criterion secondLevelCommentCriterion = Restrictions.eq("parentCommentId",parentCommentId);
		List<Criterion> criterionList =  new ArrayList<Criterion>();
		
		criterionList.add(objectGuidCriterion);
		criterionList.add(secondLevelCommentCriterion);
		
		SortCriteriaData sortCriteria = new SortCriteriaData();
		sortCriteria.setProperty("createdTimeStamp");
		sortCriteria.setIsAscending(true);
		return getAllByConditionsByPage(criterionList,sortCriteria,pageNo,limit);
	}

}
