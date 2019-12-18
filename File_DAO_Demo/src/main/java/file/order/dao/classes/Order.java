package file.order.dao.classes;

public class Order {
	
	private String productName;
	private int productPrice;
	private int quantity;
	
	public Order(String name, int price, int quantity) {
		this.productName = name;
		this.productPrice = price;
		this.quantity = quantity;
	}
	
	public int getOrderTotal() {
		return this.productPrice * this.quantity;
	}
	
	public String getName() {
		return this.productName;
	}

	@Override
	public String toString() {
		return "Item: " + productName + 
				"\n\tPrice= $" + productPrice + "\t quantity=" + quantity + 
				"\n\tItem Total: $" + this.getOrderTotal() + "\n";
	}
	
	
}
