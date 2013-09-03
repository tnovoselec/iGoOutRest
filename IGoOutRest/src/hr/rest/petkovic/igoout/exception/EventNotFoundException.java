package hr.rest.petkovic.igoout.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.core.Response.Status.Family;

public class EventNotFoundException extends WebApplicationException {
	
	private static final int EVENT_NOT_FOUND_CODE = 553;
	
	public EventNotFoundException(final String message){
		super(Response.status(new StatusType() {

			@Override
			public int getStatusCode() {
				return EVENT_NOT_FOUND_CODE;
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
