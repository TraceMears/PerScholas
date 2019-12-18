package junit.test.exercises;

import classes.parameterized.tests.Product;
import classes.parameterized.tests.ProductDAO;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

//Annotate class with @RunWith(Parameterized.class)
@RunWith(Parameterized.class)
public class ProductDAOParameterizedTest {
		// Declare attributes
		private static Product prod;
		private String name;
		private Integer price;
		@SuppressWarnings("unused")
		private Boolean confirmation;

		/* Create the constructor. The order of arguments in the parentheses
		 * determines the parameter position in the two-dimensional Object arrays.
		 * Parameter1 = argument num1, Parameter2 = argument num2,
		 * Parameter3 = argument testSum, Parameter4 = argument confirmation*/
		public ProductDAOParameterizedTest(String name, Integer price, Boolean confirmation) throws IllegalArgumentException {
			this.name = name;
			this.price = price;
			this.confirmation = confirmation;
		}
		
		

		/* Set up the parameters. The confirmation parameter is null and will
		 * be assigned in the actual test method depending on accuracy of
		 * the addition result. */
		@Parameters()
	    public static Collection<Object[]> data() {
	        return Arrays.asList(
	                new Object[][] {
	                		{ "couch", 1500, true },
	                		{ "dishwasher", 900, true },
	                		{ "lawnmower", 400, true }
	                		});
	    }

	    @BeforeClass
	    public static void setUp() {
	    	ProductDAO.connect();
	    }
		
	    
	    // Run the test
	    @Test
	    public void DAOInsertTest() throws Exception {
	    	prod = new Product(name, price);
	    		    	
	    	assertThat(ProductDAO.insertProduct(prod), equalTo(confirmation));
	    	
	    }
}
