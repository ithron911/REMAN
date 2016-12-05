package model;

public enum FeedbackRating {
	EXCELLENT(0), GOOD(1), AVERAGE(2), BAD(3), TERRIBLE(4);
	
	private int ratingValue;
	
	private FeedbackRating(int ratingValue) {
		this.ratingValue = ratingValue;
	}
	
	public int getRatingValue() {
		return this.ratingValue;
	}
}
