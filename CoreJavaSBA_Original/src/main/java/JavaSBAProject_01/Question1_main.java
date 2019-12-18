package JavaSBAProject_01;

import java.util.Scanner;

public class Question1_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Type whatever you want to print to console");
		
		String output = sc.nextLine();	
		System.out.println(output);
		
		sc.close();

	}

}
