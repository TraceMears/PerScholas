package junit.test.exercises;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import basic.classes.MathOperations;

public class MathOpTests {
	
	@Test
	public void additionTest() {
		int output = MathOperations.addNums(23, 57);
		assertTrue(output == (23+57));
	}
	
	@Test
	public void subtractionTest() {
		int output = MathOperations.subtractBfromA(74, 21);
		assertTrue(output == (74-21));
	}
	
	@Test
	public void multiplicationTest() {
		int output = MathOperations.multiplyNums(17, 42);
		assertTrue(output == (17*42));
	}
	
	@Test
	public void divisionTest() {
		double output = MathOperations.divideAbyB(473.0, 22.0);
		assertTrue(output == (473.0/22.0));
	}
	
}
