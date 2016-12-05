package dao;

import java.util.Collection;

import exceptions.DeleteFailedException;
import exceptions.InsertFailedException;
import exceptions.NoResultException;
import exceptions.UpdateFailedException;
import model.Restaurant;

public interface RestaurantDao {

	public void insertRestaurant(Restaurant restaurant) throws InsertFailedException;
	
	public void updateRestaurant(Restaurant restaurant) throws  UpdateFailedException;
	
	public Collection<Restaurant> getAllRestaurants() throws NoResultException;
	
	public Restaurant getRestaurant(String name) throws NoResultException;
	
	public void deleteRestaurant(String name) throws DeleteFailedException;
	
}