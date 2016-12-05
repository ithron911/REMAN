package dao;

import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import model.Food;

public interface FoodDao {
	public void insertFood() throws InsertFailedException;

	public void updateFood(Food food) throws UpdateFailedException;

	public Food getFood(int id) throws NoResultException;

	public void deleteFood(Food food) throws DeleteFailedException;

}
