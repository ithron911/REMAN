package model;

public enum RestaurantType {
	
	FASTFOOD("fastfood"),
	STREETFOOD("streetfood"),
	CASUAL("casual"),
	PUB("pub"),
	PIZZERIA("pizzeria");
	

	private String restaurantType;

	private RestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}

	public String getResturantType() {
		return restaurantType;
	}

}
