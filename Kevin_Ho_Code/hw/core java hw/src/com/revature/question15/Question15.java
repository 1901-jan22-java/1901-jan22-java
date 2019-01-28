package com.revature.question15;

public class Question15 implements MyInterface{

	@Override
	public double addition(double x, double y) {
		return x + y;
	}

	@Override
	public double subtraction(double x, double y) {
		return x - y;
	}

	@Override
	public double multiplication(double x, double y) {
		return x * y;
	}

	@Override
	public double division(double x, double y) {
		return x / y;
	}
}
