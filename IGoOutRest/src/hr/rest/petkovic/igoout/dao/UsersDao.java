package hr.rest.petkovic.igoout.dao;

import hr.rest.petkovic.igoout.model.MockData;
import hr.rest.petkovic.igoout.model.User;

public enum UsersDao {
	instance;

	private UsersDao() {
	}

	public User login(String username, String password) {
		return MockData.getUser();
	}
	
	public User register(String username, String password){
		return MockData.getUser();
	}
}
