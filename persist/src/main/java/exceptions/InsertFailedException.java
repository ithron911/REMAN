package exceptions;

public class InsertFailedException extends Exception {

	private static final long serialVersionUID = 8020863044822308460L;

	public InsertFailedException() {
	}

	public InsertFailedException(String message) {
		super(message);
	}
}
