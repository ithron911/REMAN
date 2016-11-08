package model;

import java.util.List;

public class Food {
	
	public enum foodTypes {
		Main,
		Soup,
		Breakfast,
		Dessert,		
		Pizza,
		Fastfood,
		Dish,
		Garnish,
		Salads,
		Vegetarian,
		Drinks,	
	}
	
	private int id;
	private String name;
	private foodTypes foodTypes;
	private int price;
	private String description;
	private List<String> ingredients;	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public foodTypes getFoodTypes() {
		return foodTypes;
	}
	public void setFoodTypes(foodTypes foodTypes) {
		this.foodTypes = foodTypes;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

}
