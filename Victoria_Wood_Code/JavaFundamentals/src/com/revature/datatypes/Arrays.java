package com.revature.datatypes;

public class Arrays {
	
	/*
	 * grouping of entities of the smae type
	 * - not dynamically sized
	 * - 0 indexed
	 */
	
	public static void main(String[] args) {
		int[] arr = new int[5];
		//arr[10] = 10; // compiles but throws ArrayIndexOutOfBoundsException
		
		
		int arr2[] = {1, 2, 3, 4, 5, 6, 7};
		
		int arr3[] = {1, 4, 6, 10, 12, 5};
		print(arr3);
		//System.out.println(arr3); prints out where its stored in memory - not the array
	}
	static void print(int[] nums) {
		for (int i: nums) {
			System.out.println(i + ", ");
		}
		System.out.println();
	}
	/*
	 * Var args
	 * allow methods to take in a variable numver of arguments, accessible in the method
	 * as an array.
	 * can be anywhere from no to many arguments passed in 
	 * can only use 1 var args per method
	 * MUST be the last parameter if the method takes in 
	 * 
	 */
	
	//static int sum(int...nums) {}
		
	
}
