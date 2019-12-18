package file.order.dao.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.MariaDBConnection;

public class OrderDAO {
	
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
	
	//retrieve product price of named product then output an Order object
	public static Order retrieveByName(String name, int quantity) throws InvalidQuantityException {
		
		if (quantity <1) {
			throw new InvalidQuantityException("must have a quantity greater than 0");
		}
		
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
				
		try {
			conn = connect.getConnection();
						
			String query = "SELECT price FROM product WHERE name = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, name);
			
			ResultSet rsT;
			if ((rsT = stmt.executeQuery()) == null) {
				return null;
			}
			System.out.println(rsT);
			
			int price = 0;
			if (rsT.next()) {
				  price = rsT.getInt("price");
				  System.out.println(price);
			}
			conn.close();
			System.out.println(new Order(name, price, quantity));
			return new Order(name, price, quantity);
					
		}
		catch(Exception e) {
			System.out.println("Retrieval failed");
			return null;
		}
	}
		
}
