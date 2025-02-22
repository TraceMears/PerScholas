package question1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class StringUnitTests {

	String str = new String("Per Scholas - 211 N Ervay St. #700 - Dallas, TX 75201");

	@Test
	public void testLength() {
		assertThat(str.length(), equalTo(53));
	}
	
	@Test
	public void testEqualsIgnoreCase() {
		assertTrue(str.equalsIgnoreCase("per scholas - 211 n ervay st. #700 - dallas, tx 75201"));
	}
	
	@Test
	public void testContentEquals() {
		assertFalse(str.contentEquals("1738 scholas"));
	}
	
	@Test
	public void testCharAt() {
		assertThat(str.charAt(0), equalTo('P'));
	}
	
	@Test
	public void testContains() {
		assertTrue(str.contains("las - 21"));
	}
	
	@Test
	public void testStartsWith() {
		assertTrue(str.startsWith("Per Scholas"));
		assertTrue(str.startsWith(" N Ervay St. #70", 17));
	}
	
	@Test
	public void testEndsWith() {
		assertFalse(str.endsWith("dallas, tx 75201"));
	}
	
	@Test
	public void testSubstring() {
		assertThat(str.substring(13, 21), equalTo(" 211 N E"));
	}
	
	@Test
	public void testToLowerCase() {
		assertThat(str.toLowerCase(), equalTo("per scholas - 211 n ervay st. #700 - dallas, tx 75201"));
	}

}
