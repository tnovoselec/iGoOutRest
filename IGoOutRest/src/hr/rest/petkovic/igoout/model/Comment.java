package hr.rest.petkovic.igoout.model;

import hr.rest.petkovic.igoout.db.SimpleMySQLResult;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {

	public static final int USER_ALREADY_COMMENTED_MAX_TIMES = 1;
	public static final int EVENT_NOT_FOUND = 2;
	
	private int id;
	private int eventId;
	private int userId;
	private String username;
	private String date;
	private String comment;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public static Comment getCommentFromResult(SimpleMySQLResult result) {
		Comment c = new Comment();
		c.setComment(result.getString("comment"));
		c.setDate(result.getString("date"));
		c.setEventId(Integer.valueOf(result.getString("event_id")));
		c.setId(Integer.valueOf(result.getString("id")));
		c.setUserId(Integer.valueOf(result.getString("user_id")));
		c.setUsername(result.getString("username"));
		return c;
	}
}
