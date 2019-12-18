package JavaSBAProject_07;

public class Car {
	int id;
	int price;
	String description;
	
	public Car(int id, int price, String description) {
		this.id = id;
		this.price = price;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getTax() {
		double tax = this.price * .06;
		return tax;
	}
	
	public double getLicenseFee() {
		double license = this.price * .015;
		return license;
	}
	
	public double getTotalCost() {
		double total = this.getTax() + 
				this.getLicenseFee() +
				150 +
				this.getPrice();
		return total;
	}
	
}
