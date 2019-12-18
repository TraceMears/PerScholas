package junit.test.exercises;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.hamcrest.collection.IsMapContaining.hasValue;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import basic.classes.HamcrestMathOperations;

public class HamcrestTests {
	
	@Test
	public void op1Test() {
		int out1 = HamcrestMathOperations.abstractOperation1(2, 17, 4);
		int expected = 2 + (17 * 4);
		assertThat(out1, equalTo(expected));
	}
	
	@Test
	public void op1NegativeTest() {
		int out1 = HamcrestMathOperations.abstractOperation1(14, 9, 21);
		int expected = 14 + (5 * 21);
		assertThat(out1, not(equalTo(expected)));
	}
	
	@Test
	public void op2Test() {
		int out2 = HamcrestMathOperations.abstractOperation2(2, 17, 4);
		int expected = (2 + 17) * 4;
		assertThat(out2, equalTo(expected));
	}
	
	@Test
	public void op2NegativeTest() {
		int out2 = HamcrestMathOperations.abstractOperation2(14, 9, 21);
		int expected = (14 + 5) * 21;
		assertThat(out2, not(equalTo(expected)));
	}
	
	@Test
	public void op3Test() {
		double out3 = HamcrestMathOperations.abstractOperation3(2, 17, 4, 13);
		double expected = (2.0 * 17.0) * (4.0/ 13.0);
		assertThat(out3, equalTo(expected));
	}
	
	@Test
	public void op3NegativeTest() {
		double out3 = HamcrestMathOperations.abstractOperation3(14, 9, 21, 47);
		double expected = (14.0 * 7.0) * (21.0/ 8.0);
		assertThat(out3, not(equalTo(expected)));
	}
	
	@Test
	public void listTest() {
		List<Integer> cubes = HamcrestMathOperations.listOfCubes();
		
		assertThat(cubes, allOf(hasItems(8, 125, 343), not(hasItems(62, 49))));
	}
	
	@Test
	public void mapTest() {
		Map<String, String> capitals = HamcrestMathOperations.capitals();
		
		assertThat(capitals, hasKey("Quito"));
		assertThat(capitals, hasValue("Denmark"));
		assertThat(capitals, hasEntry("Brasilia", "Brazil"));
		
		assertThat("Nicaragua", equalTo(capitals.get("Managua")));
	}
	
	
	
	
}
