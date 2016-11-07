package model;

import java.util.Date;

public class Reservation {

	private Date dateBook;
	private int price;
	private String comment;
	private PaymentType paymentType;
	private TableType tableType;
	
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

	public TableType getTableType() {
		return tableType;
	}

	public void setTableType(TableType tableType) {
		this.tableType = tableType;
	}
	
	
	
}
