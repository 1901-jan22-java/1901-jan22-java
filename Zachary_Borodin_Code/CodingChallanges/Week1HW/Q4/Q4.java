//Zachary Borodin

package com.revature.hw1.Q4;

import java.util.Scanner;

//Write a program to compute N factorial
public class Q4 {
	public static int Factorial(int N) {
		int result = 1;
		for(int i=N; i>0; i--) {
			result *= i; 
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("Enter a number to find its factorial: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		int n = 0;
		boolean NumberInput = true;
		
		//checks to see if the user input is a number
		try{
			 n = Integer.parseInt(name);
		}catch(NumberFormatException e) {
			//user input is not a number
			System.out.println(name +" is not a number. Try again");
			NumberInput = false;
		}
		if(NumberInput == true) {
			//user input is a number
			double answer = Factorial(n);
			System.out.println(answer);
		}
		
	}
}
