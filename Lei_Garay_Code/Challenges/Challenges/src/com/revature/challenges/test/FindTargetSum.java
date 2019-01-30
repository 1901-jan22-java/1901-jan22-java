package com.revature.challenges.test;

public class FindTargetSum {
	
	static boolean findAddends(int[]array, int sum)
	{
		int tempAddend = 0;
		boolean areThereAddends = false;
		
		for (int i = 0; i < array.length; i++) 
		{
			//moves to quadratic for element comparison
			// only if current element can be an addend (less or equal to total sum)
			if(array[i]<=sum) 
			{					
				tempAddend = array[i]; //temp var holds addend
				
				for (int j = 0; j < array.length; j++) 
				{
					// j != i ensures we are not comparing element to itself
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
