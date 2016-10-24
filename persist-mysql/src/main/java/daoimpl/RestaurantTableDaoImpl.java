package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import dao.RestaurantTableDao;
import daomodels.RestaurantTable;

@Repository
public class RestaurantTableDaoImpl implements RestaurantTableDao {

	@PersistenceContext
	private EntityManager entityManager;

	public RestaurantTableDaoImpl() {
	}

	@Override
	public void recordRestaurantTable(RestaurantTable restaurantTable) {
		entityManager.persist(restaurantTable);
	}

	@Override
	public List<RestaurantTable> getAllRestaurantTables() {
		String select = "SELECT resttable FROM RestaurantTable resttable";

		TypedQuery<RestaurantTable> query =
		    entityManager.createQuery(select, RestaurantTable.class);

		return query.getResultList();
	}
	@Override
	public void deleteRestaurantTable(RestaurantTable restaurantTable) {
		entityManager.remove(restaurantTable);
	}
}
