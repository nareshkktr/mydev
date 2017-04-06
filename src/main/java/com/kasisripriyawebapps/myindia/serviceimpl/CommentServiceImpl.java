package com.kasisripriyawebapps.myindia.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kasisripriyawebapps.myindia.constants.ApplicationConstants;
import com.kasisripriyawebapps.myindia.dao.CommentDao;
import com.kasisripriyawebapps.myindia.entity.Comment;
import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.ActivityRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.BaseUserInformation;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CommentRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CommentResponse;
import com.kasisripriyawebapps.myindia.service.AccountService;
import com.kasisripriyawebapps.myindia.service.ActivityService;
import com.kasisripriyawebapps.myindia.service.CommentService;
import com.kasisripriyawebapps.myindia.util.CommonUtil;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentDao;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	ActivityService activityService;

	@Override
	@Transactional
	public Long postComment(CommentRequest commentRequest) throws InternalServerException {

		Comment comment = preapreCommentObject(commentRequest);
		Long commentGuid = commentDao.saveComment(comment);
		
		comment.setGuid(commentGuid);
		ActivityRequest activityReq = preapreActivityRequest(comment);
		
		//Save For Activity Feed
		activityService.saveActivity(activityReq);
		
		return commentGuid;
	}

	private ActivityRequest preapreActivityRequest(Comment comment) {
		
		ActivityRequest activityRequest = new ActivityRequest();
		
		activityRequest.setActivityContent(comment.getCommentText());
		
		if(comment.getParentCommentId() != null){
			activityRequest.setActivityName(ApplicationConstants.COMMENT_REPLIED);
			//Commented upon
			activityRequest.setOfObjectGuid(comment.getParentCommentId());
			activityRequest.setOfObjectType(ApplicationConstants.OBJECT_TYPE_COMMENT);
		}else
			activityRequest.setActivityName(ApplicationConstants.COMMENTED);
		
		//Comment
		activityRequest.setActivityObjectGuid(comment.getGuid());
		activityRequest.setActivityObjectType(ApplicationConstants.OBJECT_TYPE_COMMENT);
		
		//Commented on
		activityRequest.setOnObjectGuid(comment.getObjectGuid());
		activityRequest.setOnObjectType(comment.getObjectType());
		
		//Commented By
		activityRequest.setCreatedBy(comment.getCommentorObjectGuid());
		activityRequest.setCreatedTimeStamp(comment.getCreatedTimeStamp());
		
		return activityRequest;
	}

	private Comment preapreCommentObject(CommentRequest commentRequest) {

		Comment comment = new Comment();

		comment.setObjectGuid(commentRequest.getObjectGuid());
		comment.setObjectType(commentRequest.getObjectType());
		comment.setCommentorObjectGuid(commentRequest.getCommentorObjectGuid());
		comment.setCommentorObjectType(commentRequest.getCommentorObjectType());
		
		comment.setCommentType(commentRequest.getCommentType());
		
		if(commentRequest.getCommentType().equalsIgnoreCase(ApplicationConstants.COMMENT_TEXT))
			comment.setCommentText(commentRequest.getCommentText());
		
		if(commentRequest.getParentCommentId() != null){
			comment.setParentCommentId(commentRequest.getParentCommentId());
		}
		
		comment.setReplyCount(0);
		
		comment.setCreatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
		comment.setUpdatedTimeStamp(CommonUtil.getCurrentGMTTimestamp());
		
		return comment;
	}

	@Override
	@Transactional
	public List<CommentResponse> getFirstLevelComemnts(Long objectGuid, Integer pageNo, Integer limit)
			throws InternalServerException, RecordNotFoundException {
		List<Comment> comments = commentDao.getCommentsByObjectGuid(objectGuid,pageNo,limit);
		List<CommentResponse> commentsResponse = preapreCommentsResponse(comments);
		return commentsResponse;
	}

	private List<CommentResponse> preapreCommentsResponse(List<Comment> comments) throws InternalServerException, RecordNotFoundException {
		
		List<CommentResponse> commentorsResponse = new ArrayList<CommentResponse>();
		
		//Get list of commentor ids
		Set<Long> commentorGuids = comments.stream().collect(Collectors.groupingBy(commentObj->commentObj.getCommentorObjectGuid())).keySet();
		
		List<BaseUserInformation> commentors = new ArrayList<BaseUserInformation>();
		
		if(commentorGuids != null &&!commentorGuids.isEmpty())
			commentors = accountService.getAccountsByIds(commentorGuids);
		
		Map<Object, List<BaseUserInformation>> commentorsMap = commentors.stream().collect(Collectors.groupingBy(commentorObj->commentorObj.getAccountGuid()));
		
		for(Comment comment: comments){
			CommentResponse commentResponse = new CommentResponse();
			
			commentResponse.setCommentType(comment.getCommentType());
			
			if(commentResponse.getCommentType() != null && commentResponse.getCommentType().equalsIgnoreCase(ApplicationConstants.COMMENT_TEXT)){
				commentResponse.setCommentText(comment.getCommentText());
			}
			
			if(commentorsMap.get(comment.getCommentorObjectGuid()) != null && commentorsMap.get(comment.getCommentorObjectGuid()).size() >0 ){
				commentResponse.setCommentor(commentorsMap.get(comment.getCommentorObjectGuid()).get(0));
			}
			
			commentResponse.setCreatedTimeStamp(comment.getCreatedTimeStamp());
			commentResponse.setUpdatedTimeStamp(comment.getUpdatedTimeStamp());
			commentResponse.setGuid(comment.getGuid());
			commentResponse.setObjectGuid(comment.getObjectGuid());
			commentResponse.setObjectType(comment.getObjectType());
			commentResponse.setReplyCount(comment.getReplyCount());
			commentResponse.setParentCommentId(comment.getParentCommentId());
			
			commentorsResponse.add(commentResponse);
		}
		
		return commentorsResponse;
	}

}
