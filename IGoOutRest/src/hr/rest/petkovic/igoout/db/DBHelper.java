package hr.rest.petkovic.igoout.db;

import hr.rest.petkovic.igoout.Constants;
import hr.rest.petkovic.igoout.model.Event;
import hr.rest.petkovic.igoout.model.Location;

import java.util.ArrayList;


public class DBHelper {

	private static final String HOST = "62.75.155.123:3306";
//	private static final String HOST = "localhost:3306";
	private static final String USERNAME = "root";
	private static final String PASSWORD = null;
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
		String sql = "SELECT * FROM LOCATIONS";
		ArrayList<Location> locations = new ArrayList<Location>();
		SimpleMySQLResult result = simpleMySql.Query(sql);
		while (result.next()) {
			locations.add(Location.getLocationFromResult(result));
		}
		return locations;

	}
	
	public ArrayList<Location> getFilteredLocations(int[] interests, int[] venues, int radiusId, double lat, double lng) {
		int radius = Constants.RADIUS.get(radiusId);
		double xFrom = lng - (radius / 111.2) / Math.cos(Math.toRadians(lng));
		double xTo = lng + (radius / 111.2) / Math.cos(Math.toRadians(lng));
		double yFrom = lat - radius / 111.2;
		double yTo = lat + radius / 111.2;
		String inPart = "(";
		for (int i = 0; i<interests.length;i++){
			inPart+=interests[i];
			if (i != interests.length -1){
				inPart+=",";
			}
		}
		inPart+=") ";
		String sql = "SELECT * FROM LOCATIONS  WHERE id IN (SELECT LOCATION_ID FROM LOCATION_INTERESTS WHERE INTEREST_ID IN " + inPart + ") AND LONGITUDE BETWEEN " + xFrom + " AND " + xTo + " AND LATITUDE BETWEEN " + yFrom + " AND " + yTo;
		ArrayList<Location> locations = new ArrayList<Location>();
		SimpleMySQLResult result = simpleMySql.Query(sql);
		while (result.next()) {
			locations.add(Location.getLocationFromResult(result));
		}
		return locations;

	}

	public ArrayList<Event> getEventsOnLocation(int locationId) {
		String sql = "SELECT * FROM EVENTS WHERE location_id=" + locationId;
		ArrayList<Event> events = new ArrayList<Event>();
		SimpleMySQLResult result = simpleMySql.Query(sql);
		while (result.next()) {
			Event event = Event.getEventFromResult(result);
			events.add(event);
		}
		return events;
	}
}
