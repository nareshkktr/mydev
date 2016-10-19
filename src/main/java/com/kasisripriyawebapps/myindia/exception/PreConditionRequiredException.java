package com.kasisripriyawebapps.myindia.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

@Service
@Provider
public class PreConditionRequiredException extends Exception implements ExceptionMapper<PreConditionRequiredException> {

	private static final long serialVersionUID = 8321078845007837970L;

	public PreConditionRequiredException() {
		super("Filed Required");
	}

	public PreConditionRequiredException(String string) {
		super(string);
	}

	@Override
	public Response toResponse(PreConditionRequiredException exception) {
		return Response.status(428).entity(exception.getMessage()).type("text/plain").build();
	}

}
