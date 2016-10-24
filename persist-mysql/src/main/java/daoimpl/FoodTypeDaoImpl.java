package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import dao.FoodTypeDao;
import daomodels.FoodType;

@Repository
public class FoodTypeDaoImpl implements FoodTypeDao {

	@PersistenceContext
	private EntityManager entityManager;

	public FoodTypeDaoImpl() {
	}

	@Override
	public void recordFoodType(FoodType foodType) {
		entityManager.persist(foodType);
	}

	@Override
	public List<FoodType> getAllFoodTipes() {
		String select = "SELECT ft FROM FoodType ft";

		TypedQuery<FoodType> query = entityManager.createQuery(select, FoodType.class);

		return query.getResultList();
	}

	@Override
	public void deleteFoodType(FoodType foodType) {
		entityManager.remove(foodType);
	}
}
