package javapratice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaPractice {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username(must be 8 characters)");
		String user = sc.nextLine();
		
		System.out.println("Enter password(must be 6 char and contain letters and numbers");
		String pass = sc.nextLine();
		
		String numRegEx = ".*[0-9].*";
		String letterRegEx = ".*[a-zA-Z].*";
		
		Pattern numPat = Pattern.compile(numRegEx);
		Pattern letterPat = Pattern.compile(letterRegEx);
		
		if(user.length() == 8) {
			System.out.println("Valid username");
		}
		else {
			System.out.println("Invalid username");
		}
		Matcher numMatcher = numPat.matcher(pass);
		Matcher letMatcher = letterPat.matcher(pass);
		
		boolean num = numMatcher.matches();
		boolean let = letMatcher.matches();
		
		if(pass.length() == 6 && num && let) {
			System.out.println("valid password");
		}
		else {
			System.out.println("Invalid password");
		}
		
		sc.close();
	}

}
