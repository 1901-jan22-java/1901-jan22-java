package com.revature.arraytargetsum;

public class ArrayTargetSum {
	
	public static void fillArrayLinear(int[] nums) {
		for(int i=0; i < nums.length; i++) {
			nums[i] = i;
		}
	}
	
	public static boolean hasTargetSum(int[] nums, int target) {
		for(int i=0; i < nums.length; i++) {
			for(int j=i+1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[10];
		int target = 13;
		int[] newNums = {2, 4, 6, 8, 10, 12};
		fillArrayLinear(nums);
		
		System.out.print("Given: ");
		for(int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
		if(hasTargetSum(nums, target)) {
			System.out.println("There is a pair that adds up to " + target + " in the array.");
		} else {
			System.out.println("There is no pair that adds up to " + target + " in the array.");
		}
		
		System.out.print("Given: ");
		for(int i : newNums) {
			System.out.print(i + " ");
		}
		System.out.println();
		if(hasTargetSum(newNums, target)) {
			System.out.println("There is a pair that adds up to " + target + " in the array.");
		} else {
			System.out.println("There is no pair that adds up to " + target + " in the array");
		}
	}
}
