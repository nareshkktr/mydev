package com.kasisripriyawebapps.myindia.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.dao.CommentDao;
import com.kasisripriyawebapps.myindia.entity.Comment;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CommentRequest;
import com.kasisripriyawebapps.myindia.service.CommentService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	CommentDao commentDao;

	@Override
	@Transactional
	public Long postComment(CommentRequest commentRequest) throws InternalServerException {
		
		Comment comment = preapreCommentObject(commentRequest);
		
		Long commentGuid = null;
		
		commentGuid = commentDao.saveComment(comment);
		
		return commentGuid;
	}

	private Comment preapreCommentObject(CommentRequest commentRequest) {
		
		Comment comment = new Comment();
		
		comment.setObjectGuid(commentRequest.getObjectGuid());
		comment.setObjectType(commentRequest.getObjectType());
		comment.setCommentorObjectGuid(commentRequest.getCommentorObjectGuid());
		comment.setCommentorObjectType(commentRequest.getCommentorObjectType());
		
		if(commentRequest.getCommentType().equalsIgnoreCase(ApplicationConstants.COMMENT_TEXT))
			comment.setCommentText(commentRequest.getCommentText());
		
		comment.setParentCommentId(commentRequest.getParentCommentId());
		
		comment.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
		
		return comment;
	}

}
