package com.revature.hw1.Q12;

public class Q12 {
public static void main(String[] args) {
	int nums[] = new int[100];
	//initilize array of numbers
	for(int i=0; i<100; i++) {
		nums[i] = i+1;
	}
	
	System.out.println("The even numbers from 1 to 100 are:");
	for(int value: nums) {
		//checks to see if number is even
		if(value%2==0) {
			System.out.print(value + ", ");
			//makes a new line for easier readability
			if(value%20 ==0)
				System.out.println();
		}
	}
	}
}
