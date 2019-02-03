package com.revature.assignment1;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Question 2
 * 
 * @author Sanford
 *
 */

public class Fibonacci {

	private static final ArrayList<BigInteger> fibonacci = new ArrayList<>();
	static {
		fibonacci.add(BigInteger.ZERO);
		fibonacci.add(BigInteger.ONE);
		for(int i = 2; i < 100; i++) {
			fibonacci.add( fibonacci.get(i-2).add(fibonacci.get(i-1)) );
		}
	}
	
	public static BigInteger compute(int n) {
		if(n < 0) return null;

		for(int i = fibonacci.size()-1; i < n; i++) {
			fibonacci.add( fibonacci.get(i-2).add(fibonacci.get(i-1)) );
		}

		return fibonacci.get(n);
	}
	
	public static ArrayList<BigInteger> upTo(int n) {

		ArrayList<BigInteger> res = new ArrayList<>();
		
		for(int i = 0; i < n; i++)
			res.add( fibonacci.get(i) );
		
		return res;
	}
	
}
