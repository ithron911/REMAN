package model;

public enum TableType {

	TWO_SEATER(0),
	THREE_SEATER(1),
	FOUR_SEATER(2),
	FIVE_SEATER(3),
	SIX_SEATER(4);
	
	private int chairsNumber;
	
	private TableType(int chairsNumber) {
		this.chairsNumber = chairsNumber;
	}
	
	public int getChairsNumber() {
		return this.chairsNumber;
	}
}
