package hu.uni.reman.persist.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.FoodDao;
import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.MultipleResultException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import model.Food;

public class FoodDAOImpl implements FoodDao {

	private SqlSessionFactory sessionFactory;
	
	public FoodDAOImpl(String mybatisConfig, String host, int port, String database, String user, String password) throws FileNotFoundException {
		Properties props = new Properties();
		props.put("driver", "com.mysql.jdbc.Driver");
		props.put("url", String.format("jdbc:mysql://%s:%d/%s", host, port, database));
		props.put("username", user);
		props.put("password", password);

		File config = new File(mybatisConfig);
		InputStream inputStream = new FileInputStream(config);
		this.sessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
	}

	@Override
	public void insertFood() throws InsertFailedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateFood(Food food) throws UpdateFailedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void getFood(Food food) throws NoResultException, MultipleResultException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFood(Food food) throws DeleteFailedException {
		// TODO Auto-generated method stub

	}

}
