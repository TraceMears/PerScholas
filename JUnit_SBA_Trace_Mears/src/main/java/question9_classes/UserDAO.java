package question9_classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import question5_classes.User;
import question9_classes.MariaDBConnection;

public class UserDAO {
	
	public static MariaDBConnection connect = new MariaDBConnection();
	public static Connection conn = null;
	
	//method to connect
	public static boolean connect() {
		
		try {
			conn = connect.getConnection();
			if(conn != null) {
				System.out.println("Connected");
			}
			return true;
		}
		catch(Exception e) {
			System.out.println("Failed to connect");
			System.out.println(e);
			return false;
		}
	}
	
	//method to close connection
	public static boolean closeConnection() {
		
		try {
			if(conn != null) {
				conn.close();
				System.out.println("Connection closed");
			}			
			return true;
		}
		catch(Exception e) {
			System.out.println("Failed to close connection");
			return false;
		}
	}
	
	//insert method
	public static boolean insertUser(User u) {
			
		//create insert query format
		String insertQuery = "INSERT INTO user (name, password, javaScore, sqlScore) VALUES (?, ?, ?, ?)";
		
		try {
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(insertQuery);
			
			//setting the column values of the insert query
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getPassword());
			stmt.setDouble(3, u.getJavaScore());
			stmt.setDouble(4, u.getSqlScore());
			
			
			//executing insert query
			stmt.executeUpdate();			
			stmt.close();
			
			System.out.println("Inserted user: " + u.getName());
			return true;
		}
		catch(Exception e) {
			System.out.println("Insert failed");
			return false;
		}
				
	}
	
	//method to delete a user from table on ID
	public static boolean deleteUser(int ID) {
		
		//create delete query format
		String deleteQuery = "DELETE FROM user WHERE id=?";
		
		try {
			
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(deleteQuery);
			
			//setting the column values of the delete query
			stmt.setInt(1, ID);			
			
			//executing delete query
			stmt.execute();	
			stmt.close();
			
			System.out.println("User deleted");
			return true;
		}
		catch(Exception e) {
			System.out.println("Delete failed");
			return false;
		}
				
	}
	
	//method to delete a user from table on name
	public static boolean deleteUser(String name) {
		
		//create delete query format
		String deleteQuery = "DELETE FROM user WHERE name=?";
		
		try {
			
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(deleteQuery);
			
			//setting the column values of the delete query
			stmt.setString(1, name);			
			
			//executing delete query
			stmt.execute();		
			stmt.close();
						
			System.out.println("User deleted");
			return true;
		}
		catch(Exception e) {
			System.out.println("Delete failed");
			return false;
		}
				
	}
	
	//update a user by id
	public static boolean updateUser(int id, String newName, String newPass, double newJava, double newSql ) {
		
		//create update query format
		String updateQuery = "UPDATE user SET name=? , password=?, javaScore=?, sqlScore=? WHERE id=?";
		
		try {
			
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(updateQuery);
			
			//setting the column values of the update query
			stmt.setString(1, newName);
			stmt.setString(2, newPass);
			stmt.setDouble(3, newJava);
			stmt.setDouble(4, newSql);
			stmt.setInt(5, id);
			
			//executing query
			stmt.execute();	
			stmt.close();
			
			System.out.println("Update successful");
			return true;
		}
		catch(Exception e) {
			System.out.println("Update failed");
			return false;
		}
				
	}

	//retrieve and print all users
	public static List<User> retreiveAllProducts() {
		
		try {
			
			Statement stmt = conn.createStatement();
			
			String query = "SELECT * FROM user";
			ResultSet rs = stmt.executeQuery(query);
			List<User> userList = new ArrayList<User>();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String pass = rs.getString("password");
				double javaScore = rs.getDouble("javaScore");
				double sqlScore = rs.getDouble("sqlScore");
				userList.add(new User(id, name, pass, javaScore, sqlScore));
			}
			
			System.out.println(userList);
			stmt.close();
			rs.close();
			return userList;			
		}
		catch(Exception e) {
			System.out.println("Retreival failed");
			return null;
		}
	}
	
	//retrieve single user based on name
	public static boolean retreiveByName(String nameQuery) {
						
		try {
			
			String query = "SELECT name, password, javaScore, sqlScore FROM user WHERE name = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, nameQuery);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				  String name = rs.getString("name");
				  String pass = rs.getString("password");
				  double javaScore = rs.getDouble("javaScore");
				  double sqlScore = rs.getDouble("sqlScore");
				  
				  if(name.equalsIgnoreCase(nameQuery)) {
					  System.out.println("Product name: " + name);
					  System.out.println("\tPassword: " + pass);
					  System.out.println("\tJava Score: " + javaScore);
					  System.out.println("\tSQL Score: " + sqlScore);
				  }
				  else {
					  return false;
				  }
						
			}
			stmt.close();
			rs.close();
			System.out.println();
			return true;
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getLocalizedMessage());
			return false;
		}
	}
	
}
