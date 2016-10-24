package dao;

import java.util.List;

import daomodels.Reason;

public interface ReasonDao {

	void recordReason(Reason reason);

	List<Reason> getAllReasons();

	void deleteReason(Reason reason);
}
