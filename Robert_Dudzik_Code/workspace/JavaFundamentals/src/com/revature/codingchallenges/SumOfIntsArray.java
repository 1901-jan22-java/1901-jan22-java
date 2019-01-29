package com.revature.codingchallenges;

public class SumOfIntsArray 
{

	public static void main(String[] args) 
	{
		int[] arr = {1, 3, 7, 2, 5, 10};
		int[] arr2 = {2, 4, 6, 8 };
		System.out.println(IntSumArray(arr, 13));
		System.out.println(IntSumArray(arr2, 7));
	}
	
	public static boolean IntSumArray(int[] arr, int value)
	{
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr.length; j++)
			{
				if(j == i)
					continue;
				if(arr[i] + arr[j] == value)
					return true;
			}
		}
		
		return false;
	}
}
