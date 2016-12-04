package model;

public enum CurrencyType {

	EUR(0),
	HUF(1),
	USD(2),
	GBP(3);

	private int curr;

	private CurrencyType(int curr) {
		this.curr = curr;
	}
	
	public int getCurr() {
		return this.curr;
	}
}
