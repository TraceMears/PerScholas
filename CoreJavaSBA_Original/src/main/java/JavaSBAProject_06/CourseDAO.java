package JavaSBAProject_06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CourseDAO {
	
	//connection check
	public static void connect() {
		
		try {
			MariaDBConnection connect = new MariaDBConnection();
			Connection conn = null;
			conn = connect.getConnection();
			if(conn != null) {
				System.out.println("Connected");
			}
			conn.close();
		}
		catch(Exception e) {
			System.out.println("Failed to connect");
		}
	}
	
	//insert method
	public static void createCourse(String courseName, String courseDescription) {
				
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//create insert query format
		String insertQuery = "INSERT INTO course (name, description) VALUES (?, ?)";
		
		try {
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(insertQuery);
			
			//setting the column values of the insert query
			stmt.setString(1, courseName);
			stmt.setString(2, courseDescription);
			
			//executing insert query
			stmt.executeUpdate();			
			//close connection
			conn.close();
			System.out.println("Inserted " + courseName);
		}
		catch(Exception e) {
			System.out.println("Insert failed");
		}
				
	}
	
	//method to delete a course from table on ID
	public static void deleteCourse(int ID) {
		
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//create delete query format
		String deleteQuery = "DELETE FROM course WHERE ID=?";
		
		try {
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(deleteQuery);
			
			//setting the column values of the delete query
			stmt.setInt(1, ID);			
			
			//executing delete query
			stmt.execute();			
			//close connection
			conn.close();
			System.out.println("Course deleted");
		}
		catch(Exception e) {
			System.out.println("Delete failed");
		}
				
	}
	
	//update a course by ID
	public static void updateCourse(int ID, String newName, String newDescription) {
		
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//create update query format
		String updateQuery = "UPDATE course SET name=? , description=? WHERE ID=?";
		
		try {
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(updateQuery);
			
			//setting the column values of the delete query
			stmt.setString(1, newName);
			stmt.setString(2, newDescription);
			stmt.setInt(3, ID);
			
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
	
	//update first course
	public static void updateFirstCourse(String newName, String newDescription) {
		
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//create update query for first entry
		String updateQuery = "UPDATE course SET name=? , description=? WHERE ID = (SELECT ID FROM course ORDER BY ID LIMIT 1)";		
		try {
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(updateQuery);
			
			//setting the column values of the delete query
			stmt.setString(1, newName);
			stmt.setString(2, newDescription);
						
			//executing delete query
			stmt.execute();			
			//close connection
			conn.close();
			
			System.out.println("Update Succesful");
			
		}
		catch(Exception e) {
			System.out.println("Update failed");
		}
				
	}
	//retrieve and print all courses
	public static void retreiveAllCourses() {
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
				
		try {
			conn = connect.getConnection();
			Statement stmt = conn.createStatement();
			
			String query = "SELECT name, description FROM course";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				  String name = rs.getString("name");
				  String description = rs.getString("description");
				  System.out.println("Course name: " + name);
				  System.out.println("\tdescription: " + description);
				  System.out.println();
				}
			conn.close();
		}
		catch(Exception e) {
			System.out.println("Retreival failed");
		}
	}
	
	//retrieve single course based on name
	public static void retreiveByName(String nameQuery) {
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
				
		try {
			conn = connect.getConnection();
						
			String query = "SELECT name, description FROM course WHERE name = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, nameQuery);
			ResultSet rsT = stmt.executeQuery();
			if (rsT.next()) {
				  String name = rsT.getString("name");
				  String description = rsT.getString("description");
				  System.out.println("Course name: " + name);
				  System.out.println("\tCourse description: " + description);
						
			}

			  conn.close();
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getLocalizedMessage());
		}
	}
	
	public static void main(String[] args) {
		CourseDAO.retreiveByName("Algebra");
		
	}
	
}
