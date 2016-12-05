package hu.uni.reman.persist.mysql.mapper;

import java.util.Collection;

import model.Feedback;

public interface FeedbackMapper {

	void insertFeedback(Feedback feedback);
	void updateFeedback(Feedback feedback);
	Feedback getFeedback(int id);
	Collection<Feedback> getAllFeedbacks();
	void deleteFeedback(int id);
}
