package com.kasisripriyawebapps.myindia.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

@Service
@Provider
public class ConflictException extends Exception implements ExceptionMapper<ConflictException> {

	private static final long serialVersionUID = 8321078845007837970L;

	public ConflictException() {
		super("Internal Server Error");
	}

	public ConflictException(String string) {
		super(string);
	}

	@Override
	public Response toResponse(ConflictException exception) {
		return Response.status(409).entity(exception.getMessage()).type("text/plain").build();
	}

}
