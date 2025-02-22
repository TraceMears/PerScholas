package mears.trace.stats_application.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mears.trace.stats_application.models.Fighter;
import mears.trace.stats_application.models.User;

public class UserDAO {

	//connection check
	public static boolean testConnection() {
		
		try {
			MariaDBConnection connect = new MariaDBConnection();
			Connection conn = null;
			conn = connect.getConnection();
			if(conn != null) {
				System.out.println("Connected");
			}
			conn.close();
			return true;
		}
		catch(Exception e) {
			System.out.println("Failed to connect");
			return false;
		}
	}
	
	//method to validate a user login
	public static boolean login(String username, String password) {
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//query to compare password
		String getPass = "SELECT password FROM user WHERE username=?";
		
		try {
			conn = connect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(getPass);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			boolean flag = false;
			if(rs.next()) {
				if(password.equals(rs.getString(1))) {
					flag = true;
				}
			}
			stmt.close();
			return flag;
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getLocalizedMessage());
			return false;
		}
	}
	
	//method to register a new user
	public static boolean createUser(User u) {
				
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//create insert query format
		String insertQuery = "INSERT INTO user (username, password) VALUES (?, ?)";
		
		try {
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(insertQuery);
			
			//setting the column values of the insert query
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
						
			//executing insert query
			stmt.executeUpdate();			
			//close connection
			conn.close();
			System.out.println("Inserted " + u.getUsername());
			return true;
		}
		catch(Exception e) {
			System.out.println("Insert failed");
			return false;
		}				
	}
	
	//delete with name input
	public static boolean deleteUser(String name) {
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//create delete query format
		String deleteQuery = "DELETE FROM user WHERE username=?";
		
		try {
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(deleteQuery);
		
		//setting the column values of the delete query
		stmt.setString(1, name);			
		
		//executing delete query
		stmt.execute();			
		//close connection
		conn.close();
		System.out.println("User deleted");
		return true;
		}
		catch(Exception e) {
			System.out.println("Delete failed");
			return true;
		}
	}
	
	//update a user's password
	public static boolean updateUserPassword(String username, String newPass) {
		
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//create update query format
		String updateQuery = "UPDATE user SET password=? WHERE username=?";
		
		try {
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(updateQuery);
			
			//setting the column values of the delete query
			stmt.setString(1, newPass);
			stmt.setString(2, username);
						
			//executing delete query
			stmt.execute();			
			//close connection
			conn.close();
			System.out.println("Updated password successfully");
			return true;
		}
		catch(Exception e) {
			System.out.println("Update failed");
			return false;
		}
				
	}
	
	//helper method - get user's count(checking the count for use in other methods)
	public static int getUserCount(String username) {
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//query to get count password
		String getCount = "SELECT counter FROM user WHERE username=?";
		
		try {
			conn = connect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(getCount);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			int count = -1;
			if(rs.next()) {
				count = rs.getInt(1);
			}
			stmt.close();
			return count;
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getLocalizedMessage());
			return -1;
		}
	}
	
	//incremement user's count
	public static boolean incrementUserCount(String username) {
		
		int count = getUserCount(username);
		if(count >= 0 &&  count <5) {			
		}
		else {
			return false;
		}
		int setCount =+ 1;
		
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//query to get count password
		String incrementCount = "UPDATE user SET count=? WHERE username=?";
		
		try {
			conn = connect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(incrementCount);
			stmt.setInt(1, setCount);
			stmt.setString(2, username);
			stmt.executeQuery();
			
			return true;
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getLocalizedMessage());
			return false;
		}
	}
	
	
	
	//helper method - get user's id based on username
	public static int getUserID(String username) {
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//query to get count password
		String getCount = "SELECT id FROM user WHERE username=?";
		
		try {
			conn = connect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(getCount);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			int id = -1;
			if(rs.next()) {
				id = rs.getInt(1);
			}
			stmt.close();
			return id;
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getLocalizedMessage());
			return -1;
		}
	}
	
	//method to add fighter to favorites list
	public static boolean addToFavorites(String username, String fighterName) {
		
		int count = getUserCount(username);
		if(count >= 0 &&  count <5) {			
		}
		else {
			return false;
		}
		
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//get the ID of both entities
		Fighter f = FighterDAO.retrieveByName(fighterName);	
		int getFighterId = f.getId();
		int getUserID = getUserID(username);
				
		String insertQuery = "INSERT INTO favorites (userID, fighterID, number) VALUES (?, ?, ?)";
		
		try {
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(insertQuery);
			
			//setting the column values of the insert query
			stmt.setInt(1, getUserID);
			stmt.setInt(2, getFighterId);
			stmt.setInt(3, (count+1));
						
			//executing insert query
			stmt.executeUpdate();			
			//close connection
			conn.close();
			incrementUserCount(username);
			System.out.println("Added to favorites");
			return true;
		}
		catch(Exception e) {
			System.out.println("Insert failed");
			return false;
		}			
	}
	
	
}
