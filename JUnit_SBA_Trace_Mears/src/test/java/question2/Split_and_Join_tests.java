package question2;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class Split_and_Join_tests {

	String str = new String("Per Scholas - 211 N Ervay St. #700 - Dallas, TX 75201");
	String[] split = str.split(" ");
	
	String join = String.join("#", "Testing","with","JUnit");
	
	@Test
	public void testSplit() {
		assertThat(split[6], equalTo("St."));
	}

	@Test
	public void testJoin() {
		assertThat(join.charAt(13), equalTo('J'));
	}
}
