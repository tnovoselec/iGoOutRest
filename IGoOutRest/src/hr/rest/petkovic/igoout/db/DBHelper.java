package hr.rest.petkovic.igoout.db;

import hr.rest.petkovic.igoout.Constants;
import hr.rest.petkovic.igoout.model.Comment;
import hr.rest.petkovic.igoout.model.Event;
import hr.rest.petkovic.igoout.model.Location;
import hr.rest.petkovic.igoout.model.User;

import java.util.ArrayList;
import java.util.List;

public class DBHelper {

	 private static final String HOST = "62.75.155.123:3306";
	 private static final String PASSWORD = "muka";
//	private static final String HOST = "localhost:3306";
//	private static final String PASSWORD = "";
	private static final String USERNAME = "root";

	private static final String NAME = "igoout";

	private static DBHelper instance;

	private DBHelper() {
	}

	private SimpleMySQL simpleMySql;

	private void init() {
		simpleMySql = SimpleMySQL.getInstance();
		if (!simpleMySql.connect(HOST, USERNAME, PASSWORD, NAME)) {
			throw new IllegalStateException("DB cannot initialize!");
		}
	}

	public static DBHelper getInstance() {
		if (instance == null) {
			instance = new DBHelper();
			instance.init();
		}
		return instance;
	}

	public ArrayList<Location> getAllLocations() {
		String sql = "SELECT * FROM locations";
		ArrayList<Location> locations = new ArrayList<Location>();
		System.out.println(sql);
		SimpleMySQLResult result = simpleMySql.Query(sql);
		while (result.next()) {
			locations.add(Location.getLocationFromResult(result));
		}
		return locations;

	}

	public ArrayList<Location> getFilteredLocations(int[] interests, int[] venues, int radiusId, double lat, double lng) {

		System.out.println(interests + " " + venues + " " + radiusId + " " + lat + " " + lng);

		int radius = Constants.RADIUS.get(radiusId);
		double xFrom = lng - (radius / 111.2) / Math.cos(Math.toRadians(lng));
		double xTo = lng + (radius / 111.2) / Math.cos(Math.toRadians(lng));
		double yFrom = lat - radius / 111.2;
		double yTo = lat + radius / 111.2;
		String inPart = "(";
		for (int i = 0; i < interests.length; i++) {
			inPart += interests[i];
			if (i != interests.length - 1) {
				inPart += ",";
			}
		}
		inPart += ") ";
		String sql = "SELECT * FROM locations  WHERE id IN (SELECT location_id FROM location_interests WHERE interest_id IN "
				+ inPart
				+ ") AND longitude BETWEEN "
				+ xFrom
				+ " AND "
				+ xTo
				+ " AND latitude BETWEEN "
				+ yFrom
				+ " AND " + yTo;
		ArrayList<Location> locations = new ArrayList<Location>();
		System.out.println(sql);
		SimpleMySQLResult result = simpleMySql.Query(sql);
		while (result.next()) {
			locations.add(Location.getLocationFromResult(result));
		}
		return locations;

	}

	public ArrayList<Event> getEventsOnLocation(int locationId) {
		String sql = "SELECT * FROM events WHERE location_id=" + locationId;
		System.out.println(sql);
		ArrayList<Event> events = new ArrayList<Event>();
		SimpleMySQLResult result = simpleMySql.Query(sql);
		while (result.next()) {
			Event event = Event.getEventFromResult(result);
			events.add(event);
		}
		return events;
	}

	public User registerUser(String username, String password) {
		String sql = "SELECT * FROM users WHERE username = '" + username + "'";
		System.out.println(sql);
		SimpleMySQLResult result = simpleMySql.Query(sql);
		if (result.next()) {
			return null;
		} else {
			String sqlCreate = "INSERT INTO users (username, password) VALUES ('" + username + "','" + password + "')";
			simpleMySql.Query(sqlCreate);
			return loginUser(username, password);
		}
	}

	public User loginUser(String username, String password) {
		String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password ='" + password + "'";
		System.out.println(sql);
		SimpleMySQLResult result = simpleMySql.Query(sql);
		if (result.next()) {
			return User.createUserFromResult(result);
		} else {
			return null;
		}
	}

	public int getUserCommentTimes(int eventId, int userId) {
		String sql = "SELECT count(*) as count from comments where event_id = " + eventId + " and user_id=" + userId;
		System.out.println(sql);
		SimpleMySQLResult result = simpleMySql.Query(sql);
		return Integer.valueOf(result.getString("count"));
	}

	public int createComment(int eventId, int userId, String username, String comment) {
		String sql = "INSERT INTO comments( event_id, user_id,date, username, comment) values (" + eventId + ","
				+ userId + ", now() ,'" + username + "','" + comment + "')";
		System.out.println(sql);
		simpleMySql.Query(sql);
		return 0;
	}

	public boolean getUserRatedEvent(int eventId, int userId) {
		String sql = "SELECT * from ratings where event_id = " + eventId + " and user_id=" + userId;
		System.out.println(sql);
		SimpleMySQLResult result = simpleMySql.Query(sql);
		return result.next();
	}

	public int createRating(int eventId, int userId, String username, int rating) {
		String sql = "INSERT INTO ratings( event_id, user_id, username, rating) values (" + eventId + "," + userId
				+ ",'" + username + "'," + rating + ")";
		System.out.println(sql);
		simpleMySql.Query(sql);
		return 0;
	}

	public int[] getInterestsForLocation(int locationId) {
		int[] interests = null;
		String sql = "SELECT interest_id FROM location_interests WHERE location_id = " + locationId;
		System.out.println(sql);
		SimpleMySQLResult result = simpleMySql.Query(sql);
		if (result.next()) {
			interests = new int[result.getNumRows()];
			result.beforeFirst();
			int i = 0;
			while (result.next()) {
				interests[i] = Integer.valueOf(result.getString("interest_id"));
			}
		}
		return interests;

	}

	public int[] getEventsIdOnLocation(int locationId) {
		int[] events = null;
		String sql = "SELECT id FROM events WHERE location_id = " + locationId;
		System.out.println(sql);
		SimpleMySQLResult result = simpleMySql.Query(sql);
		if (result != null && result.next()) {
			events = new int[result.getNumRows()];
			result.beforeFirst();
			int i = 0;
			while (result.next()) {
				events[i] = Integer.valueOf(result.getString("id"));
			}
		}
		return events;
	}

	public List<Comment> getCommentsOnEvent(int eventId) {
		List<Comment> comments = new ArrayList<Comment>();
		String sql = "SELECT * FROM comments WHEHRE event_id =" + eventId;
		System.out.println(sql);
		SimpleMySQLResult result = simpleMySql.Query(sql);
		while (result.next()) {
			Comment c = Comment.getCommentFromResult(result);
			comments.add(c);
		}
		return comments;
	}
}
