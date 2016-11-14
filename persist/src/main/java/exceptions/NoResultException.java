package exceptions;

public class NoResultException extends Exception {

	private static final long serialVersionUID = 6062436285232820147L;

	public NoResultException() {
	}

	public NoResultException(String message) {
		super(message);
	}
}
