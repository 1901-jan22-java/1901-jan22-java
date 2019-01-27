package com.question10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TernaryMin {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int num1 = Integer.parseInt(buffer.readLine());
		int num2 = Integer.parseInt(buffer.readLine()); // Reads 2 numbers from the keyboard
		int max = num1 > num2 ? num1 : num2; // Instantiating a variable max that checks is the 1st number entered is greater than the second.
		System.out.println(max); // Prints out the value saved to max
	}

}
