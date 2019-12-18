package question3;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryStringTest {

	@Test
	public void test() {
		assertThat(Integer.toBinaryString(21), equalTo("10101"));
	}

}
	