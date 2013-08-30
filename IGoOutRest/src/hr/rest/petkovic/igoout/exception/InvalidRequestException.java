package hr.rest.petkovic.igoout.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.core.Response.Status.Family;

public class InvalidRequestException extends WebApplicationException{
	
	private static final int INVALID_REQUEST = 1415;
	
	public InvalidRequestException(final String message){
		super(Response.status(new StatusType() {

			@Override
			public int getStatusCode() {
				return INVALID_REQUEST;
			}

			@Override
			public String getReasonPhrase() {
				return message;
			}

			@Override
			public Family getFamily() {
				return Family.CLIENT_ERROR;
			}
		}).entity(message).type(MediaType.APPLICATION_JSON).build());
	}

}
