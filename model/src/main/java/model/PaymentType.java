package model;

public enum PaymentType {

	CASH("cash"),
	BANKCARD("bankcard"),
	COUPON("coupon"),
	PAYPAL("paypal");

	private String paymentType;

	private PaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentType() {
		return paymentType;
	}
}
