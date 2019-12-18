package file.order.dao.classes;

public class InvalidQuantityException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidQuantityException() {};
	public InvalidQuantityException(String message) {
		super(message);
	}
}