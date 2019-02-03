package com.revature.assignment1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Question 9
 * 
 * @author Sanford
 *
 */

public class Prime {
	
	public static void main(String[] args) {
		System.out.println(new Prime());
	}
	
	private static final ArrayList<BigInteger> list;
	
	static {
		list = new ArrayList<>();
		
		// build list of primes for better execution/implementation
		list.addAll(Arrays.asList(
				new BigInteger("2"), 
				new BigInteger("3")
				));
	}
	
	private ArrayList<Integer> input;
	private ArrayList<Integer> primes;
	
	public Prime() {
		input = new ArrayList<>();
		for(int i = 1; i <= 100; i++)
			input.add(i);
		
		primes = find(input);
	}
	
	public Prime(ArrayList<Integer> input) {
		this.input = input;
		primes = find(input);
	}
	
	public static ArrayList<Integer> find(ArrayList<Integer> arr){
		ArrayList<Integer> p = new ArrayList<>();
		
		for(Integer i: arr)
			if(isPrime(i)) p.add(i);
		return p;
	}
	
	public static boolean isPrime(Integer n) {
		for(int i = 2; i < n; i++)
			if(n%i == 0) return false;
			
		return true;
	}
	
	@Override
	public String toString() {
		return primes.toString();
	}
	
}
