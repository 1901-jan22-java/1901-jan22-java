package com.revature.Q1;

public class bubblesort {
	/*
	 * The method "sort" uses a bubble sort algorithm and returns an integer array. Compatible with n lengthed integer arrays.
	 * */
	public static int[] sort(int... nums) {
		
		for(int i = 1; i < nums.length; i++)
		{
			if (nums[i] < nums[i - 1])
			{
				int swap = nums[i];
				nums[i] = nums[i - 1];
				nums[i - 1] = swap;
				i = 1;
			}
		}
		return nums;
	}
}
