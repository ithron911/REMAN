package daotests;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import dao.ReservationDao;
import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import hu.uni.reman.persist.mysql.ReservationDAOImpl;
import model.CurrencyType;
import model.Payment;
import model.Reservation;
import model.Table;
import sqlscripttests.SQLScriptLoadTests;

public class ReservationDaoImplTests extends SQLScriptLoadTests {

	Logger LOGGER = Logger.getLogger(ReservationDaoImplTests.class);

	private ReservationDao reservationDao;

	@Before
	public void setUp() {
		super.setUp();
		try {
			this.reservationDao =
					new ReservationDAOImpl(MYBATIS_CONFIG, HOST, PORT, DATABASE, USER, PASSWORD, CONNECTION_URL);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	@Test
	public void testInsertReservation() throws InsertFailedException {
		Reservation reservation = createCompleteReservationForInsert();
		
		reservationDao.insertReservation(reservation);

	}

	@Test(expected = InsertFailedException.class)
	public void testInsertReservationFail() throws InsertFailedException {
		Reservation reservation = createCompleteReservationForInsert();
		reservation.setId(1);
		
		reservationDao.insertReservation(reservation);

	}

	@Test
	public void testUpdateReservation() throws NoResultException, UpdateFailedException {
		Reservation reservation = reservationDao.getReservation(1);
		logReservation(reservation);

		reservation.setComment("Test changed comment!");

		reservationDao.updateReservation(reservation);
	}

	@Test(expected = UpdateFailedException.class)
	public void testUpdateReservationFail() throws NoResultException, UpdateFailedException {
		Reservation reservation = reservationDao.getReservation(1);
		logReservation(reservation);
		reservation.setId(0);

		reservation.setComment("Test changed comment!");

		reservationDao.updateReservation(reservation);
	}

	@Test
	public void testGetReservation() throws FileNotFoundException, NoResultException {
		Reservation reservation = reservationDao.getReservation(1);
		Assume.assumeNotNull(reservation);

		LOGGER.info("getReservation with ID: " + 1);
		logReservation(reservation);
	}

	@Test(expected = NoResultException.class)
	public void testGetReservationFail() throws FileNotFoundException, NoResultException {
		reservationDao.getReservation(-1);
	}


	@Test
	public void testGetAllReservation() throws NoResultException {
		Collection<Reservation> reservations= reservationDao.getAllReservation();

		Assume.assumeTrue(reservations.size() == 10);
		LOGGER.info("All reservations:");
		for (Reservation reservation : reservations) {
			LOGGER.info("Reservation:");
			logReservation(reservation);
		}
	}

	@Test
	public void testDeleteReservation() throws DeleteFailedException {
		reservationDao.deleteReservation(10);
	}

	@Test(expected = DeleteFailedException.class)
	public void testDeleteReservationFailed() throws DeleteFailedException {
		reservationDao.deleteReservation(-1);
	}

	private void logReservation(Reservation reservation) {
		LOGGER.info("Comment: " + reservation.getComment());
		LOGGER.info("CurrencyType: " + reservation.getCurrencyType());
		LOGGER.info("DateBook:" + reservation.getDateBook());
		LOGGER.info("ID: " + reservation.getId());
		LOGGER.info("PaymentID: " + reservation.getPayment().getId());
		LOGGER.info("PaymentType: " + reservation.getPayment().getPaymentType());
		LOGGER.info("Price: " + reservation.getPrice());
		LOGGER.info("RestaurantName" + reservation.getRestaurantName());

		LOGGER.info("Tables");
		for (Table table : reservation.getTables()) {
			LOGGER.info("TableID: " + table.getId());
			LOGGER.info("TableType: " + table.getTableType());
		}
	}

	private Reservation createCompleteReservationForInsert() {
		Payment payment = new Payment();
		payment.setId(1);

		return createReservationForInsert(payment);
	}

	private Reservation createReservationForInsert(Payment payment) {
		Reservation reservation = new Reservation();
		reservation.setComment("");
		reservation.setCurrency(CurrencyType.EUR);
		reservation.setDateBook(new Date());
		reservation.setPayment(payment);
		reservation.setPrice(10000);
		reservation.setRestaurant("Alephant");

		return reservation;
	}
}
