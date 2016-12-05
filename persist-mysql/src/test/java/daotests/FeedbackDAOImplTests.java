package daotests;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import dao.FeedbackDao;
import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import hu.uni.reman.persist.mysql.FeedbackDAOImpl;
import model.Feedback;
import model.FeedbackRating;
import sqlscripttests.SQLScriptLoadTests;

public class FeedbackDAOImplTests extends SQLScriptLoadTests {
	
	Logger LOGGER = Logger.getLogger(FeedbackDAOImplTests.class);
	
	private FeedbackDao feedbackDao;
	
	@Before
	public void setUp() {
		super.setUp();
		try {
			this.feedbackDao = new FeedbackDAOImpl(MYBATIS_CONFIG, HOST, PORT, DATABASE, USER, PASSWORD, CONNECTION_URL);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testInsertFeedback() throws InsertFailedException {
		Feedback feedback = createFeedbackForInsert();
		
		feedbackDao.insertFeedback(feedback);
	}
	
	
	@Test(expected = InsertFailedException.class)
	public void testInsertFeedbackFail() throws InsertFailedException {
		Feedback feedback = createFeedbackForInsert();
		feedback.setId(1);
		
		feedbackDao.insertFeedback(feedback);
	}
	
	@Test
	public void testUpdateFeedback() throws NoResultException, UpdateFailedException {
		Feedback feedback = feedbackDao.getFeedback(1);
		logFeedback(feedback);
		
		feedback.setOtherComment("Test changed comment!");
		
		feedbackDao.updateFeedback(feedback);
	}
	
	//windows...
	@Test(expected = UpdateFailedException.class)
	public void testUpdateFeedbackFail() throws NoResultException, UpdateFailedException {
		Feedback feedback = feedbackDao.getFeedback(1);
		logFeedback(feedback);
		feedback.setId(0);
		
		feedback.setOtherComment("Test changed comment!");
		
		feedbackDao.updateFeedback(feedback);
	}
	
	@Test
	public void testGetFeedback() throws FileNotFoundException, NoResultException {
		Feedback feedback = feedbackDao.getFeedback(1);
		Assume.assumeNotNull(feedback);
		
		LOGGER.info("getFeedback with ID: " + 1);
		logFeedback(feedback);
	}
	
	@Test(expected = NoResultException.class)
	public void testGetFeedbackFail() throws FileNotFoundException, NoResultException {
		feedbackDao.getFeedback(-1);
	}
	
	@Test
	public void testGetAllFeedback() throws NoResultException {
		Collection<Feedback> feedbacks = feedbackDao.getAllFeedback();
		
		Assume.assumeTrue(feedbacks.size() == 5);
		LOGGER.info("All feedbacks");
		for(Feedback feedback : feedbacks) {
			LOGGER.info("Feedback:");
			logFeedback(feedback);
		}
	}
	
	@Test
	public void testDeleteFeedback() throws DeleteFailedException {
		feedbackDao.deleteFeedback(2);
	}
	
	//windows...
	@Test(expected = DeleteFailedException.class)
	public void testDeleteFeedbackFail() throws DeleteFailedException {
		feedbackDao.deleteFeedback(-1);
	}
	
	private void logFeedback(Feedback feedback) {
		LOGGER.info("ID: " + feedback.getId());
		LOGGER.info("FeedbackRating: " + feedback.getRating());
		LOGGER.info("Date: " + feedback.getDate());
		LOGGER.info("Comment: " + feedback.getOtherComment());
	}
	
	private Feedback createFeedbackForInsert() {
		Feedback feedback = new Feedback();
		feedback.setRating(FeedbackRating.GOOD);
		feedback.setDate(new Date());
		feedback.setOtherComment("");
		
		return feedback;
	}
}
