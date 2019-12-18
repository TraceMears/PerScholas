package dao.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import file.order.dao.classes.InvalidQuantityException;
import file.order.dao.classes.Order;
import file.order.dao.classes.OrderFileHandler;

public class FileHandlerTest {
	
	private static List<Order> l;
	
	@BeforeClass
	public static void setup() throws FileNotFoundException, IOException, NumberFormatException, InvalidQuantityException {
		l = OrderFileHandler.readOrder("orders.txt");
	}
	
	@Test
	public void fileOutputTest() {
		assertThat(l.get(2).getName(), equalTo("couch"));
	}
	
	@Test(expected = FileNotFoundException.class)
	public void throwFileNotFoundException() throws Exception {
		/* The following line would be replaced with code that would be 
		 * expected to throw a FileNotFoundException.
		 */
		
		OrderFileHandler.readOrder("randomFileName.txt");	
	}
	
}
