package JavaSBAProject_08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class EventDAO {

	//method to add entries into table
	public static void createEvent(Event event) {
		
		//creating mariaDB connection and a Connection object to run queries on
		MariaDBConnection connect = new MariaDBConnection();
		Connection conn = null;
		
		//create insert query format
		String insertQuery = "INSERT INTO events (id, name, description, date) VALUES (?, ?, ?, ?)";
		
		try {
			//format Event.date to an sqlDate
			LocalDate date = event.getDate();
			java.sql.Date sqlDate = java.sql.Date.valueOf(date);
			
			//creating a local instance of the connection object and a statement object
			conn = connect.getConnection();
			//creating an instance of prepareStatement, calling 
			//prepareStatement method of connection object, with query as parameter
			PreparedStatement stmt = conn.prepareStatement(insertQuery);
			
			//setting the column values of the insert query
			stmt.setInt(1, event.getID());
			stmt.setString(2, event.getName());
			stmt.setString(3, event.getDescription());
			stmt.setDate(4, sqlDate);
			
			//executing insert query
			stmt.executeUpdate();			
			//close connection
			conn.close();
			System.out.println("Event created");
			
		}
		catch(Exception e) {
			System.out.println("Insert failed");
		}
				
	}

}
