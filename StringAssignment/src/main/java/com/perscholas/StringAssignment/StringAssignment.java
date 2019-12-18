package com.perscholas.StringAssignment;

public class StringAssignment {

	public static void main(String[] args) {
		System.out.println("Exercise 1: ");
		String test1 =  "Hello 2019 QE02!";
		System.out.println(test1.substring(2, 9));
		System.out.println();
		
		System.out.println("Exercise 2 - part 1");
		String stringA = new String("red,green,blue;square,triangle,circle;dog,cat,bird");
		StringAssignment stringAs = new StringAssignment(stringA);
		
		stringAs.split1();		
		System.out.println();
		
		System.out.println("Exercise 2 - part 2");
		stringAs.split2();
	}

	
	String str;
	
	public StringAssignment(String string) {
		this.str = string;
	}
	
	
	public String[] split1() {
		String[] split1 = str.split(";");
		for(int i=0; i<split1.length; i++) {
			System.out.println(split1[i]);
		}
		
		return split1;
		
	}
	
	public String[][] split2() {
		String[] split2 = str.split(";");
		
		String[][] dim2 = new String[3][3];
		
		for(int i=0; i<split2.length; i++) {
			String[] stringSplit = split2[i].split(",");
			for(int j=0; j<stringSplit.length; j++) {
				dim2[i][j] = stringSplit[j];
			}
		}
		
			for(Object[] row : dim2 ) {
				System.out.format("%-15s%-15s%-15s\n", row);
			}
		return dim2;	
	}
}
