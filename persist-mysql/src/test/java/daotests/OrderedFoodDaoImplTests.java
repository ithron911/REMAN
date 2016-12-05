package daotests;

import static org.junit.Assert.fail;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import dao.OrderedFoodDao;
import hu.uni.reman.persist.mysql.OrderedFoodDaoImpl;
import model.OrderedFood;
import sqlscripttests.SQLScriptLoadTests;

public class OrderedFoodDaoImplTests extends SQLScriptLoadTests {

	Logger LOGGER = Logger.getLogger(OrderedFoodDaoImplTests.class);

	private OrderedFoodDao orderedFoodDao;

	@Before
	public void setUp() {
		super.setUp();
		try {
			this.orderedFoodDao =
					new OrderedFoodDaoImpl(MYBATIS_CONFIG, HOST, PORT, DATABASE, USER, PASSWORD, CONNECTION_URL);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	@Test
	public void testInsertOrderedFood() {
		OrderedFood orderedFood = new OrderedFood();
		orderedFood.setFoodId(1);
		orderedFood.setReservationId(1);

		orderedFoodDao.insertOrderedFood(orderedFood);
	}

	@Test
	public void testGetOrderedFoodsByReservation() {
		Collection<OrderedFood> orderedFoods = orderedFoodDao.getOrderedFoodsByReservation(1);

		for (OrderedFood orderedFood : orderedFoods) {
			logOrderedFood(orderedFood);
		}

		Assume.assumeFalse(orderedFoods.isEmpty());
	}

	@Test
	public void testGetAllOrderedFoods() {
		Collection<OrderedFood> orderedFoods = orderedFoodDao.getAllOrderedFoods();

	for (OrderedFood orderedFood : orderedFoods) {
			logOrderedFood(orderedFood);
		}

		Assume.assumeFalse(orderedFoods.isEmpty());
	}
	
	@Test
	public void testDeleteOrderedFoodsByReservation() {
		orderedFoodDao.deleteOrderedFoodsByReservation(1);
	}

	private void logOrderedFood(OrderedFood orderedFood) {
		LOGGER.info("FoodId" + orderedFood.getFoodId());
		LOGGER.info("ReservationId" + orderedFood.getReservationId());
	}
}
