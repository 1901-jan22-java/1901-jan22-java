package com.revature.app;

import java.util.ArrayList;
import java.util.List;

public class HW9_Primes {
public static void main(String[] args) {
	
	List<Integer> primes = new ArrayList<Integer>();
	
	for(int i = 1; i <= 101; i++){
		if(IsAPrime(i)){
			primes.add(i);
		}
	}
	System.out.println(primes);
}

public static boolean IsAPrime(int num){
	boolean isPrime = true;
	
	if(num == 2 || num == 3){
		return true;
	}
	
for(int i = 2; i < ){
	
}
	
	if((num % 2) == 0 || (num % 3) == 0 || (num % 5) == 0){
		isPrime = false;
	}
	
	return isPrime;
}
}


