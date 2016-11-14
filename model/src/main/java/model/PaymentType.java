package model;

public enum PaymentType {

	INPLACE("inplace"),
	ONLINE("online");

	private String paymentType;

	private PaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentType() {
		return paymentType;
	}
}
