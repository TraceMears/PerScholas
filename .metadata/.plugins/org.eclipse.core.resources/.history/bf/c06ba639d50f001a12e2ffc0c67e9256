package mears.trace.stats_application.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mears.trace.stats_application.models.Fighter;


public class FighterDAO {

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
	
	//insert method
	public static boolean insertFighter(Fighter f) {
				
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//create insert query format
		String insertQuery = "INSERT INTO fighter (name, SLpM, SApM, TDpF, subPF, koPF, FinRate) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(insertQuery);
			
			//setting the column values of the insert query
			stmt.setString(1, f.getName());
			stmt.setDouble(2, f.getSigLpm());
			stmt.setDouble(3, f.getSigApm());
			stmt.setDouble(4, f.getTdpF());
			stmt.setDouble(5, f.getSubpF());
			stmt.setDouble(6, f.getKoPF());
			stmt.setDouble(7, f.getKoPF());
			
			//executing insert query
			stmt.executeUpdate();			
			//close connection
			conn.close();
			System.out.println("Inserted " + f.getName());
			return true;
		}
		catch(Exception e) {
			System.out.println("Insert failed");
			return false;
		}
				
	}
	
	//delete with id input
	public static boolean deleteFighter(int id) {
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//create delete query format
		String deleteQuery = "DELETE FROM fighter WHERE id=?";
		
		try {
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(deleteQuery);
			
			//setting the column values of the delete query
			stmt.setInt(1, id);			
			
			//executing delete query
			stmt.execute();			
			//close connection
			conn.close();
			System.out.println("Fighter deleted");
			return true;
		}
		catch(Exception e) {
			System.out.println("Delete failed");
			return true;
		}
	}
	
	//delete with name input
	public static boolean deleteFighter(String name) {
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//create delete query format
		String deleteQuery = "DELETE FROM fighter WHERE name=?";
		
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
			System.out.println("Fighter deleted");
			return true;
		}
		catch(Exception e) {
			System.out.println("Delete failed");
			return true;
		}
	}
	
	//update a fighter by name
	public static boolean updateFighter(String name, Double SLpM, Double SApM, Double TDpF, Double subPF, Double koPF, Double finRate) {
		
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//create update query format
		String updateQuery = "UPDATE fighter SET SLpM=?, SApM=?, TDpF=?, subPF=?, koPF=?, finRate=? WHERE name=?";
		
		try {
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(updateQuery);
			
			//setting the column values of the delete query
			stmt.setDouble(1, SLpM);
			stmt.setDouble(2, SApM);
			stmt.setDouble(3, TDpF);
			stmt.setDouble(4, subPF);
			stmt.setDouble(5, koPF);
			stmt.setDouble(6, finRate);
			stmt.setString(7, name);
			
			//executing delete query
			stmt.execute();			
			//close connection
			conn.close();
			System.out.println("Update successful");
			return true;
		}
		catch(Exception e) {
			System.out.println("Update failed");
			return false;
		}
				
	}
	
	//retrieve single fighter based on name
	public static Fighter retrieveByName(String nameQuery) {
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
				
		try {
			conn = connect.getConnection();
			Fighter f = null;		
			String query = "SELECT id, name, SLpM, SApM, TDpF, subPF, koPF, finRate FROM fighter WHERE name=?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, nameQuery);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Double sigL = rs.getDouble("SLpM");
				Double sigA = rs.getDouble("SApM");
				Double td = rs.getDouble("TDpf");
				Double sub = rs.getDouble("subPF");
				Double ko = rs.getDouble("koPF");
				Double fin = rs.getDouble("finRate");
				System.out.println("Fighter name: " + name);
				f = new Fighter(id, name, sigL, sigA, td, sub, ko, fin);
			}
			  conn.close();			  
			  return f;
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getLocalizedMessage());
			return null;
		}
	}
	
	//retrieve list of fighter objects from list of names
	public static ArrayList<Fighter> retrieveListOfFighters(ArrayList<String> arrL) {
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
				
		try {
			conn = connect.getConnection();
			
			ArrayList<Fighter> list = new ArrayList<Fighter>();
			
			for(String s: arrL) {				
				list.add(retrieveByName(s));
				
				System.out.println("retrieved fighter :" + s);			
			}			
			conn.close();
			return list;
		}
		catch(Exception e) {
			System.out.println("Retreival failed");
			return null;
		}
	}
}
