package com.revature.question09;

import java.util.ArrayList;

public class PrintPrimes {
	
	static ArrayList <Integer> printPrimesUpTo(int num){
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for (int i = 2; i < num+1; i++) {
			array.add(i);
			if(i<10) 
			{
				int temp = i;
			//// UNFINISED ///
			}
			else if(!(i%2==0) && !(i%3==0) && !(i%5==0) && !(i%7==0))
			{
				System.out.print(i+" ");
			}
		}
		System.out.println();
		return array;
	}
	
	public static void main(String[] args) {
		printPrimesUpTo(50);
	}
}
