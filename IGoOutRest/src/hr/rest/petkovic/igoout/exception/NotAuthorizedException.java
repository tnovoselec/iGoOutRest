package hr.rest.petkovic.igoout.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class NotAuthorizedException extends WebApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8684117134693402160L;

	public NotAuthorizedException(String message) {
		super(Response.status(Response.Status.UNAUTHORIZED).entity(message)
				.type(MediaType.APPLICATION_JSON).build());
	}

}
