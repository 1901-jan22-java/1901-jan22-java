package com.revature.Q5;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubstringClassTest {

	@Test(expected = EqualsOrExceedsLengthOfString.class)
	public void testSubstring() throws EqualsOrExceedsLengthOfString {
		String expected = "Back to the Future";
		try {
			assertEquals(expected, SubstringClass.Substring("Back to the Future Delorean", 18));
		} catch (EqualsOrExceedsLengthOfString e) {
			e.printStackTrace();
		}
		expected = "B";
		try {
			assertEquals(expected, SubstringClass.Substring("Back to the Future Delorean", 1));
		} catch (EqualsOrExceedsLengthOfString e) {
			e.printStackTrace();
		}
		SubstringClass.Substring("Back to the Future Delorean", 27);
	}

}
