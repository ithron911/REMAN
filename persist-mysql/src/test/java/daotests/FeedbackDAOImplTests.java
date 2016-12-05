package daotests;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import dao.FeedbackDao;
import dao.ReservationDao;
import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import hu.uni.reman.persist.mysql.FeedbackDAOImpl;
import model.CurrencyType;
import model.Feedback;
import model.FeedbackRating;
import model.Food;
import model.Payment;
import model.Reservation;
import model.Table;
import sqlscripttests.SQLScriptLoadTests;

public class FeedbackDAOImplTests {
	Logger LOGGER = Logger.getLogger(FeedbackDao.class);

	private FeedbackDao feedbackDao;

	/*@Before
	public void setUp() {
		try {
			this.feedbackDao =
					new FeedbackDAOImpl(MYBATIS_CONFIG, HOST, PORT, DATABASE, USER, PASSWORD);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}
	*/

	@Test()
	public void testInsertFeedback() throws InsertFailedException {
		Feedback feedback = createCompleteFeedbackForInsert();
		
		int id = feedbackDao.insertFeedback(feedback);

		LOGGER.info("Insert succesful with ID: " + id);
	}

	@Test
	public void testUpdateFeedback() throws NoResultException, UpdateFailedException {
		Feedback feedback = feedbackDao.getFeedback(1);
		logFeedback(feedback);

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
	public void testGetFeedbackFailed() throws FileNotFoundException, NoResultException {
		feedbackDao.getFeedback(-1);
	}

	@Test
	public void testDeleteFeedback() throws DeleteFailedException {
		feedbackDao.deleteFeedback(10);
	}

	private void logFeedback(Feedback feedback) {
		LOGGER.info("Comment: " + feedback.getOtherComment());
		LOGGER.info("CurrencyType: " + feedback.getDate());
		LOGGER.info("DateBook:" + feedback.getRating());
		LOGGER.info("ID: " + feedback.getId());
	}

	private Feedback createCompleteFeedbackForInsert() {
		Food food = new Food();
		food.setId(1);
		Payment payment = new Payment();
		payment.setId(1);

		return createFeedbackForInsert(food, payment);
	}

	private Feedback createFeedbackForInsert(Food food, Payment payment) {
		Feedback feedback = new Feedback();
		feedback.setId(1);
		feedback.setOtherComment("");
		feedback.setRating(FeedbackRating.BAD);
		feedback.setDate(new Date());

		return feedback;
	}
}
