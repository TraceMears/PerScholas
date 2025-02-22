package question8;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import question8_classes.Product;

public class MockTest {
	
	Product mockProduct = Mockito.mock(Product.class);
	
	@Test
	public void test() {
		when(mockProduct.getName()).thenReturn("Trace");
		assertThat(mockProduct.getName(), equalTo("Trace"));
	}
	

}
