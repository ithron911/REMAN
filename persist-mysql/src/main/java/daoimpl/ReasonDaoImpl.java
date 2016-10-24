package daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import dao.ReasonDao;
import daomodels.Reason;

@Repository
public class ReasonDaoImpl implements ReasonDao {

	@PersistenceContext
	private EntityManager entityManager;

	public ReasonDaoImpl() {
	}

	@Override
	public void recordReason(Reason reason) {
		entityManager.persist(reason);
	}

	@Override
	public List<Reason> getAllReasons() {
		String select = "SELECT r FROM Reason r";

		TypedQuery<Reason> query = entityManager.createQuery(select, Reason.class);

		return query.getResultList();
	}

	@Override
	public void deleteReason(Reason reason) {
		entityManager.remove(reason);
	}

	
}
