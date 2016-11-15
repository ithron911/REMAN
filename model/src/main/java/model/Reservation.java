package model;

import java.util.Date;
import java.util.List;

public class Reservation {
	
	public enum Currency {
		EUR,
		HUF,
		USD,
		GBP,
	}

	private Date dateBook;
	private int price;
	private Currency currency;
	private String comment;
	private PaymentType paymentType;
	private List<Table> tables;
	
	public Reservation() {}

	public Date getDateBook() {
		return dateBook;
	}

	public void setDateBook(Date dateBook) {
		this.dateBook = dateBook;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
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
}
