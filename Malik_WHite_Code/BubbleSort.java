package com.revature.codechallenges;
//Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
  public class BubbleSort {
	
	
	int count = 0; 
	
	
	static void bSort (int [ ] a ) {
		
		//temp array 
		boolean swapped; 
		int [ ] temp = new int [a.length]; 
		 
		
		
		for (int j = 0; j < a.length - 1; j ++)	{
		for (int i = 0 ; i < a.length - j  - 1; i++ ) {
			
			swapped = false; 
			if ( a[i] > a[i+1]) {
				
					temp[i] = a[i+1];
					a[i+1] = a[i] ; 
					a[i] = temp[i]; 
					swapped = true;
					
			}
			
			if (swapped == false) {
				
				break; 
				
			}
		}}
		
//		if (count == 0) {
//			System.out.println("The Array is Sorted");
//		}
//		
//		else {
//			
//		}
		
		
		
		
	}
	

	public static void main (String [] args) {
		int a [] = new int [5]; 
		a[0] = 5; 
		a[1] = 4;
		a[2] = 3;
		a[3] = 2;
		a[4] = 1;
		
		for (int i = 0; i < a.length; i ++) {
		System.out.print(a[i] + " ");}
		
		BubbleSort.bSort( a); 
		
		System.out.println(); 
		for (int i = 0; i < a.length; i ++) {
			System.out.print(a[i] + " ");}
		
		
	}
	
	
	

}
