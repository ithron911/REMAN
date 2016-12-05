package daotests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Collection;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import dao.FoodDao;
import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
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
		int oldSize = foodDao.getAllFood().size();
		Food food = createFoodWithoutId();
		foodDao.insertFood(food);
		
		int newSize = foodDao.getAllFood().size();
		assertNotEquals(oldSize, newSize);
	}

	@Test
	public void testUpdateFood() throws UpdateFailedException, NoResultException {
		Food expectedFood = createFoodWithoutId();
		expectedFood.setId(1);
		foodDao.updateFood(expectedFood);
		
		Food actualFood = foodDao.getFoodById(1);
		
		assertEquals(expectedFood.getName(), actualFood.getName());
	}
	
	@Test(expected = NoResultException.class)
	public void testUpdateFoodWithBadId() throws UpdateFailedException, NoResultException {
		Food food = createFoodWithoutId();
		food.setId(-1);
		foodDao.updateFood(food);
	}

	@Test
	public void testGetFood() throws NoResultException {
		Food food = foodDao.getFoodById(1);
		Assume.assumeNotNull(food);
	}

	@Test
	public void testDeleteFood() throws DeleteFailedException, NoResultException {
		int oldSize = foodDao.getAllFood().size();
		
		Food food = createFoodWithoutId();
		food.setId(1);
		foodDao.deleteFood(food);
		
		int newSize = foodDao.getAllFood().size();
		assertNotEquals(oldSize, newSize);
	}
	
	@Test(expected = DeleteFailedException.class)
	public void testDeleteFoodWithNull() throws DeleteFailedException, NoResultException {
		foodDao.deleteFood(null);
	}
	
	@Test(expected = NoResultException.class)
	public void testDeleteFoodWithBadId() throws DeleteFailedException, NoResultException {
		Food food = createFoodWithoutId();
		food.setId(-1);
		foodDao.deleteFood(food);
	}

	@Test
	public void testGetFoodByName() throws NoResultException {
		Food expectedFood = foodDao.getFoodById(2);
		
		Food actualFood = foodDao.getFoodByName("Tofu Taco");
		
		assertEquals(expectedFood, actualFood);
	}

	@Test
	public void testGetAllFood() {
		Collection<Food> foodList = foodDao.getAllFood();
		int expectedLength = 10;
		
		assertEquals(expectedLength, foodList.size());
	}

	private Food createFoodWithoutId() {
		Food food = new Food();
		food.setCurrency(CurrencyType.HUF);
		food.setDescription("Test description");
		food.setFoodType(FoodType.Dessert);
		food.setName("Test Dessert");
		food.setPrice(800);
		return food;
	}
}
