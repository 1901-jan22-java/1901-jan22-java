package com.revature.interfacemath;

public class MathStuff implements InterfaceMath{

	@Override
	public double add(double x, double y) {
		return x + y;
	}

	@Override
	public double subtract(double x, double y) {
		return x - y;
	}

	@Override
	public double multiply(double x, double y) {
		return x * y;
	}

	@Override
	public double division(double x, double y) {
		return x / y;
	}
}
