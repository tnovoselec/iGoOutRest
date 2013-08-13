package hr.rest.petkovic.igoout.api;

import hr.rest.petkovic.igoout.dao.EventsDao;
import hr.rest.petkovic.igoout.model.Event;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/events")
public class EventsApi {

	@GET
	@Path("/{locationId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Event> getEvents(@PathParam("locationId") int locationId) {
		return EventsDao.instance.getEvents(locationId);
	}

}
