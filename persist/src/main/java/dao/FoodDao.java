package dao;

import java.util.Collection;

import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import model.Food;

public interface FoodDao {
	public void insertFood(Food food) throws InsertFailedException, NoResultException;

	public void updateFood(Food food) throws UpdateFailedException, NoResultException;

	public Food getFood(int id) throws NoResultException;
	
	public Food getFoodByName(String name) throws NoResultException;
	
	public Collection<Food> getAllFood() throws NoResultException;

	public void deleteFood(Food food) throws DeleteFailedException;

}
