package projectDAOs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import classes.User;

public class UserDAO {
	
	static Connection conn = null;
	static MariaDBConnection connect = new MariaDBConnection();
	
	public static void testConnection() {
		
		try {
			conn = connect.getConnection();
			if(conn != null) {
				System.out.println("Connected");
			}
		}
		catch(Exception e) {
			e.getMessage();
			System.out.println("Database connection failed.");
		}
		
	}
	
	public static boolean validateLogin(String username, String password) {

		//create query format
		String query = "SELECT password FROM users WHERE username=?";
		
		try {
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			//setting the column values of the query
			stmt.setString(1, username);
			//executing delete query
			ResultSet rs = stmt.executeQuery();
			String pass = null;
			while (rs.next()) {
				  pass = rs.getString("password");
			}
						
			//close connection
			conn.close();
			
			if(password.equals(pass)) {
				System.out.println("Logged in");
				return true;
			}
			else {
				System.out.println("Login failed");
				System.out.println("this one");
				return false;
			}
		}
		catch(Exception e) {
			System.out.println("Login failed");
			System.out.println(e.getMessage());
			return false;
		}
				
	}
	
	public static User createUser(String username, String password, Date dob) {
		//create insert query format
		String insertQuery = "INSERT INTO users (username, password, userDOB) VALUES (?, ?, ?)";
		
		try {
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			conn = connect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(insertQuery);
			//setting the column values of the insert query
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setDate(3, dob);		
			
			//executing insert query
			stmt.executeUpdate();			
			stmt.close();
			
			User u = new User(username, password, dob);
			
			System.out.println("Inserted user: " + u.getUsername());
			return u;
		}
		catch(Exception e) {
			System.out.println("Insert failed");
			return null;
		}
	}
	//update a user by ID
	public static void updateUser(User u) {
		
		//create update query format
		String updateQuery = "UPDATE users SET name=? , password=? WHERE id=?";
		
		try {
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(updateQuery);
			
			//setting the column values of the delete query
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			stmt.setInt(3, u.getUserId());
			
			//executing delete query
			stmt.execute();			
			//close connection
			conn.close();
			System.out.println("Update successful");
		}
		catch(Exception e) {
			System.out.println("Update failed");
		}
				
	}
	
	public static int getUserId(String name) {
		//create query format
		String query = "SELECT id FROM users WHERE username=?";
		
		try {
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			//setting the column values of the query
			stmt.setString(1, name);
			//executing delete query
			ResultSet rs = stmt.executeQuery();
			
			int id = -1;
			while (rs.next()) {
				  id = rs.getInt("id");
			}						
			//close connection
			conn.close();
			
			return id;
			
		}
		catch(Exception e) {
			System.out.println("get id failed");
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	public static void main(String[] args) {
		Date d = new Date(System.currentTimeMillis());
		createUser("trace", "mears", d);
	}
}
