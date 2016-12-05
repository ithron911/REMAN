package daotests;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import dao.RestaurantDao;
import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import hu.uni.reman.persist.mysql.RestaurantDAOImpl;
import model.Restaurant;
import model.RestaurantType;
import sqlscripttests.SQLScriptLoadTests;

public class RestaurantDAOImplTests extends SQLScriptLoadTests {

	Logger LOGGER = Logger.getLogger(RestaurantDAOImplTests.class);

	private RestaurantDao RestaurantDao;

	@Before
	public void setUp() {
		super.setUp();
		try {
			this.RestaurantDao = new RestaurantDAOImpl(MYBATIS_CONFIG, HOST, PORT, DATABASE, USER, PASSWORD,
					CONNECTION_URL);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	@Test
	public void testInsertRestaurant() throws InsertFailedException {
		Restaurant Restaurant = createCompleteRestaurantForInsert();

		RestaurantDao.insertRestaurant(Restaurant);

	}

	@Test(expected = InsertFailedException.class)
	public void testInsertRestaurantFail() throws InsertFailedException {
		Restaurant Restaurant = createCompleteRestaurantForInsert();
		Restaurant.setName("Teszt");

		RestaurantDao.insertRestaurant(Restaurant);

	}

	@Test
	public void testUpdateRestaurant() throws NoResultException, UpdateFailedException {
		Restaurant Restaurant = RestaurantDao.getRestaurant("Teszt");
		logRestaurant(Restaurant);

		RestaurantDao.updateRestaurant(Restaurant);
	}

	@Test(expected = UpdateFailedException.class)
	public void testUpdateRestaurantFail() throws NoResultException, UpdateFailedException {
		Restaurant Restaurant = RestaurantDao.getRestaurant("Teszt0");
		logRestaurant(Restaurant);
		Restaurant.setName("Teszt0");

		RestaurantDao.updateRestaurant(Restaurant);
	}

	@Test
	public void testGetRestaurant() throws FileNotFoundException, NoResultException {
		Restaurant Restaurant = RestaurantDao.getRestaurant("Teszt");
		Assume.assumeNotNull(Restaurant);

		LOGGER.info("getRestaurant with NAME: Teszt");
		logRestaurant(Restaurant);
	}

	@Test(expected = NoResultException.class)
	public void testGetRestaurantFail() throws FileNotFoundException, NoResultException {
		RestaurantDao.getRestaurant("Teszt0");
	}

	@Test
	public void testGetAllRestaurant() throws NoResultException {
		Collection<Restaurant> Restaurants = RestaurantDao.getAllRestaurants();

		Assume.assumeTrue(Restaurants.size() == 10);
		LOGGER.info("All Restaurants:");
		for (Restaurant Restaurant : Restaurants) {
			LOGGER.info("Restaurant:");
			logRestaurant(Restaurant);
		}
	}

	@Test
	public void testDeleteRestaurant() throws DeleteFailedException {
		RestaurantDao.deleteRestaurant("Teszt");
	}

	@Test(expected = DeleteFailedException.class)
	public void testDeleteRestaurantFailed() throws DeleteFailedException {
		RestaurantDao.deleteRestaurant("Teszt0");
	}

	private void logRestaurant(Restaurant Restaurant) {
		LOGGER.info("Name: " + Restaurant.getName());
		LOGGER.info("Founding: " + Restaurant.getFounding());
		LOGGER.info("Type:" + Restaurant.getType().getResturantType());

	}
	
	private Restaurant createCompleteRestaurantForInsert() {
		RestaurantType type = RestaurantType.PIZZERIA;
		
		return createRestaurantForInsert(type);
	}

	private Restaurant createRestaurantForInsert(RestaurantType type) {
		Restaurant Restaurant = new Restaurant();
		Restaurant.setName("ASD");
		Restaurant.setFounding(new Date());
		Restaurant.setType(type);

		return Restaurant;
	}
}
