package com.revature.question15;

public class MathOperationsDemo implements MathOperations {

	@Override
	public double addition(int ...a) {
		int temp = 0;
		for(int i:a) {
			temp += i;
		}
		return temp;
	}

	@Override
	public double subtraction(int a, int b) {
		return (double) a - (double) b;
	}

	@Override
	public double multiplication(int ...a) {
		int temp = 1;
		for(int i:a) {
			temp *= i;
		}
		return temp;
	}

	@Override
	public double division(int a, int b) {
		return (double) a / (double) b;
	}

	public static void main(String[] args) {
		MathOperationsDemo demo = new MathOperationsDemo();
		System.out.println(demo.addition(1,2,3,4,5));
		System.out.println(demo.multiplication(1,2,3,4,5));
		System.out.println(demo.subtraction(200,100));
		System.out.println(demo.division(100,3));
	}
}
