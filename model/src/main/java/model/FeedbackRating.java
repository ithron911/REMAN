package model;

public enum FeedbackRating {
	EXCELLENT(5), GOOD(4), AVERAGE(3), BAD(2), TERRIBLE(1);
	
	private int ratingValue;
	
	private FeedbackRating(int ratingValue) {
		this.ratingValue = ratingValue;
	}
	
	public int getRatingValue() {
		return this.ratingValue;
	}
}
