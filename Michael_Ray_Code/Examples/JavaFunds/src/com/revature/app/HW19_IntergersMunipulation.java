package com.revature.app;

import java.util.ArrayList;
import java.util.List;

public class HW19_IntergersMunipulation {
public static void main(String[] args) {
	List<Integer> numbers = new ArrayList<Integer>();
	
	int evenSum = 0;
	int oddSum = 0;
	
	for(int i = 1; i <= 10; i++){
		System.out.print(i + ", ");
		
		if((i%2) == 0){
			evenSum += i;
		}
		else{
			oddSum += i;
		}
		
		if(!IsAPrime(i)){
			numbers.add(i);
		}		
	}
	System.out.println("\nEven Sums: " + evenSum);
	System.out.println("Odd Sums: " + oddSum);
	
	System.out.print("Prime numbers elimanated: ");
	for(Integer i : numbers){
		System.out.print(i + ", ");
	}
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
