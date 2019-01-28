package com.revature.Q4;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactorialTest {

	@Test
	public void testComputeFactorial() {
		int expected = 0;
		for (int i = 0; i < 100; i++) {
			int actual = Factorial.computeFactorial(i);
			if (i == 0)
				expected = 1;
			else
				expected *= i;
			assertEquals(expected, actual);
		}
	}

}
