package hr.rest.petkovic.igoout.dao;

import hr.rest.petkovic.igoout.db.DBHelper;
import hr.rest.petkovic.igoout.model.Rating;

public enum RatingsDao {
	instance;

	private RatingsDao() {
	}

	public int createRating(int eventId, int userId, String username, int rating) {
		boolean alreadyRated = DBHelper.getInstance().getUserRatedEvent(eventId, userId);
		if (alreadyRated) {
			return Rating.USER_ALREADY_RATED_EVENT;
		} else {
			DBHelper.getInstance().createRating(eventId, userId, username, rating);
			return 0;
		}
	}
}
