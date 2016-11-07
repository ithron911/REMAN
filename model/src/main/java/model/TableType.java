package model;

public enum TableType {

	TWO_SEATER(2),
	THREE_SEATER(3),
	FOUR_SEATER(4),
	FIVE_SEATER(5),
	SIX_SEATER(6);
	
	private int chairsNumber;
	
	private TableType(int chairsNumber) {
		this.chairsNumber = chairsNumber;
	}
	
	public int getChairsNumber() {
		return this.chairsNumber;
	}
}
