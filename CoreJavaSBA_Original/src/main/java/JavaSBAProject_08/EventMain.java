package JavaSBAProject_08;

import java.time.LocalDate;

//need a DB named Events with table names events at localhost:1234 to run program
public class EventMain {

	public static void main(String[] args) {
		
		LocalDate birthday = LocalDate.now();
		Event bDay = new Event(01, "Trace's birthday", "Birthday for Trace", birthday);
		EventDAO.createEvent(bDay);

	}

}
