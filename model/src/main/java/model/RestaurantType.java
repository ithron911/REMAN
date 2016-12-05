package model;

public enum RestaurantType {
	
	FASTFOOD(0),
	STREETFOOD(1),
	CASUAL(2),
	PUB(3),
	PIZZERIA(4);
	

	private int restaurantType;

	private RestaurantType(int restaurantType) {
		this.restaurantType = restaurantType;
	}

	public int getResturantType() {
		return restaurantType;
	}

}
