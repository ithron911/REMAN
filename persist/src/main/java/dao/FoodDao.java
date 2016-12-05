package dao;

import java.util.Collection;

import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import model.Food;

public interface FoodDao {
	public void insertFood(Food food) throws InsertFailedException;

	public void updateFood(Food food) throws UpdateFailedException;

	public Food getFoodById(int id) ;
	
	public Food getFoodByName(String name);
	
	public Collection<Food> getAllFood();

	public void deleteFood(Food food) throws DeleteFailedException;

}
