package hr.rest.petkovic.igoout.dao;

import hr.rest.petkovic.igoout.db.DBHelper;
import hr.rest.petkovic.igoout.model.User;

public enum UsersDao {
	instance;

	private UsersDao() {
	}

	public User login(String username, String password) {
		return DBHelper.getInstance().loginUser(username, password);
	}

	public User register(String username, String password) {
		return DBHelper.getInstance().registerUser(username, password);
	}
}
