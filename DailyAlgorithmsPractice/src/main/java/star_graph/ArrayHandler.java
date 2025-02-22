package star_graph;

import java.util.Arrays;

public class ArrayHandler {
	
	public static void printStarGraph(int[] arr) {
		int level = Arrays.stream(arr).max().getAsInt();
		for(int i=level; i>0; i--) {
			for(int j=0; j<arr.length; j++) {
				if(arr[j] >= i) {
					System.out.print("*\t");
				}
				else {
					System.out.print(" \t");
				}
			}
			System.out.println();
		}
	}	
}
