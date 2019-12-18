package junit.test.exercises;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import basic.classes.InsufficientQuantityException;
import basic.classes.MaximumQuantityExceededException;
import basic.classes.Product;

public class ExceptionTesting {
	
	/* This example uses the @Test optional parameter to test
	 * for an exception.
	 */
	@Test(expected = InsufficientQuantityException.class)
	public void throwInsufficientQuantException() throws Exception {
		/* The following line would be replaced with code that would be 
		 * expected to throw a FileNotFoundException.
		 */
		//throw new InsufficientQuantityException();
		
		Product prodInsuffQuantException = new Product();
		prodInsuffQuantException.reduceAvailableQuantity(50);
	}
	
	// This example uses a rule
	@Rule
	public ExpectedException ee = ExpectedException.none();
	
	@Test
	public void throwsMaximumException() throws Exception {
		ee.expect(MaximumQuantityExceededException.class);
		/* The following line would be replaced with code that would be 
		 * expected to throw an SQLException.
		 */
		//throw new MaximumQuantityExceededException();
		Product prodMaxException = new Product();
		prodMaxException.setAvailableQuantity(501);
	}
}
