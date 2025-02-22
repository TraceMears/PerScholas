package mears.trace.classified_ads.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class Item {

	@Id
	@GeneratedValue
	private Integer itemId;
	
	@Size(min=2, max=50,  message="Name must be between 2 and 50 characters long.")
	@NotBlank(message="Item name is required.")
	private String name;

	@Min(value = 1)
	@Max(value = 10000)
	private Integer price;	
	
	private Integer status;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}

	public void orderItem() {
		this.status = 1;
	}	
	
	public void cancelOrder() {
		this.status = 0;
	}
}
