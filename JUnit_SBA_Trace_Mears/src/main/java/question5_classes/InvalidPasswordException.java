package question5_classes;

public class InvalidPasswordException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidPasswordException() {};
	public InvalidPasswordException(String message) {
		super(message);
	}
}
