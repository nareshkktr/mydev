package com.kasisripriyawebapps.myindia.daoimpl;

import org.springframework.stereotype.Repository;

import com.kasisripriyawebapps.myindia.dao.CommentDao;
import com.kasisripriyawebapps.myindia.entity.Comment;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

@Repository
public class CommentDaoImpl extends BaseDaoImpl<Long, Comment> implements CommentDao{

	@Override
	public Long saveComment(Comment comment) throws InternalServerException {
		return save(comment);
	}

}
