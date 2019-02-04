package com.revature.challenge;

public class CompareAddition
{
	static int num = 16;
	public static void main(String args[])
	{
		int compareTemp = 0;
		int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
		for (int i = 0; i < arr.length; i++)
		{
			compareTemp = arr[i] + (arr[i] + 1);
			if(compareTemp == num)
			{
				System.out.println("Array number: " + compareTemp + "Stored number: " + num);

			}
		}
	}
}
