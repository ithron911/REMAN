package dao;


import java.util.List;

import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import model.Feedback;

public interface FeedbackDao {

	public int insertFeedback(Feedback feedback) throws InsertFailedException;
	
	public void updateFeedback(Feedback feedback) throws  UpdateFailedException;
	
	public Feedback getFeedback(int i) throws NoResultException;
	
	public List<Feedback> getAllFeedbacks() throws NoResultException;
	
	public void deleteFeedback(int i) throws DeleteFailedException;
	
}
