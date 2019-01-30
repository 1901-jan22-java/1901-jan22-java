package com.revature.app;

import java.util.ArrayList;
import java.util.List;

public class HW9_Primes {
public static void main(String[] args) {
	
	List<Integer> primes = new ArrayList<Integer>();
	
	for(int i = 1; i <= 100; i++){
		if(IsAPrime(i)){
			primes.add(i);
		}
	}
	System.out.println(primes);
}

public static boolean IsAPrime(int num){	
	if(num == 1){
		return false;
	}
	
	for(int i = 2; i < 10; i++){
		if((num % i) == 0 && i != num){
			return false;
		}
		
	}
	

	return true;
}
}


