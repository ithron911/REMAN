package hu.uni.reman.persist.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mysql.cj.api.x.Collection;

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
	public void insertFood(Food food) throws InsertFailedException, NoResultException {
		Food existFood = getFood(food.getId());
		if (existFood != null) {
			throw new InsertFailedException("Food is already exists");
		}
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);

		try {
			foodMapper.insertFood(food);
		
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void updateFood(Food food) throws UpdateFailedException, NoResultException {
		Food existFood = getFood(food.getId());
		if (existFood == null) {
			throw new UpdateFailedException("Food is not exists");
		}

		SqlSession sqlSession = sqlSessionFactory.openSession();
		FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);

		try {
			foodMapper.updateFood(food);
		
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Food getFood(int id) throws NoResultException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FoodMapper foodMapper = sqlSession.getMapper(FoodMapper.class);
		Food food = null;

		try {
			food = foodMapper.selectFood(id);
		
			if (food == null) {
				throw new NoResultException("The query has no result with id: " + id);
			}
		} finally {
			sqlSession.close();
		}
		
		return food;
	}

	@Override
	public void deleteFood(Food food) throws DeleteFailedException {
		// TODO Auto-generated method stub

	}

	@Override
	public Food getFoodByName(String name) throws NoResultException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public java.util.Collection<Food> getAllFood() throws NoResultException {
		// TODO Auto-generated method stub
		return null;
	}

}
