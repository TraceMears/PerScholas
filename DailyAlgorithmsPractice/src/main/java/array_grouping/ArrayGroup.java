package array_grouping;

import java.util.ArrayList;

public class ArrayGroup {
	
	public static void arrGroup(int[] arr, int subarraySize) {
		
		int numOfArrays = (int) Math.ceil( ((double) (arr.length))/ (double) subarraySize);
		
		ArrayList<Integer> array1 = new ArrayList<Integer>();
		for(int a: arr) {
			array1.add(a);
		}
		
		System.out.print("{");
		
		for(int x=1; x<=numOfArrays; x++) {
			System.out.print("[");	
			for(int i=0; i<subarraySize; i++) {
				int pick = (int) (Math.random()*array1.size());
				if (array1.size() != 0) {
					if(i == subarraySize - 1) {
						System.out.print(array1.get(pick));
						array1.remove(pick);
					}
					else {
						System.out.print(array1.get(pick) + ", ");
						array1.remove(pick);
					}
				}
				else {
					if(i == subarraySize - 1) {
						System.out.print("null");
					}
					else {
						System.out.print("null, ");
					}
				}				
			}
			if(x==numOfArrays) {
				System.out.print("]");
			}
			else {
				System.out.print("], ");
			}
		}		
		System.out.print("}");		
	}
}
