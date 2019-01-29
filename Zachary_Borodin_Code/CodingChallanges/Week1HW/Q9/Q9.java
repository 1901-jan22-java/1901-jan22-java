package com.revature.hw1.Q9;

import java.util.ArrayList;
import java.util.List;

public class Q9 {
	
	public static boolean isPrime(int x) {
		int count =0;
		for(int i=2; i<=x;i++) {
			//test all the numbers up to x and if it only divides evenly with itself then it is prime
			if(x%i ==0)
					count++;
		}
		if(count ==1)
			return true;
		else return false;
	}
	public static void main(String[] args) {
		List<Integer> L = new ArrayList<>();
		for(int i=0; i<100;i++) {
			L.add(i+1);
		}
		System.out.println("Original List");
		System.out.println(L + "\n");
		
		System.out.println("Here are the prime numebrs from 1-100");
		List<Integer> primes = new ArrayList<>();
		for(int i=0; i<L.size(); i++) {
			int test = L.get(i);
			boolean isPrime = isPrime(test);
			if(isPrime == true) {
				primes.add(test);
			}
		}
		System.out.println(primes);
	}

}
