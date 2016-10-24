package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import dao.RestaurantDao;
import daomodels.Restaurant;

@Repository
public class RestaurantDaoImpl implements RestaurantDao {

	@PersistenceContext
	private EntityManager entityManager;

	public RestaurantDaoImpl() {
	}

	@Override
	public void recordRestaurant(Restaurant restaurant) {
		entityManager.persist(restaurant);
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		String select = "SELECT rest FROM Restaurant rest";

		TypedQuery<Restaurant> query =
		    entityManager.createQuery(select, Restaurant.class);

		return query.getResultList();
	}

	@Override
	public void deleteRestaurant(Restaurant restaurant) {
		entityManager.remove(restaurant);
	}
}
