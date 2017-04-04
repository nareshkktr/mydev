package com.kasisripriyawebapps.myindia.service;

import com.kasisripriyawebapps.myindia.exception.InternalServerException;
import com.kasisripriyawebapps.myindia.requestresponsemodel.CommentRequest;

public interface CommentService {

	Long postComment(CommentRequest commentRequest) throws InternalServerException;

}
