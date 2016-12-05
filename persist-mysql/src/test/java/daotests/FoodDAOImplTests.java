package daotests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import dao.FoodDao;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import hu.uni.reman.persist.mysql.FoodDAOImpl;
import model.CurrencyType;
import model.Food;
import model.FoodType;
import sqlscripttests.SQLScriptLoadTests;

public class FoodDAOImplTests extends SQLScriptLoadTests {
	
	private FoodDao foodDao;
	
	@Before
	public void setUp(){
		super.setUp();
		try {
			this.foodDao = new FoodDAOImpl(MYBATIS_CONFIG, HOST, PORT, DATABASE, USER, PASSWORD, CONNECTION_URL);
		} catch (FileNotFoundException e) {
			Assume.assumeNoException(e);
		}
	}

	@Test
	public void testInsertFood() throws InsertFailedException, NoResultException {
		foodDao.insertFood(createFood());
	}

	@Test
	public void testUpdateFood() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFood() throws NoResultException {
		Food food = foodDao.getFood(1);
		Assume.assumeNotNull(food);
	}

	@Test
	public void testDeleteFood() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFoodByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllFood() {
		fail("Not yet implemented");
	}

	private Food createFood() {
		Food food = new Food();
		food.setCurrency(CurrencyType.HUF);
		food.setDescription("Test description");
		food.setFoodType(FoodType.Dessert);
		food.setName("Test Dessert");
		food.setPrice(800);
		return food;
	}
}
