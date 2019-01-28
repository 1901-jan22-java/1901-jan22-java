package com.revature.question02;

import com.revature.question01.BubbleSort;
import com.revature.utilities.Printable;

public class Fibonacci implements Printable{

	static int [] displayFib(int number) 
	{
		
		int [] fib = new int [number];
		
		for (int i = 0; i < fib.length; i++) {
			
			if(i==0 || i==1) {
				fib[i] = i;
			}
			else {
				fib[i] = fib[i-1] + fib[i-2];
			}
		}
		return fib;
	}
	
	public static void main(String[] args) {
		Fibonacci b = new Fibonacci();
		b.printArray(displayFib(25));;
	}
}