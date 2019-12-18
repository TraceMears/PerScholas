package org.platform.helloworld;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fizzBuzz(100);
		}
	
	
	public static void fizzBuzz(int g) {
		for (int a=1; a<=g; a++) {
		
			if(a%3==0 && a%5==0) {
				System.out.println("FizzBuzz");
				
			}
			
			else if (a%3==0) {
				System.out.println("Fizz");
				
			} 
			else if(a%5==0) {
				System.out.println("Buzz");
				
			}			
			
			else {
				System.out.println(a);
				
			}
		
		}
	}

}
