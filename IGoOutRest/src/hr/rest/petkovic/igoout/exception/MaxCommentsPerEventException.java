package hr.rest.petkovic.igoout.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.core.Response.StatusType;

public class MaxCommentsPerEventException extends WebApplicationException {

	private static final int MAX_COMMENTS_PER_USER_PER_EVENT_CODE = 1413;

	public MaxCommentsPerEventException(final String message) {
		super(Response.status(new StatusType() {

			@Override
			public int getStatusCode() {
				return MAX_COMMENTS_PER_USER_PER_EVENT_CODE;
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
