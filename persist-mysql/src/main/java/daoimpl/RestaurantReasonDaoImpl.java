package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import dao.RestaurantReasonDao;
import daomodels.RestaurantReason;

@Repository
public class RestaurantReasonDaoImpl implements RestaurantReasonDao {

	@PersistenceContext
	private EntityManager entityManager;

	public RestaurantReasonDaoImpl() {
	}

	@Override
	public void recordRestaurantReason(RestaurantReason reason) {
		entityManager.persist(reason);
	}

	@Override
	public List<RestaurantReason> getAllRestaurantReasons() {
		String select = "SELECT restreas FROM RestaurantReason restreas";

		TypedQuery<RestaurantReason> query =
		    entityManager.createQuery(select, RestaurantReason.class);

		return query.getResultList();
	}

	@Override
	public void deleteRestaurantReason(RestaurantReason reason) {
		entityManager.remove(reason);
	}

}
