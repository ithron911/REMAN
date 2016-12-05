package hu.uni.reman.persist.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.RestaurantDao;
import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import hu.uni.reman.persist.mysql.mapper.RestaurantMapper;
import model.Restaurant;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;



public class RestaurantDAOImpl implements RestaurantDao{
	
	private SqlSessionFactory sqlSessionFactory;

	public RestaurantDAOImpl(String configPath, String host, int port, String db, String user, String pass, String connectionUrl)
			throws FileNotFoundException {
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
	public void insertRestaurant(Restaurant restaurant) throws InsertFailedException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RestaurantMapper RestaurantMapper = sqlSession.getMapper(RestaurantMapper.class);

		String name = null;
		try {
			RestaurantMapper.insertRestaurant(restaurant);

			name = restaurant.getName();
			if (name == null) {
				throw new InsertFailedException("Insertion failed!");
			}
		} finally {
			sqlSession.close();
		}


	}

	@Override
	public void updateRestaurant(Restaurant restaurant) throws UpdateFailedException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RestaurantMapper RestaurantMapper = sqlSession.getMapper(RestaurantMapper.class);

		try {
			RestaurantMapper.updateRestaurant(restaurant);
		} finally {
			sqlSession.close();
		}
	}
	@Override
	public Collection<Restaurant> getAllRestaurants() throws NoResultException {SqlSession sqlSession = sqlSessionFactory.openSession();
	
	RestaurantMapper RestaurantMapper = sqlSession.getMapper(RestaurantMapper.class);
	Collection<Restaurant> allRestaurants = null;

	try {
		allRestaurants = RestaurantMapper.getAllRestaurants();

		if (allRestaurants == null) {
			throw new NoResultException("The query has no result, the table is empty!");
		}

	} finally {
		sqlSession.close();
	}

	return allRestaurants;
	}
		

	@Override
	public void deleteRestaurant(String name) throws DeleteFailedException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RestaurantMapper RestaurantMapper = sqlSession.getMapper(RestaurantMapper.class);

		try {
			RestaurantMapper.deleteRestaurant(name);
		} finally {
			sqlSession.close();
		}
		
	}

	@Override
	public Restaurant getRestaurant(String name) throws NoResultException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		RestaurantMapper RestaurantMapper = sqlSession.getMapper(RestaurantMapper.class);
		Restaurant restaurant = null;

		try {
			restaurant = RestaurantMapper.getRestaurant(name);
			
			if (restaurant == null) {
				throw new NoResultException("The query has no result with name: " + name);
			}
		} finally {
			sqlSession.close();
		}
		
		return restaurant;
	}

}
