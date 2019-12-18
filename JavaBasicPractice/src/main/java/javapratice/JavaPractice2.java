package javapratice;

import java.util.Arrays;

public class JavaPractice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/* Write a program to sort the following int array in ascending order: {4, 2, 9, 13, 1, 0}. 
		 * Print the array in ascending order, print the smallest and the largest element of the array. 
		 * The output will look like the following:	Array in ascending order: 0, 1, 2, 4, 9, 13
		 */
		int[] arr = {4, 2, 9, 13, 1, 0};
		int swap = 0;
		
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = 0; j < arr.length-1; j++) {
				if (arr[j] > arr[j+1]) {
					swap = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = swap;
				}
			}
		}
		
		System.out.println("Sorted array: ");
		System.out.println(Arrays.toString(arr));
		
		
	
 	}

}
