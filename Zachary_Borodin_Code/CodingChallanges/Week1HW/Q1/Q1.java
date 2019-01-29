//Zachary Borodin
package com.revature.hw1.Q1;
//bubble sort
public class Q1 {
	public static void main(String[] args) {
		int arr[] = {1,0,5,6,3,2,7,9,8,4};
		boolean swap;
		for(int i=0; i<arr.length-1; i++) {
			swap = false;
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j] > arr[j+1]) {
					//swap the 2 elements
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swap = true;
					
				}
			}
			//no swap occurs. the array is now sorted
			if(swap == false)
				break;
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		
	}

}
