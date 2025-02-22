package classes.parameterized.tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

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
	public static boolean insertProduct(Product prod) {
			
		//create insert query format
		String insertQuery = "INSERT INTO product (name, price) VALUES (?, ?)";
		
		try {
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(insertQuery);
			
			//setting the column values of the insert query
			stmt.setString(1, prod.getProductName());
			stmt.setInt(2, prod.getPrice());
			
			//executing insert query
			stmt.executeUpdate();			
			stmt.close();
			
			System.out.println("Inserted product: " + prod.getProductName());
			return true;
		}
		catch(Exception e) {
			System.out.println("Insert failed");
			return false;
		}
				
	}
	
	//method to delete a course from table on ID
	public static boolean deleteProduct(int ID) {
		
		//create delete query format
		String deleteQuery = "DELETE FROM product WHERE id=?";
		
		try {
			
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(deleteQuery);
			
			//setting the column values of the delete query
			stmt.setInt(1, ID);			
			
			//executing delete query
			stmt.execute();	
			stmt.close();
			
			System.out.println("Product deleted");
			return true;
		}
		catch(Exception e) {
			System.out.println("Delete failed");
			return false;
		}
				
	}
	
	//method to delete a product from table on name
	public static boolean deleteProduct(String name) {
				
		//create delete query format
		String deleteQuery = "DELETE FROM product WHERE name=?";
		
		try {
			
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(deleteQuery);
			
			//setting the column values of the delete query
			stmt.setString(1, name);			
			
			//executing delete query
			stmt.execute();		
			stmt.close();
			
			System.out.println("Product deleted");
			return true;
		}
		catch(Exception e) {
			System.out.println("Delete failed");
			return false;
		}
				
	}
		
	//update a product by id
	public static boolean updateProduct(int id, String newName, int newPrice) {
		
		//create update query format
		String updateQuery = "UPDATE product SET name=? , price=? WHERE id=?";
		
		try {
			
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(updateQuery);
			
			//setting the column values of the update query
			stmt.setString(1, newName);
			stmt.setInt(2, newPrice);
			stmt.setInt(3, id);
			
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
	
	//retrieve and print all products
	public static List<Product> retreiveAllProducts() {
		
		try {
			
			Statement stmt = conn.createStatement();
			
			String query = "SELECT name, price FROM product";
			ResultSet rs = stmt.executeQuery(query);
			List<Product> productList = new ArrayList<Product>();
			
			while (rs.next()) {
				  String name = rs.getString("name");
				  int price = rs.getInt("price");
				  productList.add(new Product(name, price));
				}
			
			System.out.println(productList);
			stmt.close();
			rs.close();
			return productList;			
		}
		catch(Exception e) {
			System.out.println("Retreival failed");
			return null;
		}
	}
	
	//retrieve single product based on name
	public static boolean retreiveByName(String nameQuery) {
						
		try {
			
			String query = "SELECT name, price FROM product WHERE name = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, nameQuery);
			ResultSet rsT = stmt.executeQuery();
			if (rsT.next()) {
				  String name = rsT.getString("name");
				  int price = rsT.getInt("price");
				  if(name.equalsIgnoreCase(nameQuery)) {
					  System.out.println("Product name: " + name);
					  System.out.println("\tPrice: " + price);
				  }
				  else {
					  return false;
				  }
						
			}
			stmt.close();
			rsT.close();
			System.out.println();
			return true;
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getLocalizedMessage());
			return false;
		}
	}
	
//	public static void main(String[] args) {
//		boolean test = retreiveByName("tv");
//		System.out.println(test);
//	}
}
