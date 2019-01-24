package com.revature.Q1;

public class bubblesort {

	public static void main(String[] args) {
		int[] arr = new int[] {1,0,5,6,3,2,3,7,9,8,4};
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
		for (int i : sort(arr))
			System.out.print(i + " ");
	}

	private static int[] sort(int... nums) {
		
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
