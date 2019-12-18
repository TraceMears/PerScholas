package JavaSBAProject_10;

public class Table extends Furniture {
	
	String shape;
	int length;
	
	public Table() {		
	}
	
	public Table(int productId, String name, String color, int quantity, String shape, int length) {
		this.productId = productId;
		this.name = name;
		this.color = color;
		this.quantity = quantity;
		this.shape = shape;
		this.length = length;
		this.price = this.calculatePrice();
	}
	
	public int calculatePrice() {
		if (this.length == 60) {
			return quantity * 200;
		}
		else if(this.length == 84) {
			return this.quantity * 450;
		}
		else {
			return 0;
		}
	}
}
