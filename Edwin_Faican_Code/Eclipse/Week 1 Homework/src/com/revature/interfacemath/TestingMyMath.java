package com.revature.interfacemath;

public class TestingMyMath {
	public static void main(String[] args) {
		double x = 10;
		double y = 7;
		
		MathStuff maf = new MathStuff();
		
		System.out.println(maf.add(x, y));
		System.out.println(maf.subtract(x, y));
		System.out.println(maf.multiply(x, y));
		System.out.println(maf.division(x, y));
	}
}
