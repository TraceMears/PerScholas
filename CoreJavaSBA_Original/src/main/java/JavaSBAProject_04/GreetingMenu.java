package JavaSBAProject_04;

import java.util.Scanner;

/* Create a simple menu application with 4 options. Prompt the user to make a selection. 
 * Each option will print a string: “Good morning.”, “Good afternoon”,  “Good evening” and “Good night”. 
 * If the user selects option 4 (“Good night.”) then the application will end. */
public class GreetingMenu {

	public static void main(String[] args) {
		String greet1 = "Good morning";
		String greet2 = "Good afternoon";
		String greet3 = "Good evening";
		String greet4 = "Good night";
		
		int choice = -1;
		Scanner scan = new Scanner(System.in);
		
		while(choice != 4) {
			System.out.println("Choose a greeting(1-4), choose 4 to exit menu");
			choice = scan.nextInt();
			
			switch(choice) {
				case 1:
					System.out.println(greet1 + "\n");
					choice = 1;
					break;
				case 2: 
					System.out.println(greet2 + "\n");
					choice = 2;
					break;
				case 3:
					System.out.println(greet3 + "\n");
					choice = 3;
					break;
				case 4: 
					System.out.println(greet4 + "\n");
					choice = 4;
					break;
				default:
					System.out.println("Invalid choice, please choose again\n");
					break;			
			}	
		}
		scan.close();
	}
}