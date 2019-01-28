package com.revature.Q17;

import java.util.Scanner;

public class Interest {
	public static double Compute(double principal , double rate, double time) {
		return principal * rate * time;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Type the principal amount: ");
		double p = 0;
		try {
			p = Double.parseDouble(s.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.print("Type the rate of interest in decimal: ");
		double d = 0;
		try {
			d = Double.parseDouble(s.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.print("Type the time in number of years: ");
		double y = 0;
		try {
			y = Double.parseDouble(s.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Compute(p, d, y));
	}
}
