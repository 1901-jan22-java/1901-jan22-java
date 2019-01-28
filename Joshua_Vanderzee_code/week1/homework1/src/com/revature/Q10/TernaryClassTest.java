package com.revature.Q10;

import static org.junit.Assert.*;

import org.junit.Test;

public class TernaryClassTest {

	@Test
	public void testMin() {
		int expected = 30;
		int actual = TernaryClass.min(50, 30);
		assertEquals(expected, actual);
		actual = TernaryClass.min(30, 40);
		assertEquals(expected, actual);
		actual = TernaryClass.min(30, 30);
		assertEquals(expected, actual);
	}

}
