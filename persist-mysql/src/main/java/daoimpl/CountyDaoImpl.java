package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import dao.CountyDao;
import daomodels.County;

@Repository
public class CountyDaoImpl implements CountyDao {

	@PersistenceContext
	private EntityManager entityManager;

	public CountyDaoImpl() {
	}

	@Override
	public void recordCounty(County county) {
		entityManager.persist(county);
	}

	@Override
	public List<County> getAllCounties() {
		String select = "SELECT c FROM County c";

		TypedQuery<County> query = entityManager.createQuery(select, County.class);

		return query.getResultList();
	}

	@Override
	public void deleteCounty(County county) {
		entityManager.remove(county);
	}

}
