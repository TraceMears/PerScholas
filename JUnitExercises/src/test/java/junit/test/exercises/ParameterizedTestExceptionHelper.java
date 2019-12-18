package junit.test.exercises;

import org.junit.Test;

import classes.parameterized.tests.Product;
import classes.parameterized.tests.ProductDAO;

public class ParameterizedTestExceptionHelper {

	 @Test(expected = IllegalArgumentException.class)
	public static void throwIllegalArgException(Product p) throws Exception {
			/* The following line would be replaced with code that would be 
			 * expected to throw a IllegalArgumentException.
			 */
			ProductDAO.insertProduct(p);
	}
	
}
