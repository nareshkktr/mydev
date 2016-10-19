package com.kasisripriyawebapps.myindia.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Service;

@Service
@Provider
public class RecordNotFoundException extends Exception implements ExceptionMapper<RecordNotFoundException> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8321078845007837970L;

	public RecordNotFoundException() {
		super("Record Not Found");
	}

	public RecordNotFoundException(String string) {
		super(string);
	}

	@Override
	public Response toResponse(RecordNotFoundException exception) {
		return Response.status(404).entity(exception.getMessage()).type("text/plain").build();
	}

}
