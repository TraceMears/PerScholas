package JavaSBAProject_07;

import java.util.ArrayList;
import java.util.Scanner;

/* Write an application that includes a Car class with ID, price and description. 
 * Write a menu which allows the user to select a car to buy and print the invoice to the console.  
 * The invoice should include tax (6%), title fee ($150), and license fee (1.5%) along with purchase total */
public class CarApp {

	public static void main(String[] args) {
		
		ArrayList<Car> carList = new ArrayList<Car>();
		Car car1 = new Car(00, 5000, "Bad car");
		Car car2 = new Car(01, 15000, "Decent car");
		Car car3 = new Car(02, 25000, "Pretty nice car");
		Car car4 = new Car(03, 40000, "Really nice car");
		
		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
		carList.add(car4);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Select car from menu(enter ID #): ");
		for (int i = 0; i<carList.size(); i++) {
			System.out.println("Car ID: " + carList.get(i).getId());
			System.out.println("\tPrice: " + carList.get(i).getPrice());
			System.out.println("\tDescription: " + carList.get(i).getDescription());
		}
		
		int choice = scan.nextInt();
				
		System.out.println("Invoice:");
		System.out.println("\tPrice: $" + carList.get(choice).getPrice());
		System.out.println("\tTax: $" + carList.get(choice).getTax());
		System.out.println("\tTitle Fee: $150");
		System.out.println("\tLicense Fee: $" + carList.get(choice).getLicenseFee());
		System.out.println("\tTotal cost: $" + carList.get(choice).getTotalCost());
		
		scan.close();
	}

}
