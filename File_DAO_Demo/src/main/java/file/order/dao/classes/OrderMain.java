package file.order.dao.classes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class OrderMain {

	public static void main(String[] args) throws FileNotFoundException, IOException, NumberFormatException, InvalidQuantityException {
		
		List<Order> orderList = OrderFileHandler.readOrder("orders.txt");
		int sumTotal = 0;
		
		System.out.println("Order items:\n");
		for(Order o: orderList) {
			System.out.println(o);
			sumTotal += o.getOrderTotal();
		}
		
		System.out.println("\nOrder Total:\t$" + sumTotal);

	}

}
