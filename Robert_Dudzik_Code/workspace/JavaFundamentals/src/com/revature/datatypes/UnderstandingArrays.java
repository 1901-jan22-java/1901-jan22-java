package com.revature.datatypes;

public class UnderstandingArrays 
{
	/*
	 * Grouping of entities of the same type 
	 * not dynamically sized
	 * 0 indexed
	 * */
	public static void main(String[] args) {
		int [] arr = new int[5];
		//compiles but throws an arrayindexoutofboundsexception
		//arr[10] = 10;
		int arr2[] = { 1, 2, 3, 4, 5, 6, 7 };
		int arr3[] = { 20, 3, 2,32 ,21, 23, 1, 5};
		print(arr3);
	}
	static void print (int[] nums)
	{
		for (int i : nums)
		{
			System.out.println(i + ", ");
		}
	}
	
	//Var args- allow methods to take in a variable number of arguments, accessible in the method 
	// as an array. Can be anywhere from no to many arguments passed in can only use 1 vars
	// args per method. Must be the last parameter if the method takes in more than one 
	static int sum(int... nums)
	{
		return 1;
	}
}
