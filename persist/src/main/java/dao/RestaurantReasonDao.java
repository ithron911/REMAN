package dao;

import java.util.List;

import daomodels.RestaurantReason;

public interface RestaurantReasonDao {

	void recordRestaurantReason(RestaurantReason reason);

	List<RestaurantReason> getAllRestaurantReasons();

	void deleteRestaurantReason(RestaurantReason reason);
}
