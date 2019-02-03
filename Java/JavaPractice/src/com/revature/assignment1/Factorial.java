package com.revature.assignment1;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Question 4
 * 
 * @author Sanford
 *
 */

public class Factorial {
	
	private static final ArrayList<BigInteger> factorials = new ArrayList<>();
	
	static {
		factorials.add(BigInteger.ONE);
		for(int i = 1; i <= 20; i++) {
			factorials.add( factorials.get((i-1)).multiply(BigInteger.valueOf(i)) );
		}
	}

	public static BigInteger compute(int n) {
		if(n < 0) return null;

		for(int i = factorials.size(); i <= n; i++) {
			factorials.add( factorials.get((i-1)).multiply(BigInteger.valueOf(i)) );
			if( factorials.get(i).compareTo(BigInteger.ZERO) < 0 ) {
				break;
			}
		}

		return factorials.get(n);
	}

	public static ArrayList<BigInteger> upTo(int n) {

		ArrayList<BigInteger> res = new ArrayList<>();
		
		for(int i = 0; i < n; i++)
			res.add( factorials.get(i) );
		
		return res;
	}

	public static Integer trailingZeros(int n) {

		BigInteger fact = compute(n);
		Integer zeros = new Integer(0);
		
		while( fact.mod(BigInteger.TEN).equals(BigInteger.ZERO) ) {
			zeros++;
			fact = fact.divide(BigInteger.TEN);
		}

		return zeros;
		
	}
	
}
