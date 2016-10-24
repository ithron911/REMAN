package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import dao.ReservationDao;
import daomodels.Reservation;

@Repository
public class ReservationDaoImpl implements ReservationDao {

	@PersistenceContext
	private EntityManager entityManager;

	public ReservationDaoImpl() {
	}

	@Override
	public void recordReservation(Reservation reservation) {
		entityManager.persist(reservation);
	}

	@Override
	public List<Reservation> getAllReservations() {
		String select = "SELECT res FROM Reservation res";

		TypedQuery<Reservation> query = entityManager.createQuery(select, Reservation.class);

		return query.getResultList();
	}

	@Override
	public void deleteReservation(Reservation reservation) {
		entityManager.remove(reservation);
	}
}
