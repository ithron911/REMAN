package dao;

import java.util.List;

import daomodels.RestaurantFood;

public interface RestaurantFoodDao {

	void recordRestaurantFood(RestaurantFood restaurantFood);

	List<RestaurantFood> getAllRestaurantFoods();

	void deleteRestaurantFood(RestaurantFood restaurantFood);
}
