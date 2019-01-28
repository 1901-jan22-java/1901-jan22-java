package com.revature.app;

public class HomeWork1 {
public static void main(String[] args) {
	int nums[] = {1,0,5,6,3,2,3,7,9,9,4};
	
	System.out.println(nums.length);
	PrintArray(nums);
	nums = BubbleSort(nums, 0, nums.length);
	PrintArray(nums);
}

public static void PrintArray(int[] arr){
	for(int i : arr){
		System.out.print(i + ", ");
	}
	System.out.println("\n");
}
public static int[] BubbleSort(int[] arr, int start,int end){
	end -= 1;
	int[] copy = arr;
	int halfNum = ((end - start )/2);
	if(halfNum <= 0)
	{
		halfNum += start;
		System.out.println("Start: " + start + " End: " + end + " Middle: " + halfNum);	
	}
	else
	{
		halfNum += start;
		System.out.println("Start: " + start + " End: " + end + " Middle: " + halfNum);
		copy = BubbleSort(copy, start, halfNum);
		copy = BubbleSort(copy, halfNum, end);
	}
	
	for(int i = 0; (start + i) < halfNum && halfNum + i <= end; i++)
	{
		int newStart = start + i;
		int newHalfNum = halfNum + i;		
				
		System.out.println("Swapping [" + newStart + " - " + copy[newStart] + "] and [" + newHalfNum + " - " + copy[newHalfNum] + "]");

		if(copy[newStart] > copy[newHalfNum]){
			
			//System.out.println("Swapping [" + newStart + " - " + copy[newStart] + "] and [" + newHalfNum + " - " + copy[newHalfNum] + "]");

			
			int store = copy[newStart];
			copy[newStart] = copy[newHalfNum];
			copy[newHalfNum] = store;
			
			//System.out.println("NEW SWAP [" + newStart + " - " + copy[newStart] + "] and [" + newHalfNum + " - " + copy[newHalfNum] + "]");

		}		
	}
	
	return copy;
	
}
}
