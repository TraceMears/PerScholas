package JavaSBAProject_02;

import java.util.Scanner;

public class NumberGuesser {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int randomNum = (int) (Math.random() * 100);	
		boolean correctGuess = false;
		int count = 0;
		
		while(correctGuess == false) {
			System.out.println("Guess a number between 0-100");
			int guess = sc.nextInt();
			
			if(guess < randomNum) {
				System.out.println("You guessed too low, try again");
				count++;
			}
			else if(guess > randomNum) {
				System.out.println("You guessed too high, try again");
				count++;
			}
			else if (guess == randomNum) {
				System.out.println("You guessed correct! Congratulations");
				System.out.println("It took you " + count + " attempts");
				correctGuess = true;
			}
			
			
			
		}
	sc.close();
	}

}
