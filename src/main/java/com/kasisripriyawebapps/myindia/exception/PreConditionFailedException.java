package com.kasisripriyawebapps.myindia.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

@Service
@Provider
public class PreConditionFailedException extends Exception implements ExceptionMapper<PreConditionFailedException> {

	private static final long serialVersionUID = 8321078845007837970L;

	public PreConditionFailedException() {
		super("Filed Condition Failed");
	}

	public PreConditionFailedException(String string) {
		super(string);
	}

	@Override
	public Response toResponse(PreConditionFailedException exception) {
		return Response.status(412).entity(exception.getMessage()).type("text/plain").build();
	}

}
