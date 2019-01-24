package com.revature.datatypes;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UnderstandingArrays {
	public static void main(String[] args) {
		
		int arr3[] = {10, 2,5,1,54,7,2};
		print(arr3);
		Arrays.sort(arr3);
		print(arr3);
		
		int number = sum(1,98,1,1,5);
		System.out.println(number);
	}
	
	static void print(int[] nums) {
		for (int i : nums)
			System.out.println(i);
	}
	
	static int sum(int... nums) {
		int sum = 0;
		for(int i: nums)
			sum+=i;
		return sum;
	}
}
