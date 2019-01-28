package com.revature.question01;

import com.revature.utilities.Printable;

public class BubbleSort implements Printable{

	static int [] bubbleSort(int[] array)
	{
		int count = 0; //will count if next element is sorted
		int index = 1; //will start from 2nd element
		
		while(count<array.length-1)
		{
			if(index==array.length){
				count = 0; 
				index = 1;
			}
			
			int temp_holder = array[index];
				
			if(array[index] < array[index-1]){
				array[index] = array[index-1];
				array[index-1] = temp_holder;
			}
			else{
				count++;
			}
			
			index++;
		}
		return array;
	}
	
	public static void main(String[] args) {
		BubbleSort b = new BubbleSort();
		b.printArray(bubbleSort(new int[] {9,8,7,6,5,4,3,2,1,0}));
	}

}
