package model;

public enum CurrencyType {

	EUR(1),
	HUF(2),
	USD(3),
	GBP(4);

	private int curr;

	private CurrencyType(int curr) {
		this.curr = curr;
	}
	
	public int getCurr() {
		return this.curr;
	}
}
