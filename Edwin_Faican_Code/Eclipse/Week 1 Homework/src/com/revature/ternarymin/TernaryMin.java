package com.revature.ternarymin;

public class TernaryMin {
	
	public static int findMin(int x, int y) {
		return x < y ? x : y;
	}
	
	
	public static void main(String[] args) {
		int x = 4;
		int y = 17;

		System.out.println(findMin(x,y));
	}
}
