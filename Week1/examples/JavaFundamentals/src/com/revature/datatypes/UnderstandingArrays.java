package com.revature.datatypes;

import java.util.Arrays;

public class UnderstandingArrays {
	/*
	 * Grouping of entities of the same type 
	 * - not dynamically sized
	 * - 0 indexed
	 */
	
	public static void main(String... args) {
		int[] arr = new int[5];
		//compiles BUT throws ArrayIndexOutOfBoundsException
	//	arr[10] = 10;
		
		int arr2[] = {1, 2, 3, 4, 5, 6, 7};
		
		int arr3[] = {10, 2, 5, 1, 54, 7, 2};
		print(arr3);
		Arrays.sort(arr3);
		print(arr3);
		
		//////////////
		int number = sum(1);
		number = sum(1, 7, 234, 10);
		number = sum();
		test("hello", 1, 20);
	}
	
	static void print(int[] nums ) {
		for(int i : nums) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}
	
	/*
	 * Var args 
	 * allow methods to take in a variable number 
	 * of arguments, accessible in the method as an 
	 * array. 
	 * can be anywhere from no to many arguments passed in 
	 * can only use 1 var args per method 
	 * MUST be the last parameter if the method takes in multiple
	 */
	static int sum(int... nums) {
		int sum = 0;
		for(int i : nums) {
			sum+=i;
		}
		return sum;
	}
	
	static void test(String a, int b, int... nums) {
		
	}

}