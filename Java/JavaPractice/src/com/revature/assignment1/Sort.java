package com.revature.assignment1;

import java.util.Arrays;

/**
 * Question 1
 * 
 * @author Sanford
 *
 */

public class Sort {

	public static void main(String[] args) {
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println( "Original: " + Arrays.toString(arr) );
		System.out.println( "Sorted: " + Arrays.toString(bubbleSort(arr)) );
	}
	
	public static int[] bubbleSort(int[] arr) {
		
		for(int i = 0; i < arr.length; i++)
			for(int j = 0; j < arr.length-1; j++) {
				if(arr[j] > arr[j+1]) swap(arr, j, j+1);
//				System.out.println("Step " +  + ": " + Arrays.toString(arr));	// Needs work
			}
		return arr;
		
	}
	
	private static int[] swap(int[] arr, int i, int j) {
		
		arr[i] += arr[j];
		arr[j] = arr[i] - arr[j];
		arr[i] -= arr[j];
		
		return arr;
		
	}
}
