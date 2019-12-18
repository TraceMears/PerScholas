package junit.test.exercises;

import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;

import java.util.List;

import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;

import org.junit.BeforeClass;
import org.junit.Test;

import classes.parameterized.tests.Product;

import org.junit.AfterClass;

import classes.parameterized.tests.ProductDAO;

public class DAOBasicTests {
	
	@BeforeClass
	public static void createConnection() {
		ProductDAO.connect();
	}
	
	@AfterClass
	public static void closeConnection() {
		ProductDAO.closeConnection();
	}
	
	@Test
	public void testRetrieveAll() {
		assumeThat(ProductDAO.conn, not(equalTo(nullValue())));
		List<Product> list = ProductDAO.retreiveAllProducts();
		
		assertThat(list.get(2).getPrice(), equalTo(400));
		
	}
	
	@Test
	public void testRetreiveSingle() {
		assumeThat(ProductDAO.conn, not(equalTo(nullValue())));
		
		assumeTrue(ProductDAO.retreiveByName("xbox"));
		
	}
	
	@Test
	public void testUpdate() {
		assumeThat(ProductDAO.conn, not(equalTo(nullValue())));
		
		assumeTrue(ProductDAO.updateProduct(5, "mattress", 600));
	}
	
	@Test
	public void testDelete() {
		assumeThat(ProductDAO.conn, not(equalTo(nullValue())));
		
		assumeTrue(ProductDAO.deleteProduct("bedframe"));
	}
	
	
	
}
