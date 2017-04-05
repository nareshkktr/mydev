package com.kasisripriyawebapps.myindia.dao;

import java.util.List;

import com.kasisripriyawebapps.myindia.entity.Comment;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;

public interface CommentDao {

	Long saveComment(Comment comment) throws InternalServerException;

	List<Comment> getCommentsByObjectGuid(Long objectGuid, Integer pageNo, Integer limit) throws InternalServerException;

}
