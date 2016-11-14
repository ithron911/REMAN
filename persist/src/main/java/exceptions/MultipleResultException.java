package exceptions;

public class MultipleResultException extends Exception {

	private static final long serialVersionUID = -4563085725397901085L;

	public MultipleResultException() {
	}

	public MultipleResultException(String message) {
		super(message);
	}

}
