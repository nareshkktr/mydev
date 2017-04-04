package com.kasisripriyawebapps.myindia.dao;

import com.kasisripriyawebapps.myindia.entity.Comment;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface CommentDao {

	Long saveComment(Comment comment) throws InternalServerException;

}
