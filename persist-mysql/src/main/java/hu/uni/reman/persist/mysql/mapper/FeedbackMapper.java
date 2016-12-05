package hu.uni.reman.persist.mysql.mapper;

import model.Feedback;

public interface FeedbackMapper {

	void insertFeedback(Feedback feedback);
	void updateFeedback(Feedback feedback);
	Feedback getFeedback(int id);
	void deleteFeedback(int id);
}
