package model;

import java.util.Date;

public class Feedback {

	public enum Rating {
		EXCELLENT(5), GOOD(4), AVERAGE(3), BAD(2), TERRIBLE(1);
		
		private int ratingValue;
		
		private Rating(int ratingValue) {
			this.ratingValue = ratingValue;
		}
		
		public int getRatingValue() {
			return this.ratingValue;
		}
	}
	
	private Rating rating;
	private Date date;
	private String otherComment;
	
	public Feedback() {
	}

	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
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
