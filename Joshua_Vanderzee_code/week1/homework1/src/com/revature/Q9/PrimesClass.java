package com.revature.Q9;

import java.util.ArrayList;
import java.util.List;

public class PrimesClass {
	public static int[] Compute(int limit) {
		int[] ints = new int[limit];
		ArrayList<Integer> primes = new ArrayList<Integer>();
		ArrayList<Integer> excludes = new ArrayList<Integer>();
		for (int i = 0; i < limit; i++) {
			ints[i] = i + 1;
		}
		int place = 2;
		while(place < limit) {
			if (excludes.indexOf(place) == -1)
				primes.add(place);
			for (int i = place; i < ints.length; i+=place) {
				excludes.add(i + place);
			}
			place++;
		}

		int[] a = new int[primes.size()];
		for (int i = 0; i < primes.size(); i++) {
			a[i] = primes.get(i); 
		}
		return a;
	}
}
