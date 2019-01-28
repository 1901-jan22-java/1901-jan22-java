package com.revature.codechallenges;
//Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
  public class BubbleSort {
	
	
	int count = 0; 
	
	static void printList( int [] x) {
		
		for(int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
	}
	
	
	static void bSort (int [ ] a ) {
		
		

		int temp; 
		 
		
		
		 for (int i = 0; i < a.length-1; i++) {
	            for (int j = 0; j < a.length-i-1; j++) {
	                if (a[j] > a[j+1]) 
	                { 
	                    temp = a[j]; 
	                    a[j] = a[j+1]; 
	                    a[j+1] = temp; 
	                    
	                    
	                } 
	    } } BubbleSort.printList(a);

}
		
		
		
		
	
	

	public static void main (String [] args) {

		
	int [] a = new int [10]; 
		
		a[0] = 1; 
		a[1] = 0;
		a[2] = 5;
		a[3] = 6;
		a[4] = 3;
		a[5] = 2;
		a[6] = 3;
		a[7] = 7;
		a[9] = 9;
		a[8] = 8;
		a[4] = 4;
		
		
	
		BubbleSort.printList(a); 
		System.out.println();
		BubbleSort.bSort( a); 

		
		
	}
	
	
	

}
