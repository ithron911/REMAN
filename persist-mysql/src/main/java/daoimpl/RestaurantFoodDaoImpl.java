package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import dao.RestaurantFoodDao;
import daomodels.RestaurantFood;

@Repository
public class RestaurantFoodDaoImpl implements RestaurantFoodDao {

	@PersistenceContext
	private EntityManager entityManager;

	public RestaurantFoodDaoImpl() {
	}

	@Override
	public void recordRestaurantFood(RestaurantFood restaurantFood) {
		entityManager.persist(restaurantFood);
	}

	@Override
	public List<RestaurantFood> getAllRestaurantFoods() {
		String select = "SELECT restfood FROM RestaurantFood restfood";

		TypedQuery<RestaurantFood> query =
		    entityManager.createQuery(select, RestaurantFood.class);

		return query.getResultList();
	}

	@Override
	public void deleteRestaurantFood(RestaurantFood restaurantFood) {
		entityManager.remove(restaurantFood);
	}
}
