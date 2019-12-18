package com.perscholas.JDBCLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginDAO {	
	
	//method to validate credentials with user/password combo as parameters
	public static boolean validateLogin(String userNameInput, String passInput) {		
		
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		try {			
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			Statement stmt = conn.createStatement();
			
			//creating a query then saving results from that query
			String query = "SELECT * FROM loginquery";
			ResultSet rs = stmt.executeQuery(query);
			
			//creating ArrayLists to store results of queries
			ArrayList<String> usernameList = new ArrayList<String>();
			ArrayList<String> passwordList = new ArrayList<String>();
			
			//loop to save all table entries into arrayLists to pass into the ArrayCheck object
			while (rs.next()) {
				  usernameList.add( rs.getString("User") );
				  passwordList.add( rs.getString("Password") );				  
			}
			//close database connection
			conn.close();
						
			//converting ArrayLists to arrays because I already wrote
			//the validate method with String array parameters
			String[] usernames = usernameList.toArray( new String[ usernameList.size() ] );
			String[] passwords = passwordList.toArray( new String[ passwordList.size() ] );
			
			//creating ArrayCheck object with user/password combo as parameters
			//to run validation on the object
			ArrayCheck aCheck = new ArrayCheck(userNameInput, passInput);			
						
			//run validate method and return the boolean to the servlet
			return aCheck.validate(usernames, passwords);
			
		}		
		catch(Exception e) {
			System.out.println("Connection failed");
			return false;
		}		
	}
	
	//method to add entries into table
	public static void createStudent(String username, String password) {
		
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//create insert query format
		String insertQuery = "INSERT INTO loginquery (User, Password) VALUES (?, ?)";
		
		try {
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(insertQuery);
			
			//setting the column values of the insert query
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			//executing insert query
			stmt.executeUpdate();			
			//close connection
			conn.close();
			
		}
		catch(Exception e) {
			System.out.println("Insert failed");
		}
				
	}
	
	//method to delete entries from table
	public static void deleteStudent(String username, String password) {
		
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//create insert query format
		String deleteQuery = "DELETE FROM loginquery WHERE User=? AND Password=?";
		
		try {
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(deleteQuery);
			
			//setting the column values of the delete query
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			//executing delete query
			stmt.execute();			
			//close connection
			conn.close();
			
		}
		catch(Exception e) {
			System.out.println("Delete failed");
		}
				
	}
	
	//method to update password in table
	public static void updateStudent(String username, String password, String newPass) {
		
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//create insert query format
		String updateQuery = "UPDATE loginquery SET Password=? WHERE User=? AND Password=?";
		
		try {
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(updateQuery);
			
			//setting the column values of the delete query
			stmt.setString(1, newPass);
			stmt.setString(2, username);
			stmt.setString(3, password);
			
			//executing delete query
			stmt.execute();			
			//close connection
			conn.close();
			
		}
		catch(Exception e) {
			System.out.println("Update failed");
		}
				
	}
	
}
