package hr.rest.petkovic.igoout.dao;

import hr.rest.petkovic.igoout.model.Comment;
import hr.rest.petkovic.igoout.model.MockData;

import java.util.List;

public enum CommentsDao {

	instance;
	private CommentsDao() {
	}

	public List<Comment> getComments(int eventId) {
		return MockData.getComments();
	}
}
