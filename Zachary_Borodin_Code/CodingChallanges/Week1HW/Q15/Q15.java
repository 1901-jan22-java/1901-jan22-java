package com.revature.hw1.Q15;

public class Q15 implements Q15Interface {
	
	public Q15() {
		
	}

	@Override
	public int addition(int x, int y) {
		return x+y;
	}

	@Override
	public int subtraction(int x, int y) {
		return x-y;
	}

	@Override
	public int multiplication(int x, int y) {
		return x*y;
	}

	@Override
	public int division(int x, int y) {
		return x/y;
	}

	
	public static void main(String[] args) {
		Q15 test = new Q15();
		System.out.println(test.addition(10, 5));
		System.out.println(test.subtraction(10, 5));
		System.out.println(test.multiplication(10, 5));
		System.out.println(test.division(10, 5));
		
	}

}
