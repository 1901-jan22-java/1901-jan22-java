package com.revature.assignment1;

import java.util.ArrayList;

/**
 * Question 3
 * 
 * @author Sanford
 *
 */

public class Reverse<T> {
	
	T[] reversed;
	
	public Reverse(T[] arr){
		this.reversed = reverse(arr);
	}
	
	public static void main(String[] args) {
		System.out.println( stringReverse("string") );
	}

	public static String stringReverse(String s) {
		int len = s.length();
		ArrayList<Character> carr = new ArrayList<>();
		for(char c: s.toCharArray()) carr.add(c);

		for(int i = 0, j = len-1-i; i < len/2; j = len-1-(++i)) {
			char temp = carr.get(i);
			carr.set(i, carr.get(j));
			carr.set(j, temp);
		}
		
		return String.valueOf(carr);
	}
	
	public T[] reverse() {
		return reversed = reverse(reversed);
	}
	
	public static <T> T[] reverse(T[] arr){
		for(int i = 0, j = arr.length-1-i; i < arr.length/2; i++) {
			j = arr.length-1-i;
			T temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		return arr;
	}
	
	public T[] getReversed() {
		return reversed;
	}
	
}
