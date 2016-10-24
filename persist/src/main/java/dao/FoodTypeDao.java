package dao;

import java.util.List;

import daomodels.FoodType;

public interface FoodTypeDao {

	void recordFoodType(FoodType foodType);

	List<FoodType> getAllFoodTipes();

	void deleteFoodType(FoodType foodType);
}
