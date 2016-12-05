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

import dao.ReservationDao;
import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import hu.uni.reman.persist.mysql.mapper.ReservationMapper;
import model.Reservation;

public class ReservationDAOImpl implements ReservationDao {

	private SqlSessionFactory sqlSessionFactory;

	public ReservationDAOImpl(String configPath, String host, int port, String db, String user, String pass, String connectionUrl)
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
	public void insertReservation(Reservation reservation) throws InsertFailedException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ReservationMapper reservationMapper = sqlSession.getMapper(ReservationMapper.class);

		try {
			Collection<Reservation> reservations = reservationMapper.getAllReservations();
			for (Reservation res : reservations) {
				if (res.getId() == reservation.getId()) {
					throw new InsertFailedException("A reservation with this id exists:" + reservation.getId());
				}
			}
			reservationMapper.insertReservation(reservation);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void updateReservation(Reservation reservation) throws UpdateFailedException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ReservationMapper reservationMapper = sqlSession.getMapper(ReservationMapper.class);

		boolean isReservationExits = false;
		Collection<Reservation> reservations = reservationMapper.getAllReservations();
		for (Reservation res : reservations) {
			if (res.getId() == reservation.getId()) {
				isReservationExits = true;
				break;
			}

		}
		
		if (isReservationExits == false) {
			throw new UpdateFailedException("A reservation with this id does not exists:" + reservation.getId());
		}
		try {
			reservationMapper.updateReservation(reservation);
			sqlSession.commit();
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
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		
		return reservation;
	}

	@Override
	public Collection<Reservation> getAllReservation() throws NoResultException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ReservationMapper reservationMapper = sqlSession.getMapper(ReservationMapper.class);
		Collection<Reservation> allReservations = null;

		try {
			allReservations = reservationMapper.getAllReservations();

			if (allReservations == null) {
				throw new NoResultException("The query has no result, the table is empty!");
			}

			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

		return allReservations;
	}

	@Override
	public void deleteReservation(int id) throws DeleteFailedException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ReservationMapper reservationMapper = sqlSession.getMapper(ReservationMapper.class);

		boolean isReservationExits = false;
		Collection<Reservation> reservations = reservationMapper.getAllReservations();
		for (Reservation res : reservations) {
			if (id == res.getId()) {
				isReservationExits = true;
				break;
			}
		}

		if (isReservationExits == false) {
			throw new DeleteFailedException("A reservation with this id does not exists:" + id);
		}

		try {
			reservationMapper.deleteReservation(id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
