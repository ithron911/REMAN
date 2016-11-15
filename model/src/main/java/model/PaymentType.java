package model;

public enum PaymentType {

	IN_CASH("inCash"),
	WITH_CARD("withCard"),
	ONLINE("online"),
	COUPON("coupon");

	private String paymentType;

	private PaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentType() {
		return paymentType;
	}
}
