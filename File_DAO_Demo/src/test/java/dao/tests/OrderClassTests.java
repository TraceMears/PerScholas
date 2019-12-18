package dao.tests;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.object.HasToString.hasToString;
import static org.hamcrest.text.IsEmptyString.emptyOrNullString;

import org.junit.BeforeClass;
import org.junit.Test;

import file.order.dao.classes.Order;

public class OrderClassTests {
	
	private static Order o;
	
	@BeforeClass
	public static void setup() {
		o = new Order("computer", 1000, 1);
	}
	
	@Test
	public void getNameMethodTest() {
		assertThat(o.getName(), allOf(equalTo("computer"), not(equalTo("blue"))));
	}
	
	@Test
	public void getOrderTotalMethodTest( ) {
		assertThat(o.getOrderTotal(), equalTo(1000));
	}
	
	@Test
	public void toStringTest() {
		
		assertThat(o.toString(), not(is(emptyOrNullString())));
		
		String str = o.toString();
		assertThat(o, hasToString(str));
		
		assertThat(str, startsWith("Item: " + o.getName()));
		
		
	}
	
}
