package com.revature.corejavahw;

public class BubbleSort {
	
	  static void bSort(int array[]){
		    int n = array.length;
		    int swapper = 0;   // Holding place for the greater value to be swapped
		    for (int i = 0; i < n; i++){ // Loop starts at the 0 index
		      for (int j = 1; j < n; j++){ // inner loop starts at the 1st index
		        if (array[j-1] > array[j]){ 
		          swapper = array[j-1]; // If the element in the index before j is greater, then add it to the swapper
		          array[j-1] = array[j]; // The index that was before j now becomes j while the swapper holds the original value
		          array[j] = swapper; // Original value of J is now replaced with the greater number
		        }
		      } // For loop runs until the if statement in the inner loop is satisfied, then the outer loop can complete.
		    }
		  }
	
	public static void printArray(int nums[]){
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + ", ");
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		bSort(nums);
		printArray(nums);
	}
}


