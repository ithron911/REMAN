package dao;


import java.util.List;

import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import model.Feedback;

public interface FeedbackDao {

	public void insertFeedback() throws InsertFailedException;
	
	public void updateFeedback(Feedback feedback) throws  UpdateFailedException;
	
	public List<Feedback> getAllFeedbacks() throws NoResultException;
	
	public void deleteFeedback(Feedback feedback) throws DeleteFailedException;
	
}
