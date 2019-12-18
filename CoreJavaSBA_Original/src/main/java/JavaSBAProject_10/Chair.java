package JavaSBAProject_10;

public class Chair extends Furniture {
	
	boolean customColor;
	
	public Chair() {
		
	}
	
	public Chair(int productId, String name, String color, int quantity, boolean custom) {
		this.productId = productId;
		this.name = name;
		this.color = color;
		this.quantity = quantity;
		this.customColor = custom;
		this.price = this.calculatePrice();
	}
	
	public int calculatePrice() {
		if (this.customColor == true) {
			return 200 * this.quantity;
		}
		else {
			return 150 * this.quantity;
		}
	}
	
	
	
}
