package com.perscholas.JDBCLogin;

public class ArrayCheck {
	
	//storing inputted user/pass combo as field values to check against arrays in validate method
	String user;
	String pass;
	
	//creating constructor using the user/pass combo you want to validate
	public ArrayCheck(String u, String p) {
		this.user = u;
		this.pass = p;
	}
	
	//method to validate if user/pass combo exists in the array parameters
	public boolean validate(String[] names, String[] passwords) {
		
		//looping through array to see if username exists in the names array
		for (int i=0; i<names.length; i++) {
			if ( names[i].equals(user) ) {
				//if name is found in the name array, check the corresponding password element
				//to see if entered password corresponds to username, return true if true
				if ( passwords[i].equals(pass) ) {
					return true;
				}
			}
		}
		//return false if combo not found
		return false;
	}	
}

