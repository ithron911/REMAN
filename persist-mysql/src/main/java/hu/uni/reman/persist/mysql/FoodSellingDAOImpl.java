package hu.uni.reman.persist.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.FoodSellingDao;
import exceptions.InsertFailedException;
import hu.uni.reman.persist.mysql.mapper.FoodMapper;
import hu.uni.reman.persist.mysql.mapper.FoodSellingMapper;
import model.Food;
import model.FoodSelling;
import model.Restaurant;

public class FoodSellingDAOImpl implements FoodSellingDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public FoodSellingDAOImpl(String configPath, String host, int port, String db, String user, String pass, String connectionUrl) throws FileNotFoundException {
		File configFile = new File(configPath);
		InputStream inputStream = new FileInputStream(configFile);
		String url = String.format(connectionUrl , host, port, db);
		Properties props = new Properties();
		props.put("driver", "com.mysql.jdbc.Driver");
		props.put("url", url);
		props.put("username", user);
		props.put("password", pass);
		this.sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream, props);
	}

	@Override
	public void insertFoodToRestaurant(FoodSelling foodSelling) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FoodSellingMapper foodSellingMapper = sqlSession.getMapper(FoodSellingMapper.class);

		foodSellingMapper.insertFoodToRestaurant(foodSelling);
		
		sqlSession.commit();
		sqlSession.close();

	}

	@Override
	public Collection<Restaurant> getAllRestaurantByFoodId(int foodId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FoodSellingMapper foodSellingMapper = sqlSession.getMapper(FoodSellingMapper.class);

		Collection<Restaurant> restaurants = foodSellingMapper.getAllRestaurantByFoodId(foodId);
		
		sqlSession.commit();
		sqlSession.close();

		return restaurants;
	}

	@Override
	public Collection<Food> getAllFoodsByRestaurantId(String restaurantId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FoodSellingMapper foodSellingMapper = sqlSession.getMapper(FoodSellingMapper.class);

		Collection<Food> foods = foodSellingMapper.getAllFoodsByRestaurantId(restaurantId);
		
		sqlSession.commit();
		sqlSession.close();

		return foods;
	}

	@Override
	public void deleteRestaurantsFoodByFoodId(int foodId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FoodSellingMapper foodSellingMapper = sqlSession.getMapper(FoodSellingMapper.class);

		foodSellingMapper.deleteRestaurantsFoodByFoodId(foodId);
		
		sqlSession.commit();
		sqlSession.close();

	}

	@Override
	public void deleteFoodByRestaurantId(String restaurantId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FoodSellingMapper foodSellingMapper = sqlSession.getMapper(FoodSellingMapper.class);

		foodSellingMapper.deleteFoodByRestaurantId(restaurantId);
		
		sqlSession.commit();
		sqlSession.close();
	}

}
