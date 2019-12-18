package basic.classes;

public class InsufficientQuantityException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InsufficientQuantityException() {};
	public InsufficientQuantityException(String message) {
		super(message);
	}
}