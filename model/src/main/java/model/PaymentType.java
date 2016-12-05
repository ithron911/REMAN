package model;

public enum PaymentType {

	IN_CASH(0),
	WITH_CARD(1),
	ONLINE(2),
	COUPON(3);

	private int paymentType;

	private PaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public int getPaymentType() {
		return paymentType;
	}
}
