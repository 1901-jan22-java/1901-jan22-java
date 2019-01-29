package com.revature.challanges.test;

public class FindTargetSum {
	
	static boolean findAddends(int[]array, int sum)
	{
		int tempAddend = 0;
		boolean areThereAddends = false;
		
		for (int i = 0; i < array.length; i++) 
		{
			if(array[i]<=sum)
			{	
				tempAddend = array[i];
				
				for (int j = 0; j < array.length; j++) 
				{
					if(j!=i && array[j]+tempAddend==sum)
					{
						return !areThereAddends;
					}
				}
			}
		}
		return areThereAddends;	
	}
	
	public static void main(String[] args) {
		
		int [] array = new int [] {1,2,3,4,5};
		int sum = 3;
		System.out.println(findAddends(array,sum));
	}

}
