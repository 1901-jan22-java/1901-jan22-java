package com.question17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterestRateCalc {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Enter your principal: ");
		double principal = Double.parseDouble(buffer.readLine());
		System.out.println("Enter your interest rate: ");
		double rate = Double.parseDouble(buffer.readLine());
		System.out.println("Enter the number of years: ");
		double time = Double.parseDouble(buffer.readLine()); // Takes in data from the user
		
		System.out.println(interestCalc(principal, rate, time));

	}
	
	public static double interestCalc(double principle, double rate, double time){
        double interest = (principle*rate*time)/100; // Simple equation to calculate interest
        return interest;
    }
}
