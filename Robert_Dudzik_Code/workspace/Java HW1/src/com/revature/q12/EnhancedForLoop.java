package com.revature.q12;

public class EnhancedForLoop 
{

	public static void main(String[] args) 
	{
		int[] arr = new int[100];
		for(int i = 1; i < 101; i++)
			arr[i - 1] = i;
		for(int i : arr)
		{
			if(arr[i - 1] % 2 == 0)
				System.out.print(arr[i - 1] + ", ");
		}
	}
}
