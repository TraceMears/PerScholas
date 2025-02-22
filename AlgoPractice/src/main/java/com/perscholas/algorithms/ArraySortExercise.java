package com.perscholas.algorithms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArraySortExercise {

	
	public static void arrSort(int[] arr) {
		Arrays.parallelSort(arr);
		System.out.println("Min = " + arr[0]);
		System.out.println("Max = " + arr[arr.length-1]);
		System.out.println("Range = " + (arr[arr.length-1] - arr[0]));
	}
	
	public static void arrayComparator(int[] arr) {
		
		System.out.println("Choose which comparator you wish to search with(=, <, >)");
		Scanner sc = new Scanner(System.in);
		String c = sc.next();
		switch (c) {
		case "=":
			
			System.out.println("What value do you want to see if exists in array?");
			int equals = sc.nextInt();
			boolean test = IntStream.of(arr).anyMatch(x -> x==equals);
			if(test == true) {
				System.out.println("Your array contains your value");
			}
			else {
				System.out.println("Your array does not contain that value");
			}
			break;
			
		case "<":
			
			System.out.println("What value do you want to see how many elements in array are less than?");
			int lessThan = sc.nextInt();
			System.out.print("{");
			for(int x: arr) {
				if(x < lessThan) {
					System.out.print(x + " ");					
				}
			}
			System.out.print("}");
			System.out.println();
			break;
			
		case ">":
			
			System.out.println("What value do you want to see how many elements in array are greater than?");
			int greaterThan = sc.nextInt();
			System.out.print("{");
			for(int x: arr) {
				if(x > greaterThan) {
					System.out.print(x + " ");					
				}
			}
			System.out.print("}");
			System.out.println();
			break;	
			
		}		
		sc.close();
	}
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println("What size array do you wish to use?");
		Scanner sc = new Scanner(System.in);		
		int size = sc.nextInt();
			
		int[] testArray = new int[size];
		for(int i=0; i<size; i++) {
			testArray[i] = (int)(Math.random()*850);
		}
		
		arrSort(testArray);
		
		System.out.print("{");
		for(int x: testArray) {			
			System.out.print(x + " ");
		}
		System.out.print("}");
		System.out.println();
		
		
		arrayComparator(testArray);
		
		sc.close();

	}

}
