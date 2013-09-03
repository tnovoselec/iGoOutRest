package hr.rest.petkovic.igoout.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.core.Response.Status.Family;

public class AlreadyRatedException extends WebApplicationException {

	private static final int ALREADY_RATED = 552;

	public AlreadyRatedException(final String message) {
		super(Response.status(new StatusType() {

			@Override
			public int getStatusCode() {
				return ALREADY_RATED;
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
