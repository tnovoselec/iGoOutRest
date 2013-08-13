package hr.rest.petkovic.igoout.dao;

import hr.rest.petkovic.igoout.model.Event;
import hr.rest.petkovic.igoout.model.MockData;

import java.util.List;

public enum EventsDao {
	instance;

	private EventsDao() {
	}

	public List<Event> getEvents(int locationId) {
		return MockData.getEvents();
	}
}
