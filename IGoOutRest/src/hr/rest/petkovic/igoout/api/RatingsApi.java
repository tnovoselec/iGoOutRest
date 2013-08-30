package hr.rest.petkovic.igoout.api;

import hr.rest.petkovic.igoout.dao.CommentsDao;
import hr.rest.petkovic.igoout.dao.RatingsDao;
import hr.rest.petkovic.igoout.exception.EventNotFoundException;
import hr.rest.petkovic.igoout.exception.InvalidRequestException;
import hr.rest.petkovic.igoout.exception.MaxCommentsPerEventException;
import hr.rest.petkovic.igoout.model.Comment;
import hr.rest.petkovic.igoout.model.Rating;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONObject;

@Path("/ratings")
public class RatingsApi {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject setRatingOnEvent(JSONObject json) {
		int eventId = json.optInt("event_id", -1);
		int userId = json.optInt("user_id", -1);
		String username = json.optString("username");
		int rating = json.optInt("rating", -1);
		if (isRatingRequestValid(eventId, userId, username, rating)) {
			int status = RatingsDao.instance.createRating(eventId, userId, username, rating);
			if (status == Rating.USER_ALREADY_RATED_EVENT) {
				throw new MaxCommentsPerEventException("User alredy commented 3 times on that event");
			} else if (status == Comment.EVENT_NOT_FOUND) {
				throw new EventNotFoundException("Event not found");
			} else {
				return new JSONObject();
			}
		} else {
			throw new InvalidRequestException("Request parameter missing");
		}
	}

	private boolean isRatingRequestValid(int eventId, int userId, String username, int rating) {
		if (eventId == -1 || userId == -1 || username == null || rating < 1 || rating > 5) {
			return false;
		}
		return true;
	}

}
