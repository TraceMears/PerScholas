package javapratice;

import java.time.LocalDate;
import java.util.Scanner;

public class JavaPractice3 {

	public static void main(String[] args) {
		//create a LocalDate object from current date
		LocalDate currentDate = LocalDate.now();
		
		//create a scanner for input of DOB
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter DOB (DD/MM/YYYY)");		
		
		//save DOB input then close Scanner
		String dateOfBirth = sc.next();
		sc.close();
		
		//create an array from DOB input String using split on the '/'
		String[] arr = dateOfBirth.split("/");
		//using array, parse the Strings from the array into integers to save
		//them into a variable to later be compared
		int birthDayOfMonth = Integer.parseInt(arr[0]);
		int birthMonth = Integer.parseInt(arr[1]);
		int birthYear = Integer.parseInt(arr[2]);
		
		//use get____() methods on the LocalDate object to save the values 
		//into variables to be compared against the DOB values
		int currentDay = currentDate.getDayOfMonth();
		int currentMonth = currentDate.getMonthValue();
		int currentYear = currentDate.getYear();
		
		//set age to currentYear - birthYear
		int age = currentYear - birthYear;
		
		//if current month isn't past birthday month, subtract 1 from age
		if(currentMonth < birthMonth) {
			age -= 1;
		}
		//if current month is same as birthday month, check if day is less than
		//day of month from DOB, if yes subtract 1 from age 
		else if (currentMonth == birthMonth) {
			if(currentDay < birthDayOfMonth) {
				age -= 1;
			}
		}
		//print age
		System.out.println("Your age: " + age);		
	}
}
