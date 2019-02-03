package com.revature.assignment1;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Question 6
 * Question 12
 * 
 * @author Sanford
 *
 */

public class Even {
	
	public BigInteger number;
	public boolean isEven;
	public static final ArrayList<BigInteger> EVENS = new ArrayList<>();
	
	static {
		for(int i = 0; i <= 100; i+=2)
			EVENS.add(BigInteger.valueOf(i));
	}
	
	public static void main(String[] args) {
		System.out.println("Question 6: " + isEven(6));
		System.out.println("Question 12: " + range(1, 100));
	}
	
	public Even() {
		number = BigInteger.ZERO;
		isEven = true;
	}
	
	public Even(int val) {
		number = BigInteger.valueOf(val);
		this.isEven = isEven(number);
	}

	public Even(long val) {
		number = BigInteger.valueOf(val);
		this.isEven = isEven(number);
	}
	
	public Even(String val) {
		number = new BigInteger(val);
		this.isEven = isEven(number);
	}

	public static boolean isEven(int val) {
		return isEven(BigInteger.valueOf(val));
	}
	
	public static boolean isEven(long val) {
		return isEven(BigInteger.valueOf(val));
	}
	
	public static boolean isEven(BigInteger val) {
		return val.subtract(val.divide(new BigInteger("2")).multiply(new BigInteger("2"))).equals(BigInteger.ZERO);
	}
	
	public static ArrayList<BigInteger> range(int start, int end){
		ArrayList<BigInteger> res = new ArrayList<>();
		
		for(int i = (start+1)/2; i <= end/2; i++) {
			if(i > EVENS.size()-1) EVENS.add(BigInteger.valueOf(i*2));
			res.add(EVENS.get(i));
		}
		return res;
	}
	
}
