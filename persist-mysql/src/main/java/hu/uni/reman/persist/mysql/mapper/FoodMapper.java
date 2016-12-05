package hu.uni.reman.persist.mysql.mapper;

import java.util.Collection;

import model.Food;

public interface FoodMapper {
	public Collection<Food> selectFoods();
	public Food selectFood(int id);
	public void insertFood(Food food);
	public void updateFood(Food food);
}
