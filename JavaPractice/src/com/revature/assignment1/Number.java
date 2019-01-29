package com.revature.assignment1;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Question 15
 * Question 24
 * Question 25
 * 
 * @author Sanford
 *
 */

public class Number implements Mathematical<Number> {
	
	BigInteger num;

	public Number() {
		this.num = BigInteger.ZERO;
	}
	
	public Number(int num) {
		setNum(num);
	}
	
	public Number(long num) {
		setNum(num);
	}
	
	public Number(BigInteger num) {
		this.num  = num;
	}
	

	/* Base change methods overloaded */
	
	public String toHex() {
		return decToHex(BigInteger.valueOf(num.longValue()));
	}
	
	public static String decToHex(long num) {
		return decToBase(BigInteger.valueOf(num), new BigInteger("16"));
	}
	
	public static String decToHex(int num) {
		return decToBase(BigInteger.valueOf(num), new BigInteger("16"));
	}
	
	public static String decToHex(BigInteger num) {
		return decToBase(num, new BigInteger("16"));
	}
	
	public static String decToBase(BigInteger num, BigInteger base) {
		StringBuilder sb = new StringBuilder();
		for(;num.compareTo(BigInteger.ZERO) > 0; num = num.divide(base)) {
			BigInteger rem = num.mod(base);
			String remStr = rem.toString();
			if( rem.compareTo(new BigInteger("9")) > 0 ) // && rem.compareTo(new BigInteger("36")) < 0 )
				remStr = Character.toString( (char) (rem.intValue()-10+'a') );
			sb.append(remStr);
		}
		return sb.reverse().append("-base" + base.toString()).toString();
	}
	
	/* Roman Numerals */
	public String toRomanNumeral() {
		return toRomanNumeral(num);
	}
	
	public static String toRomanNumeral(BigInteger n) {
		if( n.equals(BigInteger.ZERO) ) throw new IllegalArgumentException();
		StringBuilder sb = new StringBuilder();
		if( n.compareTo(BigInteger.ZERO) < 0) sb.append("-");
		
		for(RomanNumeral numeral: (new Reverse<RomanNumeral>(RomanNumeral.values())).getReversed()) {
			while( (n = n.subtract(numeral.weight)).compareTo(BigInteger.ZERO) >= 0 )
				sb.append(numeral);
			n = n.add(numeral.weight);
		}
		
		return sb.toString();
	}
	
	
	
	/* Mathematical Methods */
	
	@Override
	public Number add(Number b) {
		return new Number( num.add(b.num) );
	}

	@Override
	public Number subtract(Number b) {
		return new Number( num.subtract(num) );
	}

	@Override
	public Number multiply(Number b) {
		return new Number( num.multiply(b.num) );
	}

	@Override
	public Number divide(Number b) {
		return new Number( num.divide(b.num) );
	}
	
	/* Object Overrides */
	
	@Override
	public String toString() {
		return num.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		if(o == null || !(o instanceof Number)) return false;
		return num.equals( ((Number) o).num );
	}
	
	public BigInteger getNum() {
		return num;
	}
	
	public long longValue() {
		return num.longValue();
	}
	
	public void setNum(int num) {
		this.num = BigInteger.valueOf(num);
	}
	
	public void setNum(long num) {
		this.num = BigInteger.valueOf(num);
	}

}

enum RomanNumeral {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100),
    CD(400),
    D(500),
    CM(900),
    M(1000);
    BigInteger weight;
    long longValue;
    
    RomanNumeral(int weight) {
        setWeight( (long) weight );
    }
    
    RomanNumeral(long weight) {
    	setWeight( weight );
    }
    
    RomanNumeral(String str) {
    	setWeight( str );
    }
    
    private void setWeight(long weight) {
        this.weight = BigInteger.valueOf(weight);
        longValue = this.weight.longValue();
    }
    
    private void setWeight(String str) {
        weight = new BigInteger(str);
        longValue = weight.longValue();
    }
    
}

interface Mathematical<T> {
	T add(T b);
	T subtract(T b);
	T multiply(T b);
	T divide(T b);
}

class NumberTest {
	
	public static void main(String[] args) {
		Number n = new Number(3);
		System.out.println( "Number is " + n);
		System.out.println( "Question 24: " + n.toHex() );
		System.out.println( "Question 25: " + n.toRomanNumeral() );
	}
	
	private static final int[] A_LIST 	= {1, 2, 3};
	private static final int[] B_LIST 	= {1, 4, 2};

	private static final int[] AplusB 	= {2, 6, 5};
	private static final int[] AminusB 	= {0, -2, 1};
	private static final int[] AtimesB 	= {1, 8, 6};
	private static final int[] AdivideB = {1, 0, 1};

	private static ArrayList<Number> A_ARR;
	private static ArrayList<Number> B_ARR;

	private static ArrayList<Number> AplusB_arr;
	private static ArrayList<Number> AminusB_arr;
	private static ArrayList<Number> AtimesB_arr;
	private static ArrayList<Number> AdivideB_arr;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		A_ARR = numberArrayList(A_LIST);
		B_ARR = numberArrayList(B_LIST);

		AplusB_arr		= numberArrayList(AplusB);
		AminusB_arr  	= numberArrayList(AminusB);
		AtimesB_arr  	= numberArrayList(AtimesB);
		AdivideB_arr  	= numberArrayList(AdivideB);
	}
	
	private static ArrayList<Number> numberArrayList(int[] arr){
		ArrayList<Number> res = new ArrayList<>();
		for(int n: arr) res.add(new Number(n));
		return res;
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		A_ARR = null;
		B_ARR = null;

		AplusB_arr		= null;
		AminusB_arr  	= null;
		AtimesB_arr  	= null;
		AdivideB_arr  	= null;
		
		System.gc();
	}
	
	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
		
	}
	
	
	@Test
	public void test() {
		for(int i = 0; i < AplusB.length; i++) {
			Number a = A_ARR.get(i);
			Number b = B_ARR.get(i);

			Assert.assertTrue(a.add(b).equals(AplusB_arr.get(i)));
			Assert.assertTrue(a.subtract(b).equals( AminusB_arr.get(i)));
			Assert.assertTrue(a.multiply(b).equals(AtimesB_arr.get(i)));
			Assert.assertTrue(a.divide(b).equals(AdivideB_arr.get(i)));
		}
	}
}
