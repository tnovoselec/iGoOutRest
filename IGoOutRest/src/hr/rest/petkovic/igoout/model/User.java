package hr.rest.petkovic.igoout.model;

import hr.rest.petkovic.igoout.db.SimpleMySQLResult;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private int id;
	private String username;
	private String password;
	private int[] ratedEvents;
	private int[] commentedEvents;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int[] getRatedEvents() {
		return ratedEvents;
	}

	public void setRatedEvents(int[] ratedEvents) {
		this.ratedEvents = ratedEvents;
	}

	public int[] getCommentedEvents() {
		return commentedEvents;
	}

	public void setCommentedEvents(int[] commentedEvents) {
		this.commentedEvents = commentedEvents;
	}

	public static User createUserFromResult(SimpleMySQLResult result) {
		User user = new User();
		user.setId(Integer.valueOf(result.getString("id")));
		user.setPassword(result.getString("password"));
		user.setUsername(result.getString("username"));
		return user;

	}

}