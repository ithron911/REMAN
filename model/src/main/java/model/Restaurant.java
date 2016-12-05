package model;

import java.util.Date;

public class Restaurant {
	
	private String name;
	private Date founding;
	private RestaurantType type;
	
	public Restaurant(){
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getFounding() {
		return founding;
	}
	public void setFounding(Date founding) {
		this.founding = founding;
	}
	public RestaurantType getType() {
		return type;
	}
	public void setType(RestaurantType type) {
		this.type = type;
	}
}
