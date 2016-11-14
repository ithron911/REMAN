package dao;

import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.MultipleResultException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import model.County;

public interface CountyDao {

	public void insertCounty() throws InsertFailedException;

	public void updateCounty(County county) throws UpdateFailedException;

	public void getCounty(County county) throws NoResultException, MultipleResultException;

	public void deleteCounty(County county) throws DeleteFailedException;
}
