package com.revature.iseven;

public class IsEven {
	public static boolean iCantEven(int num) {
		if(num < 0) {
			return false;
		} else {
			return notOdd(num-1);
		}
	}
	
	public static boolean notOdd(int num) {
		if(num == 1) {
			return true;
		} else {
			return iCantEven(num-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(iCantEven(12222));
	}
}
