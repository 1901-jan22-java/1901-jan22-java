package com.revature.app;

public class HW10_Ternary {
public static void main(String[] args) {
	
	int number1 = 2324323;
	
	int number2 = 28378;
	
	System.out.println("Numbers to compare: " + number1 + " and " + number2);
	
	int min = FindMinimum(number1, number2);
	
	System.out.println("Min: " + min);
	
}
public static int FindMinimum(int num1, int num2){
	return (num1 < num2) ? num1 : num2;
}
}
