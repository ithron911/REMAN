package dao;

import java.util.List;

import daomodels.County;

public interface CountyDao {

	public void recordCounty(County county);

	public List<County> getAllCounties();

	public void deleteCounty(County county);
}
