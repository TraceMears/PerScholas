package JavaSBAProject_05;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* 
 * Create an application that includes a menu to add or remove strings to a list and 
 * a menu item that displays the list and a final menu item to quit. 
*/
public class ListDisplay {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = -1;
		
		ArrayList<String> stringList = new ArrayList<String>();
			
		while(choice != 4) {
			
			displayOptions();
			
			choice = scan.nextInt();
			
			switch(choice) {
				case 1: 
					System.out.println("Type the string you wish to input");
					String addString = scan.next();
					stringList.add(addString);
					break;
				case 2:
					System.out.println("Type the string you wish to remove");
					String removeString = scan.next();
					stringList.remove(removeString);
					break;
				case 3:
					System.out.println(Arrays.toString(stringList.toArray()));
					System.out.println();
					break;
				case 4:
									
			}		
		}		
		scan.close();
	}
	
	public static void displayOptions() {
		System.out.println("Choose from menu:\n" +
						"1. Add String to List\n" +
						"2. Remove String from List\n" +
						"3. Display list\n" + 
						"4. Exit menu\n"	
				);
	}
}
