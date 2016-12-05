package hu.uni.reman.persist.mysql.mapper;

import java.util.Collection;

import model.Restaurant;

public interface RestaurantMapper {
	void insertRestaurant(Restaurant Restaurant);
	void updateRestaurant(Restaurant Restaurant);
	Restaurant getRestaurant(String name);
	Collection<Restaurant> getAllRestaurants();
	void deleteRestaurant(String name);
}
