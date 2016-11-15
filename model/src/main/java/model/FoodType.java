package model;

public enum FoodType {

	Main(1),
	Soup(2),
	Breakfast(3),
	Dessert(4),		
	Pizza(5),
	Fastfood(6),
	Dish(7),
	Garnish(8),
	Salads(9),
	Vegetarian(10),
	Drinks(11);

	private int type;

	private FoodType(int type) {
		this.type = type;
	}
	
	public int getType() {
		return this.type;
	}
}
