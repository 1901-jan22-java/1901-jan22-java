package com.revature.assignment1;

import java.util.ArrayList;

/**
 * Question 19
 * 
 * @author Sanford
 *
 */

public class ListOfNumbers {
	private ArrayList<Integer> list;

	public ListOfNumbers() {
		list = new ArrayList<>();
		for(int i = 1; i <= 10; i++)
			list.add(i);
	}
	
	public ListOfNumbers(int end) {
		list = new ArrayList<>();
		for(int i = 1; i <= end; i++)
			list.add(i);
	}
	
	public ListOfNumbers(int start, int end) {
		list = new ArrayList<>();
		for(int i = start; i <= end; i++)
			list.add(i);
	}
	
	public ListOfNumbers(ArrayList<Integer> list) {
		this.list = list;
	}
	
	public Integer addEvens() {
		Integer sum = 0;
		for(Integer i: list)
			if(Even.isEven(i)) sum += i;
		return sum;
	}
	
	public Integer addOdds() {
		Integer sum = 0;
		for(Integer i: list)
			if(!Even.isEven(i)) sum += i;
		return sum;
	}
	
	public ArrayList<Integer> noPrimeClone() {
		ArrayList<Integer> newList = new ArrayList<>();
		for(Integer i: list)
			if(!Prime.isPrime(i)) newList.add(i);
		return newList;
	}
}
