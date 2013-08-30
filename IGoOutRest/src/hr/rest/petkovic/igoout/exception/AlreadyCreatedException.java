package hr.rest.petkovic.igoout.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class AlreadyCreatedException extends WebApplicationException {

	public AlreadyCreatedException(String message) {
		super(Response.status(Response.Status.BAD_REQUEST).entity(message)
				.type(MediaType.APPLICATION_JSON).build());
	}

}
