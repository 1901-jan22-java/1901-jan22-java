package com.revature.Q3;

import static org.junit.Assert.*;

import org.junit.Test;

public class reverseStringTest {

	@Test
	public void testReverseString() {
		String expected = "truck";
		String actual = reverseString.reverse(expected);
		for (int i = actual.length(); i <= 0 ; i--) {
			assertEquals(expected.charAt(actual.length() - i), actual.charAt(i));
		}
	}
}
