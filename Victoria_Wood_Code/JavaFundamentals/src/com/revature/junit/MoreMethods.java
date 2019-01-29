package com.revature.junit;

public class MoreMethods {
	
	public int add(int...nums) {
		int sum = 0;
		for(int i: nums) {
			sum += i;
		}
		return sum;
	}

}
