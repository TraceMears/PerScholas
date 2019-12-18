package JavaSBAProject_10;

import java.util.Scanner;

public class FurnitureMain {

	public static void main(String[] args) {
		int choice = -1;
		double runningTotal = 0;
		
		Scanner scan = new Scanner(System.in);
				
		while(choice != 3) {
			System.out.println("Would you like to add a chair or table to your order?");
			System.out.println("Press 1 for Table, 2 for Chair, 3 to checkout");
			
			choice = scan.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("What size table? (60 or 84)");
				int length = scan.nextInt();
				System.out.println("How many?");
				int quantTab = scan.nextInt();
				Table tab = new Table(1, "table", "who cares", quantTab, "doesn't matter", length);
				System.out.println(quantTab + " Table(s) added to cart, subtotal: $" + tab.getPrice());
				System.out.println("\tTax: $" + tab.getTax());
				runningTotal += tab.getTax() + tab.getPrice();
				System.out.println("\tRunning total: $" + runningTotal);
				break;
			case 2: 
				System.out.println("Do you want a custom color?(y or n)");
				String custCo = scan.next();
				boolean custom;
				if(custCo.equalsIgnoreCase("y") ) {
					custom = true;
				}
				else {
					custom = false;
				}
				System.out.println("How many?");
				int quantCh = scan.nextInt();
				Chair ch = new Chair(2, "chair", "random color", quantCh, custom);
				System.out.println(quantCh + " Chair(s) added to cart, subtotal: $" + ch.getPrice());
				System.out.println("\tTax: $" + ch.getTax());
				runningTotal += ch.getTax() + ch.getPrice();
				System.out.println("\tRunning total: $" + runningTotal);
				break;
			case 3: 
				break;				
			}			
		}
		scan.close();
		
		System.out.println("Order total: $" + runningTotal);
	}
}
