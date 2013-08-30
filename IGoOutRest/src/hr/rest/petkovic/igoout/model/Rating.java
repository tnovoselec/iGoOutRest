package hr.rest.petkovic.igoout.model;

import hr.rest.petkovic.igoout.db.SimpleMySQLResult;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rating {

	public static final int USER_ALREADY_RATED_EVENT = 1;
	private int id;
	private int eventId;
	private int userId;
	private String username;
	private float rating;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public static Rating getRatingFromResult(SimpleMySQLResult result) {
		Rating r = new Rating();
		r.setEventId(Integer.valueOf(result.getString("event_id")));
		r.setId(Integer.valueOf(result.getString("id")));
		r.setRating(Float.valueOf(result.getString("rating")));
		r.setUserId(Integer.valueOf(result.getString("user_id")));
		r.setUsername(result.getString("username"));
		return r;
	}
}
