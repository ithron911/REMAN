package dao;

import java.util.Collection;

import model.OrderedFood;

public interface OrderedFoodDao {

	public void insertOrderedFood(OrderedFood orderedFood);

	public Collection<OrderedFood> getOrderedFoodsByReservation(int reservationId);
	
	public Collection<OrderedFood> getAllOrderedFoods();

	public void deleteOrderedFoodsByReservation(int reservationId);

}
