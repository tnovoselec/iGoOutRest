package hr.rest.petkovic.igoout.dao;

import hr.rest.petkovic.igoout.db.DBHelper;
import hr.rest.petkovic.igoout.model.Location;

import java.util.List;

public enum LocationsDao {

	instance;

	private LocationsDao() {
	}

	public List<Location> getLocations(int[] interests, int[] venues, int radiusId, double lat, double lng) {
		List<Location> locations = DBHelper.getInstance().getFilteredLocations(interests, venues, radiusId, lat, lng);
		for (Location l : locations) {
			l.setInterests(DBHelper.getInstance().getInterestsForLocation(l.getId()));
			l.setEvents(DBHelper.getInstance().getEventsIdOnLocation(l.getId()));
		}
		return locations;
	}

	public List<Location> getAllLocations() {
		return DBHelper.getInstance().getAllLocations();
	}

}
