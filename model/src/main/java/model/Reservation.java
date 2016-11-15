package model;

import java.util.Date;
import java.util.List;

public class Reservation {

	private int id;
	private Date dateBook;
	private double price;
	private Currency currency;
	private String comment;
	private Payment payment;
	private String restaurantName;
	private List<Table> tables;
	
	public Reservation() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateBook() {
		return dateBook;
	}

	public void setDateBook(Date dateBook) {
		this.dateBook = dateBook;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurant(String restaurantName) {
		this.restaurantName = restaurantName;
	}
}
