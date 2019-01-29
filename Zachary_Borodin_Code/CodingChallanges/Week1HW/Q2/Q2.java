//Zachary Borodin

package com.revature.hw1.Q2;
//Write a program to display the first 25 Fibonacci Numbers beginning at 0
public class Q2 {

	public static void Fibonacci(int end) {
		int array[] = new int[end];
		System.out.println("Here are the first " + end+ " Fibonacci numbers.");
		array[0] = 1; array[1]=1; // the first two values of the Fibonacci sequence are 1
		System.out.print(array[0] + ", " + array[1]+ ", ");
		for(int i=2; i<end; i++) {
			array[i] = array[i-1]+ array[i-2];
			System.out.print(array[i] + ", ");
		}
	}
	
	public static void main(String[] args) {
		Fibonacci(25);
	}
}
