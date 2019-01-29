package com.revature.hw1.Q19;

import java.util.ArrayList;
import java.util.List;

import com.revature.hw1.Q9.Q9;

public class Q19 {

	public static void main(String[] args) {
		List l = new ArrayList<Integer>();
		for(int i=0; i<10; i++) {
			l.add(i+1);
		}
		System.out.println("Original list: " + l);
		
		//add up even numbers
		int evenSum = 0;
		int oddSum = 0;
		for(int i=0; i<l.size(); i++) {
			int test = (int) l.get(i);
			if( test %2 == 0 )
					evenSum +=test;
			else oddSum+= test;
		}
		System.out.println("Sum of even numbers: "+ evenSum);
		System.out.println("Sum of odd numbers: "+ oddSum);
		
		//using the method in Q9 that tests if a number is prime
		Q9  primeTest = new Q9();
		for(int i=0; i<l.size(); i++) {
			int num = (int) l.get(i);
			boolean prime = primeTest.isPrime(num);
			if(prime = true)
				l.remove(i);
			}
		
		System.out.print("The list without primes is: "+ l);
		}
		
	}
