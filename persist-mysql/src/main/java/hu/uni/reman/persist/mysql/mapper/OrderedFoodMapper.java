package hu.uni.reman.persist.mysql.mapper;

import java.util.Collection;

import model.OrderedFood;

public interface OrderedFoodMapper {

	public void insertOrderedFood(OrderedFood orderedFood);

	public Collection<OrderedFood> getOrderedFoodsByReservation(int reservationId);
	
	public Collection<OrderedFood> getAllOrderedFoods();

	public void deleteOrderedFoodsByReservation(int reservationId);
}
