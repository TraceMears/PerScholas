package dao.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeTrue;

import org.junit.Test;

import file.order.dao.classes.InvalidQuantityException;
import file.order.dao.classes.Order;
import file.order.dao.classes.OrderDAO;

public class OrderDAOTests {
	
	@Test
	public void testConnection( ){
		assumeTrue(OrderDAO.testConnection());
	}
	
	@Test
	public void testRetrieve() throws InvalidQuantityException {
		Order o = OrderDAO.retrieveByName("dishwasher", 2);
		assertThat(o.getName(), equalTo("dishwasher"));
		
		
		assertThat( OrderDAO.retrieveByName("dish washer", 2), equalTo(null));
	}
	
}
