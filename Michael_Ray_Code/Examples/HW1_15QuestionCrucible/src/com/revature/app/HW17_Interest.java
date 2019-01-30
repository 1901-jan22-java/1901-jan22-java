package com.revature.app;

import java.util.Scanner;

public class HW17_Interest {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	float principle = 0;
	float rate = 0;
	float time = 0;
	
	System.out.println("Enter in the Principle number:");
	String myInput = scan.nextLine();
	principle = Float.parseFloat(myInput);

	System.out.println("Enter in the Rate of Interest:");
	myInput = scan.nextLine();
	rate = Float.parseFloat(myInput);

	System.out.println("Enter in the number of Years:");
	myInput = scan.nextLine();
	time = Float.parseFloat(myInput);

	float interest = principle * rate * time;
	
	System.out.println("The Interest Rate is: " + interest);
}
}
