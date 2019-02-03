package com.revature.assignment1;

import java.util.Scanner;

/**
 * Question 17
 * 
 * @author Sanford
 *
 */

public class SimpleInterest {
	
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in) ){
			System.out.println("Simple Interest is " + calculate(
					getDouble("Enter Principal: ", in),
					getDouble("Enter Rate: ", in),
					getDouble("Enter Time: ", in)
			));
		}
	}
	
	public static double calculate(double principal, double rate, double time) {
		return principal * rate * time;
	}

	// Scanner helper
	private static double getDouble(String message, Scanner scan) {
		System.out.print(message);
		return scan.nextDouble();
	}
	
}
