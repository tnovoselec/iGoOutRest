package hr.rest.petkovic.igoout.dao;

import hr.rest.petkovic.igoout.model.Location;
import hr.rest.petkovic.igoout.model.MockData;

import java.util.List;

public enum LocationsDao {

	instance;

	private LocationsDao() {
	}

	public List<Location> getLocations(int[] interests, int[] venues, int radiusId) {
		return MockData.getLocations();
	}

}
