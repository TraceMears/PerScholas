package com.platform.junit_intro_test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.platform.intro_junit.SimpleClass;

public class SimpleClassTest {
	@Test
	public void returnTrueTest() {
		SimpleClass sc = new SimpleClass();
		assertTrue(sc.returnTrue());
	}
}
