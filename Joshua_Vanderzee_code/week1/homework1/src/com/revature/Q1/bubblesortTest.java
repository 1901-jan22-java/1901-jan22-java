/**
 * 
 */
package com.revature.Q1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author thejo
 *
 */
public class bubblesortTest {

	/**
	 * Test method for {@link com.revature.Q1.bubblesort#sort(int[])}.
	 */
	@Test
	public void testSort() {
		int[] expected = new int[] {0,1,2,3,3,4,5,6,7,8,9};
		int[] actual = bubblesort.sort(new int[] {1,0,5,6,3,2,3,7,9,8,4});
		assertArrayEquals(expected, actual);
	}

}
