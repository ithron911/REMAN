package dao;


import java.util.Collection;

import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import model.Feedback;

public interface FeedbackDao {

	public void insertFeedback(Feedback feedback) throws InsertFailedException;
	
	public void updateFeedback(Feedback feedback) throws  UpdateFailedException;
	
	public Feedback getFeedback(int id) throws NoResultException;
	
	public Collection<Feedback> getAllFeedback() throws NoResultException;
	
	public void deleteFeedback(int id) throws DeleteFailedException;
	
}
