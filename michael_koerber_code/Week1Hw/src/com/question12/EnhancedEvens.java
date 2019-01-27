package com.question12;

import java.util.ArrayList;


public class EnhancedEvens {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>(100); //Create numbers Array
		for (int i = 1; i <= 100; i++){
		   numbers.add(i); // Add 1 - 100 to the array
		}
		
		for(int num: numbers){ // For-each look assigning each value to int num in arraylist numbers
			if(num % 2 == 0){ // checking each value num (1-100) if the num is even
				System.out.println(num);
			}
		}

	}

}
