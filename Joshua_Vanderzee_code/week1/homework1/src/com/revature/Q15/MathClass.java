package com.revature.Q15;

public class MathClass implements IMath {

	@Override
	public double Addition(double a,double b) {
		return a + b;
	}

	@Override
	public double Subtraction(double a,double b) {
		return a - b;
	}

	@Override
	public double Multiplication(double a,double b) {
		return a * b;
	}

	@Override
	public double Division(double a,double b) throws Exception {
		if (b != 0)
			return a / b;
		throw new Exception("Can't Compute Division by 0.");
	}
	
}
