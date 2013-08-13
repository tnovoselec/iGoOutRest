package hr.rest.petkovic.igoout.api;

import hr.rest.petkovic.igoout.dao.CommentsDao;
import hr.rest.petkovic.igoout.model.Comment;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/comments")
public class CommentsApi {

	@GET
	@Path("/{eventId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getEvents(@PathParam("eventId") int eventId) {
		return CommentsDao.instance.getComments(eventId);
	}
}
