package com.perscholas.StringTest;

import org.junit.BeforeClass;
import static org.junit.Assert.assertTrue;
import org.junit.*;

import com.perscholas.StringAssignment.StringAssignment;

public class StringTest {
	public static StringAssignment sA;
	
	@BeforeClass
	public static void setUp() {
		sA = new StringAssignment("red,green,blue;square,triangle,circle;dog,cat,bird");
	}
	
	@Test
	public void method1Test() {
		assertTrue(sA.split1()[0].equals("red,green,blue"));
		assertTrue(sA.split1()[2].equals("dog,cat,bird"));
	}
	
	@Test
	public void method2Test() {
		assertTrue(sA.split2()[0][2].equals("blue"));
		assertTrue(sA.split2()[1][1].equals("triangle"));
		assertTrue(sA.split2()[2][0].equals("dog"));
		assertTrue(sA.split2()[1][2].equals("circle"));
	}
	
}
