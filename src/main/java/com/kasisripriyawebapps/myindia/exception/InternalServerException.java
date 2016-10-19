package com.kasisripriyawebapps.myindia.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

@Service
@Provider
public class InternalServerException extends Exception implements ExceptionMapper<InternalServerException> {

	private static final long serialVersionUID = 8321078845007837970L;

	public InternalServerException() {
		super("Internal Server Error");
	}

	public InternalServerException(String string) {
		super(string);
	}

	@Override
	public Response toResponse(InternalServerException exception) {
		return Response.status(500).entity(exception.getMessage()).type("text/plain").build();
	}
}
