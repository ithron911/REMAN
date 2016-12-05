package daotests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import dao.FoodSellingDao;
import hu.uni.reman.persist.mysql.FoodSellingDAOImpl;
import model.FoodSelling;
import sqlscripttests.SQLScriptLoadTests;

public class FoodSellingDAOImplTests extends SQLScriptLoadTests {
	
	private FoodSellingDao foodSellingDao;
	
	@Before
	public void setUp(){
		super.setUp();
		try {
			this.foodSellingDao = new FoodSellingDAOImpl(MYBATIS_CONFIG, HOST, PORT, DATABASE, USER, PASSWORD, CONNECTION_URL);
		} catch (FileNotFoundException e) {
			Assume.assumeNoException(e);
		}
	}

	@Test
	public void testInsertFoodToRestaurant() {
		FoodSelling fs = new FoodSelling();
		fs.setFoodId(1);
		fs.setRestaurantName("Alephant");
		
		foodSellingDao.insertFoodToRestaurant(fs);
	}

	@Test
	public void testGetAllRestaurantByFoodId() {
		foodSellingDao.getAllRestaurantByFoodId(1);
	}

	@Test
	public void testGetAllFoodsByRestaurantId() {
		foodSellingDao.getAllFoodsByRestaurantId("Alephant");
	}

	@Test
	public void testDeleteRestaurantsFoodByFoodId() {
		foodSellingDao.deleteRestaurantsFoodByFoodId(1);
	}

	@Test
	public void testDeleteFoodByRestaurantId() {
		foodSellingDao.deleteFoodByRestaurantId("Alephant");
	}

}
