package model;

import java.util.Date;
import java.util.ArrayList;

public class Restaurant {
	
	private String name;
	private Date founding;
	private RestaurantType type;
//	private ArrayList<PaymentType> payments = new ArrayList<PaymentType>();
//	private ArrayList<TableType> tables = new ArrayList<TableType>();

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
/*	public ArrayList<PaymentType> getPayments() {
		return payments;
	}
	public void setPayments(ArrayList<PaymentType> payments) {
		this.payments = payments;
	}
	public ArrayList<TableType> getTables() {
		return tables;
	}
	public void setTables(ArrayList<TableType> tables) {
		this.tables = tables;
	}
	*/	
}
