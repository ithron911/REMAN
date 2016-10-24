package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import dao.FoodDao;
import daomodels.Food;

@Repository
public class FoodDaoImpl implements FoodDao {

	@PersistenceContext
	private EntityManager entityManager;

    public FoodDaoImpl() {
	}

	@Override
	public void recordFood(Food food) {
		entityManager.persist(food);
	}

	@Override
	public List<Food> getAllFoods() {
		String select = "SELECT f FROM Food f";

		TypedQuery<Food> query = entityManager.createQuery(select, Food.class);

		return query.getResultList();
	}

	@Override
	public void deleteFood(Food food) {
		entityManager.remove(food);
	}

}
