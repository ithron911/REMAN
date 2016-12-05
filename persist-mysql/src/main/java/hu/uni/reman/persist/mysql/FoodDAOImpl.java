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

import dao.FoodDao;
import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import hu.uni.reman.persist.mysql.mapper.FoodMapper;
import hu.uni.reman.persist.mysql.mapper.ReservationMapper;
import model.Food;
import model.Reservation;

public class FoodDAOImpl implements FoodDao {

	private SqlSessionFactory sqlSessionFactory;
	
	public FoodDAOImpl(String configPath, String host, int port, String db, String user, String pass, String connectionUrl) throws FileNotFoundException {
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
	public void insertFood(Food food) throws InsertFailedException {
		Food existFood = getFoodById(food.getId());
		if (existFood != null) {
			throw new InsertFailedException("Food is already exists");
		}
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);

		foodMapper.insertFood(food);
		
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void updateFood(Food food) throws UpdateFailedException {
		Food existFood = getFoodById(food.getId());
		if (existFood == null) {
			throw new UpdateFailedException("Food is not exists");
		}

		SqlSession sqlSession = sqlSessionFactory.openSession();
		FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
		foodMapper.updateFood(food);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public Food getFoodById(int id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
		Food food = null;
		food = foodMapper.getFoodById(id);
		sqlSession.commit();
		sqlSession.close();
		return food;
	}

	@Override
	public void deleteFood(Food food) throws DeleteFailedException {
		Food existFood = getFoodById(food.getId());
		if (existFood == null) {
			throw new DeleteFailedException("Food is not exists");
		}
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
		foodMapper.deleteFood(food.getId());
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public Food getFoodByName(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
		Food food = null;
		food = foodMapper.getFoodByName(name);
		sqlSession.commit();
		sqlSession.close();
		return food;
	}

	@Override
	public Collection<Food> getAllFood() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
		Collection<Food> food = null;
		food = foodMapper.getAllFood();
		sqlSession.commit();
		sqlSession.close();
		return food;
	}

}
