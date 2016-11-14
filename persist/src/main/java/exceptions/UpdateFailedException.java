package exceptions;

public class UpdateFailedException extends Exception{

	private static final long serialVersionUID = -4504604991698515289L;

	public UpdateFailedException() {
	}

	public UpdateFailedException(String message) {
		super(message);
	}
}
