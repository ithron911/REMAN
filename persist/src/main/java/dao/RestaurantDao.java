package dao;

import java.util.List;

import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import model.Restaurant;

public interface RestaurantDao {

	public void insertRestaurant() throws InsertFailedException;
	
	public void updateRestaurant(Restaurant restaurant) throws  UpdateFailedException;
	
	public List<Restaurant> getAllRestaurants() throws NoResultException;
	
	public void deleteRestaurant(Restaurant restaurant) throws DeleteFailedException;
	
}