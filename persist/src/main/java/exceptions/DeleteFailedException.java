package exceptions;

public class DeleteFailedException extends Exception {

	private static final long serialVersionUID = -7969298485974099505L;

	public DeleteFailedException() {
	}

	public DeleteFailedException(String message) {
		super(message);
	}
}
