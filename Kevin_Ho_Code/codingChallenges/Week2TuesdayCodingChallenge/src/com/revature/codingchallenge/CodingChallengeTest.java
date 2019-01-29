package com.revature.codingchallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class CodingChallengeTest {

	@Test
	public void test() {
		int[] nums1 = {1,3,7,2,5,10};
		int target1 = 13;
		
		int[] nums2 = {2,4,6,8};
		int target2 = 7;
		
		boolean actual;
		
		assertEquals(true, TuesdayChallenge.math(nums1, target1));
		assertEquals(false, TuesdayChallenge.math(nums2, target2));

	}

}
