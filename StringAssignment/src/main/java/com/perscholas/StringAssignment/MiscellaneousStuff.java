package com.perscholas.StringAssignment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MiscellaneousStuff {

	public static void main(String[] args) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm a");
			
		System.out.println(dtf.format(LocalDateTime.now()));
	}
}
