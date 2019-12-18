package junit.practice;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class SimpleTest2 {
	private static SimpleClass simpleClass;

	@BeforeClass
	public static void createSimpleClass() {
		simpleClass = new SimpleClass();
	}

	@Test
	public void compareTwoObjectsTest() {
		Object obj1 = new Object();
		Object obj2 = new Object();

		assertNotSame(obj1,obj2);

		/* obj3 acquires the same memory address as obj1, so obj1 & obj3 point to
		 * the same Object.
		 */
		Object obj3 = obj1;
		assertSame(obj1, obj3);
	}

	// simpleClass.returnList() returns the list ["red", "green", "blue"]
	@Test
	public void listContainsRedBlueTest() {
		assertThat(simpleClass.returnList(), hasItems("red", "blue"));
	}

	@Test
	public void listItemsContainETest() {
		assertThat(simpleClass.returnList(), everyItem(containsString("e")));
	}

}
