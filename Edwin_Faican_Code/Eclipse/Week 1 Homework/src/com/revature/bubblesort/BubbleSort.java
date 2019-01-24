package com.revature.bubblesort;

public class BubbleSort {
	
	//This is the sorting algorithm that runs in O(n^2) time. 
	//It takes an array and bubbles up every value to the corresponding place
	//by checking the next item in the array and comparing the two until
	//It cannot go any further. 
	public static int[] bubblify(int[] arr) {
		//Temp is used to store one of the replaced values so as to not lose data. 
		int temp = 0;
		
		for(int j=0; j < arr.length; j++) {
			for(int i=0; i < arr.length-1; i++) {
				if(arr[i+1] < arr[i]) {
					temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		
		//Original array. 
		for(int num : arr) {
			System.out.print(num);
		}
		System.out.println();
		
		bubblify(arr);
		
		//Sorted array.
		for(int num : arr) {
			System.out.print(num);
		}
		
	}
}
