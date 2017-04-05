package com.kasisripriyawebapps.myindia.service;

import java.util.List;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.exception.RecordNotFoundException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CommentRequest;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CommentResponse;

public interface CommentService {

	Long postComment(CommentRequest commentRequest) throws InternalServerException;

	List<CommentResponse> getFirstLevelComemnts(Long objectGuid, Integer pageNo, Integer limit) throws InternalServerException, RecordNotFoundException;

}
