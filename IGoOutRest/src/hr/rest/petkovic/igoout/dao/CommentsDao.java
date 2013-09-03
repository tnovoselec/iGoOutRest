package hr.rest.petkovic.igoout.dao;

import hr.rest.petkovic.igoout.Constants;
import hr.rest.petkovic.igoout.db.DBHelper;
import hr.rest.petkovic.igoout.model.Comment;
import hr.rest.petkovic.igoout.model.MockData;

import java.util.List;

public enum CommentsDao {

	instance;
	private CommentsDao() {
	}

	public List<Comment> getComments(int eventId) {
		return DBHelper.getInstance().getCommentsOnEvent(eventId);
	}

	public int createComment(int eventId, int userId, String username, String comment) {
		int numComments = DBHelper.getInstance().getUserCommentTimes(eventId, userId);
		if (numComments >= Constants.MAX_COMMENTS_PER_USER_PER_EVENT) {
			return Comment.USER_ALREADY_COMMENTED_MAX_TIMES;
		}
		DBHelper.getInstance().createComment(eventId, userId, username, comment);
		return 0;
	}
}
