package com.question1;

import java.util.Arrays;

public class BubbleSort {
	
	  static void bSort(int array[]){
		    int swapper = 0;   // Temp variable for the greater value to be swapped
		    for (int i = 0; i < array.length; i++){ // Loop starts at the 0 index
		      for (int j = 1; j < array.length; j++){ // inner loop starts at the 1st index
		        if (array[j-1] > array[j]){ 
		          swapper = array[j-1]; // If the element in the index before j is greater, then add it to the swapper
		          array[j-1] = array[j]; // The index that was before j now becomes j while the swapper holds the original value
		          array[j] = swapper; // Original value of J is now replaced with the greater number
		        }
		      } // For loop runs until the if statement in the inner loop is satisfied, which will coincide with i reaching the end of the arrays length.
		    }
		  }
	
	public static void printArray(int nums[]){
		System.out.println(Arrays.toString(nums)); // Convert Array nums to a String and print
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		bSort(nums);
		printArray(nums);
	}
}


