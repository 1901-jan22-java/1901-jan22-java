package com.revature.q1;

public class BubbleSort
{

	public static void main(String[] args)
	{
		int[] array = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8 };
		SortBubble(array);
		PrintSortedArray(array);
	}
	
	static void SortBubble(int[] arr)
	{
		int n = arr.length - 1;
		//Loop through the array length
		for(int i = 0; i < n; i++)
		{
			//Second loop through array length -1
			for(int j = 0; j < n - i; j++)
			{
				//Check if the next index is greater than the first 
				if(arr[j] > arr[j + 1])
				{
					//If they are say j + 1 with j
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
	
	static void PrintSortedArray(int[] arr)
	{
		for(int i = 0; i < arr.length - 1; i++)
		{
			System.out.println(arr[i] + ", ");
		}
	}
}
