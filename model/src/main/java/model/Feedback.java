package model;

import java.util.Date;

public class Feedback {
	private int id;
	private FeedbackRating rating;
	private Date date;
	private String otherComment;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Feedback() {
	}
	public FeedbackRating getRating() {
		return rating;
	}
	public void setRating(FeedbackRating rating) {
		this.rating = rating;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOtherComment() {
		return otherComment;
	}
	public void setOtherComment(String otherComment) {
		this.otherComment = otherComment;
	}
}
