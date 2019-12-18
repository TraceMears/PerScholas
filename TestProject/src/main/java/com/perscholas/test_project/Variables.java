package com.perscholas.test_project;

import java.util.Scanner;

public class Variables {

	public static void main(String[] args) {
		
		//open scanner for input
		Scanner input = new Scanner(System.in);
		
		//prompt for number of students to grade
		System.out.println("Enter number of students");
		//save number of students
		int students = input.nextInt();
		//create new array sized with number of grades
		int[] arr = new int[students];
		
		//prompt the grades to enter
		System.out.println("Please enter the " + students + " grades");
		
		//created index for displaying which number you're on
		int counter = 1;	
		
		//loop to read in the scanner inputs
		for (int index = 0; index<students; index++) {
			System.out.print(counter++ + ":");
			arr[index] = input.nextInt();
		}
		
		//close scanner
		input.close();
		
		//calling the sorting method on array saved from input
		arrSort(arr);
		
		//printing out min and max
		System.out.println("miniumum:");
		System.out.println(arr[0]);
		System.out.println("maxiumum:");
		System.out.println(arr[arr.length -1]);	
		
		
		System.out.println("Grades:");
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
	
	//sorting method for an array input(uses BubbleSort)
	public static void arrSort(int[] arSort) {
		for (int i=0; i<arSort.length; i++) {
			for(int j=arSort.length-1; j>i; j--) {
				if(arSort[j] < arSort[j-1]) {
					int temp = arSort[j];
					arSort[j] = arSort[j-1];
					arSort[j-1] = temp;				
				}
			}
		}
	}
}
