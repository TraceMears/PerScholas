package question9;

import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;

import java.util.List;

import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;

import org.junit.BeforeClass;
import org.junit.Test;

import question5_classes.User;
import question9_classes.UserDAO;

import org.junit.AfterClass;

public class DAOTests {
	
	@BeforeClass
	public static void createConnection() {
		UserDAO.connect();
	}
	
	@AfterClass
	public static void closeConnection() {
		UserDAO.closeConnection();
	}
	
	@Test
	public void testRetrieveAll() {
		assumeThat(UserDAO.conn, not(equalTo(nullValue())));
		List<User> list = UserDAO.retreiveAllProducts();

		assertThat(list.get(0).getJavaScore(), equalTo(90.0));
		
	}
	
	@Test
	public void testRetreiveSingle() {
		assumeThat(UserDAO.conn, not(equalTo(nullValue())));
		
		assumeTrue(UserDAO.retreiveByName("salah"));
		
	}
	
	@Test
	public void testUpdate() {
		assumeThat(UserDAO.conn, not(equalTo(nullValue())));
		
		assumeTrue(UserDAO.updateUser(3, "salah", "sheber9876", 95.0, 95.0));
	}
	
	@Test
	public void testDelete() {
		assumeThat(UserDAO.conn, not(equalTo(nullValue())));
		
		assumeTrue(UserDAO.deleteUser("tom"));
	}

}
