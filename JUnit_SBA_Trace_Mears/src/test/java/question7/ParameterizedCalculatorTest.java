package question7;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import question7_classes.AddVaryingTypeCalculator;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ParameterizedCalculatorTest {

	static AddVaryingTypeCalculator calc;
	List<Object> list;
	Double expectedSum;
	Class <? extends Exception> expectedException;
	
	public ParameterizedCalculatorTest(List<Object> list, Double expectedSum, Class <? extends Exception> expectedException) {
		this.list = list;
		this.expectedSum = expectedSum;
		this.expectedException = expectedException;
	}
	
	
	//works for bonus
	@Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                		{ Arrays.asList('7', 14), 21.0, null },
                		{ Arrays.asList("12", 8.7), 20.7, null },
                		{ Arrays.asList('b', 14), 21.0, IllegalArgumentException.class },
                		{ Arrays.asList(12.8, 13), 25.8, null },
                		{ Arrays.asList("14", 17), 31.0, null }, 
                		{ Arrays.asList("14", 'z'), 31.0, IllegalArgumentException.class },
                		{ Arrays.asList("12", 13.3, 8, '4'), 37.3, null }
                		});
	
    }
    
    @BeforeClass
    public static void setup() {
    	calc = new AddVaryingTypeCalculator();
    }
    
    @Rule
    public ExpectedException ee = ExpectedException.none();
    
    @Test
    public void test() {
    	if(expectedException != null) {
    		ee.expect(expectedException);
    	}
    	
    	assertThat(calc.addTwoNumbersVaryingType(list), equalTo(expectedSum));
    }
    
    
}
