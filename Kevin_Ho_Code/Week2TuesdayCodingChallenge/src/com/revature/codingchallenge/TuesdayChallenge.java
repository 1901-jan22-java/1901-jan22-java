package com.revature.codingchallenge;

public class TuesdayChallenge {

	/*
	 * given an array of ints and a target value
	 * write a method to determine whether there exists two #s 
	 * in the array whose sum is the target value
	 * 
	 * ex [1, 3, 7, 2, 5, 10] -> 13 true
	 * ex [2, 4, 6, 8] -> 7 false
	 * */
		
	public static boolean math(int[] numbers, int target)
	{
		for(int i = 0; i < numbers.length; i++)
			for(int j = i; j < numbers.length; j++)
				if(numbers[i] + numbers[j] == target)
					return true;
		
		return false;
	}
}
