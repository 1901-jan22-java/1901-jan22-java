package com.revature.app;

public class HW22_FucntionalInterfaces {
public static void main(String[] args) {
	
	//Different ways to implement Functional Interfaces
	
	//First Class implementation
	MathInterfaceClass myMath = new MathInterfaceClass();
	myMath.DoSomeMath(1, 3);
	
	//Second, Lamda Expression
	MathInterface myMath2 = (a, b) -> {return a*b;};
	myMath2.DoSomeMath(1, 3);
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}

interface MathInterface{
	int DoSomeMath(int a, int b);
}

class MathInterfaceClass implements MathInterface{

	@Override
	public int DoSomeMath(int a, int b) {
		
		return a + b;
	}
	
}
