package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import dao.ReservationPlacesDao;
import daomodels.ReservationPlaces;

@Repository
public class ReservationPlacesDaoImpl implements ReservationPlacesDao {

	@PersistenceContext
	private EntityManager entityManager;

	public ReservationPlacesDaoImpl() {
	}

	@Override
	public void recordReservationPlaces(ReservationPlaces reservationPlaces) {
		entityManager.persist(reservationPlaces);
	}

	@Override
	public List<ReservationPlaces> getAllReservationPlaces() {
		String select = "SELECT resp FROM ReservationPlaces resp";

		TypedQuery<ReservationPlaces> query =
		    entityManager.createQuery(select, ReservationPlaces.class);

		return query.getResultList();
	}

	@Override
	public void deleteReservationPlaces(ReservationPlaces reservationPlaces) {
		entityManager.remove(reservationPlaces);
	}
}
