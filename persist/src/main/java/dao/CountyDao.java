package dao;

import java.util.List;

import daomodels.County;

public interface CountyDao {

	void recordCounty(County county);

	List<County> getAllCounties();

	void deleteCounty(County county);
}
