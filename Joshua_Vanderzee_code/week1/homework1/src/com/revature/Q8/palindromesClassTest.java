package com.revature.Q8;

import static org.junit.Assert.*;

import org.junit.Test;

public class palindromesClassTest {

	@Test
	public void testIfPalindrome() {
		String[] actual = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john", "refer", "billy","did"};
		boolean[] expected = {false, true,    false, true,    true,    true,    false,   true,    false,  true,    false,   true};
		for (int i = 0; i < 12; i++)
			assertEquals(expected[i], palindromesClass.IfPalindrome(actual[i]));
	}

}
