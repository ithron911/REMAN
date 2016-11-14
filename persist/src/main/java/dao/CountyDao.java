package dao;

import java.util.List;

import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.MultipleResultException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import model.County;

public interface CountyDao {

	public void insertCounty() throws InsertFailedException;

	public void updateCounty(County county) throws UpdateFailedException;

	public void getCounty(String countyName) throws NoResultException, MultipleResultException;

	public List<County> getAllCounties() throws NoResultException;

	public void deleteCounty(County county) throws DeleteFailedException;
}
