package com.revature.printeven;

public class PrintEven {
	
	public static void fillArray(int[] nums) {
		for(int i=1; i <= 100; i++) {
			nums[i-1] = i;
		}
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[100];
		fillArray(nums);
		
		boolean even = false;
		for(int i : nums) {
			if(even) {
				System.out.println(i);
				even = false;
			} else {
				even = true;
			}
		}
	}
}
