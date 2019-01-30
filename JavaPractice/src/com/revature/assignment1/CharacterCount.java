package com.revature.assignment1;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Question 16
 * 
 * @author Sanford
 *
 */

public class CharacterCount {
	
	public static int count(String[] s) {
		if(s.length < 0) return 0;
		int sum = 0;
		System.out.println("Number of characters in word...");
		for(int i = 0; i < s.length; i++) {
			int len = s[i].length();
			sum += len;
			System.out.println(i + ": " + len);
		}
		sum += s.length-1;
		System.out.println("The input string is " + sum + " characters long.");
		return sum;
	}
	
}

class CharacterCountTest{
	
	private static final String[] s = {};
	private static final int[] count = {};
	
	@Test
	public static void q16Test(String...strings) {
		for(int i = 0; i < s.length; i++)
			Assert.assertEquals(CharacterCount.count(s[i].split(" ")), count[i]);
	}

}
