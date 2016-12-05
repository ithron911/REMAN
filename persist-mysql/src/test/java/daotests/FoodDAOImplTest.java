package daotests;

import java.io.FileNotFoundException;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import dao.FoodDao;
import exceptions.NoResultException;
import hu.uni.reman.persist.mysql.FoodDAOImpl;
import model.Food;
import model.Reservation;
import sqlscripttests.SQLScriptLoadTests;

public class FoodDAOImplTest extends SQLScriptLoadTests {

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
	public void getTest() throws NoResultException {
		Food food = foodDao.getFood(1);
		Assume.assumeNotNull(food);
	}

}
