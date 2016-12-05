package model;

public class Food {
	
	private int id;
	private String name;
	private FoodType foodType;
	private double price;
	private CurrencyType currency;
	private String description;
	
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
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getFoodType() {
		return foodType.getType();
	}
	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}
	public int getCurrency() {
		return currency.getCurr();
	}
	public void setCurrency(CurrencyType currency) {
		this.currency = currency;
	}
}
