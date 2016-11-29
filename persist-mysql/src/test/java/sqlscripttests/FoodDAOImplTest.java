package sqlscripttests;

import java.io.FileNotFoundException;

import org.junit.Assume;
import org.junit.Test;

import dao.FoodDao;
import hu.uni.reman.persist.mysql.FoodDAOImpl;

public class FoodDAOImplTest extends SQLScriptLoadTests {

	private FoodDao dao;
	
	public void setUp(){
		try {
			this.dao = new FoodDAOImpl(MYBATIS_CONFIG, HOST, PORT, DATABASE, USER, PASSWORD);
		} catch (FileNotFoundException e) {
			Assume.assumeNoException(e);
		}
	}
	
	@Test
	public void FoodDAOImplTest() {
		this.setUp();
	}

}
