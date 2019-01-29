package com.revature.challenges;

public class ArrayChallenge {
	
	public static void main(String[] args) {
		int[] a = {1, 3, 7, 2, 5, 10};
		int b = 13;
		
		System.out.println(containsTarget(a, b));
		
		int[] c = {2, 4, 6, 8};
		int d = 7;
		
		System.out.println(containsTarget(c,d));
		
	}
	
	static boolean containsTarget(int[] array, int target) {
		int count = 1;
		for(int x : array) {
			for(int i = count ; i < array.length; i++) {
				if (x + array[i] == target) return true;
			}
			count++;
		}
		return false;
		
	}

}
