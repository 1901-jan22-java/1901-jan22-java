package com.revature.primes;

import java.util.ArrayList;

public class PrintPrimes {
	public static boolean isPrime(int num, ArrayList<Integer> primes) {
		if(num == 2) {
			return true;
		}
		
		for(Integer i : primes) {
			if(num%i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void fillArray(ArrayList<Integer> nums) {
		for(int i=1; i <= 100; i++) {
			nums.add(new Integer(i));
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		fillArray(nums);
		
		for(Integer i : nums) {
			if(i == 1) {
				System.out.println(i);
			} else if(isPrime(i, primes)) {
				System.out.println(i);
				primes.add(i);
			}
		}
	}
}
