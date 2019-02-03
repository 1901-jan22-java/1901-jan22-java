package com.revature.codingchallenges;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayChallenge {
	
	public static void main(String[] args) {
		System.out.println(Arrays.asList(addUpToTarget(new Integer[] {1, 1, 1, 1, 1}, 3)));
	}
	
	public static Integer[] addUpToTarget(Integer[] arr, int target) {
		HashMap<Integer, Integer> dyn = new HashMap<>();
		
		for(int a: arr)
			dyn.put(a, target-a);
		
		for( Integer key: dyn.keySet() ) {
			Integer tar = dyn.get(key);
			Integer val = dyn.get(tar);
			if( val != null)
				return new Integer[] {key, tar};
		}

		return new Integer[] {};
	}
	
}
