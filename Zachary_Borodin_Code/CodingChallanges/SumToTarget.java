package com.revature.codingchallenges;

public class SumToTarget {
	
	public static boolean targetFinder(int ar[],int target) {
		for(int i=0; i<ar.length;i++) {
			for(int j=i+1;j<ar.length;j++) {
				if((ar[i] + ar[j]) == target)
					return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int a1[] = {1,3,7,2,5,10};  int t1 = 13;
		int a2[] = {2,4,6,8};	int t2 = 7;
		
		boolean r1 = targetFinder(a1,t1);
		System.out.println(r1);
		
		boolean r2 = targetFinder(a2,t2);
		System.out.println(r2);
	}
}
