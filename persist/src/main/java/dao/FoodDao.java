package dao;

import java.util.List;

import daomodels.Food;

public interface FoodDao {

	void recordFood(Food food);

	List<Food> getAllFoods();

	void deleteFood(Food food);
}
