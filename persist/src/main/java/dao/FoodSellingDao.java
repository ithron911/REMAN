package dao;

import java.util.Collection;

import model.Food;
import model.FoodSelling;
import model.Restaurant;

public interface FoodSellingDao {

	public void insertFoodToRestaurant(FoodSelling foodSelling);

	public Collection<Restaurant> getAllRestaurantByFoodId(int foodId);
	
	public Collection<Food> getAllFoodsByRestaurantId(String restaurantId);

	public void deleteRestaurantsFoodByFoodId(int foodId);

	public void deleteFoodByRestaurantId(String restaurantId);
}
