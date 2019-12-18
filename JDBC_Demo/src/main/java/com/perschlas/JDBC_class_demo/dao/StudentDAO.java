package com.perschlas.JDBC_class_demo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	
	Connection conn = null;
	MariaDBConnection connect = new MariaDBConnection();
	
	public void testConnection() {
		
		try {
			connect.getConnection();
			System.out.println("Conncted to MariaDB!");
		}
		catch(Exception e) {
			System.out.println("Database connection failed.");
		}
		
	}
	
	public void returnName_Grade() {
			
						
			try {
				conn = connect.getConnection();
				Statement stmt = conn.createStatement();
				
				String query = "SELECT name, score FROM scores";
				ResultSet rs = stmt.executeQuery(query);

				while (rs.next()) {
					  String Name = rs.getString("name");
					  String Score = rs.getString("score");
					  System.out.println(Name + "\t");
					  System.out.println(Score + "\n");
					}
				conn.close();
			}
			catch(SQLException e) {
				System.out.println(e.getLocalizedMessage());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}
	
	public static void main(String[] args) {
		StudentDAO s_dao = new StudentDAO();
		s_dao.returnName_Grade();
	}
}
