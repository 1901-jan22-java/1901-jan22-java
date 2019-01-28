/**
 * 
 */
package com.revature.Q2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author thejo
 *
 */
public class FibonacciTest {

	/**
	 * Test method for {@link com.revature.Q2.Fibonacci#FibonacciNum(int)}.
	 */
	@Test
	public void testFibonacciNum() {
		int[] expected = new int[] {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368};
		for (int i = 0; i < expected.length; i++) {
			assertTrue(expected[i] == Fibonacci.FibonacciNum(i));
		}
	}

}
