package junit.practice;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.not;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

//Annotate class with @RunWith(Parameterized.class)
@RunWith(Parameterized.class)
public class CubeParameterizedTest {
	// Declare atttibutes
		private static CubeClass cube;
		private Integer length = 0;
		private Integer width = 0;
		private Integer height = 0;
		private Integer volume = null;
		private Boolean confirmation;

		/* Create the constructor. The order of arguments in the parentheses
		 * determines the parameter position in the two-dimensional Object arrays.
		 * Parameter1 = argument num1, Parameter2 = argument num2,
		 * Parameter3 = argument testSum, Parameter4 = argument confirmation*/
		public CubeParameterizedTest(Integer height, Integer width, Integer length,
										Integer volume, Boolean confirmation) {
			this.length = length;
			this.height = height;
			this.width = width;
			this.volume = volume;
			this.confirmation = confirmation;
		}

		/* Set up the parameters. The confirmation parameter is null and will
		 * be assigned in the actual test method depending on accuracy of
		 * the addition result. */
		@Parameters()
	    public static Collection<Object[]> data() {
	        return Arrays.asList(
	                new Object[][] {
	                		{ 1, 1, 1, 1, null },
	                		{ 2, 2, 2, 8, null },
	                		{ 3, 3, 3, 26, null },
	                		{ 4, 4, 4, 64, null }
	                		});
	    }

	    /*// Create the static class variable additionClass to run the test methods
	    @BeforeClass
	    public static void setUp() {
	    	cube = new CubeClass(length, width, height);
	    }
		*/
	    
	    // Run the test
	    @Test
	    public void cubeClassTest() throws AssertionError {
	    	cube = new CubeClass(length, width, height);
	    	Integer actual = cube.calculateVolume();
	    	
	    	if (actual == volume) {
	    		confirmation = true;
	        	assertThat(actual, equalTo(volume));
	    	} 
	    	else {
	    		confirmation = false;
	        	assertThat(actual, not(equalTo(volume)));
	    	}

	    	System.out.printf("%d * %d * %d Volume = %d is %s\n",
	    			length, height, width, volume, Boolean.toString(confirmation));

	    }
}
