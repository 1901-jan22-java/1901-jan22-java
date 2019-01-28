package com.revature.Q9;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrimesClassTest {

	@Test
	public void testCompute() {
		int[] expected = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		int[] actual = PrimesClass.Compute(100);
		assertArrayEquals(expected, actual);
		for (int i = 0; i < expected.length; i++) {
			assertTrue(expected[i] == actual[i]);
		}
	}

}
