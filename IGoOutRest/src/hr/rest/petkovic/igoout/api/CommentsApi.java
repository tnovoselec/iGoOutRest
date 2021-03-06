package hr.rest.petkovic.igoout.api;

import hr.rest.petkovic.igoout.dao.CommentsDao;
import hr.rest.petkovic.igoout.exception.EventNotFoundException;
import hr.rest.petkovic.igoout.exception.InvalidRequestException;
import hr.rest.petkovic.igoout.exception.MaxCommentsPerEventException;
import hr.rest.petkovic.igoout.model.Comment;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;

@Path("/comments")
public class CommentsApi {

	@GET
	@Path("/{eventId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getCommentsOnEvent(@PathParam("eventId") int eventId) {
		return CommentsDao.instance.getComments(eventId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject setCommentOnEvent(JSONObject json) {
		int eventId = json.optInt("event_id", -1);
		int userId = json.optInt("user_id", -1);
		String username = json.optString("username");
		String comment = json.optString("comment");
		if (isCommentRequestValid(eventId, userId, username, comment)) {
			int status = CommentsDao.instance.createComment(eventId, userId, username, comment);
			if (status == Comment.USER_ALREADY_COMMENTED_MAX_TIMES) {
				throw new MaxCommentsPerEventException("User alredy commented 3 times on that event");
			} else if (status == Comment.EVENT_NOT_FOUND) {
				throw new EventNotFoundException("Event not found");
			} else {
				return new JSONObject();
			}
		}else{
			throw new InvalidRequestException("Request parameter missing");
		}
	}

	private boolean isCommentRequestValid(int eventId, int userId, String username, String comment) {
		if (eventId == -1 || userId == -1 || username == null || comment == null) {
			return false;
		}
		return true;
	}
}
