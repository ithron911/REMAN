package dao;

import java.util.List;

import daomodels.Restaurant;

public interface RestaurantDao {

	void recordRestaurant(Restaurant restaurant);

	List<Restaurant> getAllRestaurants();

	void deleteRestaurant(Restaurant restaurant);

}
