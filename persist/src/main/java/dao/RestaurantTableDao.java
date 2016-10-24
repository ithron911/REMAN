package dao;

import java.util.List;

import daomodels.RestaurantTable;

public interface RestaurantTableDao {

	void recordRestaurantTable(RestaurantTable restaurantTable);

	List<RestaurantTable> getAllRestaurantTables();

	void deleteRestaurantTable(RestaurantTable restaurantTable);
}
