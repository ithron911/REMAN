package hu.uni.reman.persist.mysql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.ReservationDao;
import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import hu.uni.reman.persist.mysql.mapper.ReservationMapper;
import model.Reservation;

public class ReservationDAOImpl implements ReservationDao {

	private SqlSessionFactory sqlSessionFactory;

	public ReservationDAOImpl(String configPath, String host, int port, String db, String user, String pass)
			throws FileNotFoundException {
		File configFile = new File(configPath);
		InputStream inputStream = new FileInputStream(configFile);
		String url = String.format("jdbc:mysql://%s:%s/%s?allowMultiQueries=true", host, port, db);
		Properties props = new Properties();
		props.put("driver", "com.mysql.jdbc.Driver");
		props.put("url", url);
		props.put("username", user);
		props.put("password", pass);
		this.sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream, props);
	}

	@Override
	public int insertReservation(Reservation reservation) throws InsertFailedException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ReservationMapper reservationMapper = sqlSession.getMapper(ReservationMapper.class);

		int id = 0;
		try {
			reservationMapper.insertReservation(reservation);

			id = reservation.getId();
			if (id == 0) {
				throw new InsertFailedException("Insertion failed!");
			}
		} finally {
			sqlSession.close();
		}


		return id;
	}

	@Override
	public void updateReservation(Reservation reservation) throws UpdateFailedException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ReservationMapper reservationMapper = sqlSession.getMapper(ReservationMapper.class);

		try {
			reservationMapper.updateReservation(reservation);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Reservation getReservation(int id) throws NoResultException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ReservationMapper reservationMapper = sqlSession.getMapper(ReservationMapper.class);
		Reservation reservation = null;

		try {
			reservation = reservationMapper.getReservation(id);
			
			if (reservation == null) {
				throw new NoResultException("The query has no result with id: " + id);
			}
		} finally {
			sqlSession.close();
		}
		
		return reservation;
	}

	@Override
	public void deleteReservation(int id) throws DeleteFailedException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ReservationMapper reservationMapper = sqlSession.getMapper(ReservationMapper.class);

		try {
			reservationMapper.deleteReservation(id);
		} finally {
			sqlSession.close();
		}
	}

}
