package dao;

import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.MultipleResultException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import model.Food;

public interface FoodDao {
	public void insertFood() throws InsertFailedException;

	public void updateFood(Food food) throws UpdateFailedException;

	public void getFood(Food food) throws NoResultException, MultipleResultException;

	public void deleteFood(Food food) throws DeleteFailedException;

}
