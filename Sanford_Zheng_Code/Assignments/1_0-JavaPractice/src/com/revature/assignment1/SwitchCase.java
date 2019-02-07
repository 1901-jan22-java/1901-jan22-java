package com.revature.assignment1;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Question 14
 * 
 * @author Sanford
 *
 */

public class SwitchCase {
	
	public static void main(String[] args) {
		for(int i = 1; i <= 4; i++) {
			System.out.println(compute(i));
		}
	}
	
	public static String compute(int c) {
		StringBuilder sb = new StringBuilder();
		Scanner in = new Scanner(System.in);
		
		switch(c) {
		case 1:
			System.out.print("Square Root: ");
			double n = in.nextDouble();
			sb.append("Result: " + Math.sqrt(n));
			break;
		case 2:
			sb.append("Date: " + Calendar.getInstance().getTime());
			break;
		case 3:
			sb.append("Array: " + Arrays.asList("I'm learning Core Java".split(" ")));
			break;
		default:
			System.out.print("String to Split: ");
			sb.append(Arrays.asList(in.nextLine().split(" ")));
		}
		
		in.close();
		return sb.toString();
	}
	
}
