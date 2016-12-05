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

import dao.OrderedFoodDao;
import hu.uni.reman.persist.mysql.mapper.OrderedFoodMapper;
import model.OrderedFood;

public class OrderedFoodDaoImpl implements OrderedFoodDao {

	private SqlSessionFactory sqlSessionFactory;

	public OrderedFoodDaoImpl(String configPath, String host, int port, String db, String user, String pass, String connectionUrl)
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
	public void insertOrderedFood(OrderedFood orderedFood) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderedFoodMapper orderedFoodMapper = sqlSession.getMapper(OrderedFoodMapper.class);

		try {

			orderedFoodMapper.insertOrderedFood(orderedFood);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Collection<OrderedFood> getOrderedFoodsByReservation(int reservationId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderedFoodMapper orderedFoodMapper = sqlSession.getMapper(OrderedFoodMapper.class);
		Collection<OrderedFood> orderedFoods = null;

		try {
			orderedFoods = orderedFoodMapper.getOrderedFoodsByReservation(reservationId);
		} finally {
			sqlSession.close();
		}

		return orderedFoods;
	}

	@Override
	public Collection<OrderedFood> getAllOrderedFoods() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderedFoodMapper orderedFoodMapper = sqlSession.getMapper(OrderedFoodMapper.class);
		Collection<OrderedFood> orderedFoods = null;

		try {
			orderedFoods = orderedFoodMapper.getAllOrderedFoods();
		} finally {
			sqlSession.close();
		}

		return orderedFoods;
	}

	@Override
	public void deleteOrderedFoodsByReservation(int reservationId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderedFoodMapper orderedFoodMapper = sqlSession.getMapper(OrderedFoodMapper.class);
		
		try {
			orderedFoodMapper.deleteOrderedFoodsByReservation(reservationId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		
	}

}
