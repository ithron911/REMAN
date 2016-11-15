package model;

import java.util.Date;
import java.util.ArrayList;

public class Restaurant {
	
	private String name;
	private Date founding;
	private RestaurantType type;
	private ArrayList<Payment> payments;
	private ArrayList<Table> tables;
	
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
	public ArrayList<Payment> getPayments() {
		return payments;
	}
	public void setPayments(ArrayList<Payment> payments) {
		this.payments = payments;
	}
	public ArrayList<Table> getTables() {
		return tables;
	}
	public void setTables(ArrayList<Table> tables) {
		this.tables = tables;
	}
}
