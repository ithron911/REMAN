package hu.uni.reman.persist.mysql.mapper;

import java.util.Collection;

import model.Food;

public interface FoodMapper {
	
	public void insertFood(Food food);
	
	public void updateFood(Food food);
	
	public Food getFoodById(int id);
	
	public Food getFoodByName(String name);
	
	public Collection<Food> getAllFood();
	
	public void deleteFood(int id);
}
