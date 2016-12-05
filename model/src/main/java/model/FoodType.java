package model;

public enum FoodType {

	Main(0),
	Soup(1),
	Breakfast(2),
	Dessert(3),		
	Pizza(4),
	Fastfood(5),
	Dish(6),
	Garnish(7),
	Salads(8),
	Vegetarian(9),
	Drinks(10);

	private int type;

	private FoodType(int type) {
		this.type = type;
	}
	
	public int getType() {
		return this.type;
	}
}
