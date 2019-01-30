package com.revature.app;

public class HW12_EnhancedForLoop {
public static void main(String[] args) {
	Integer[] numbers = new Integer[100];
	
	for(int i = 0; i < 100; i++){
		numbers[i] = i+1;
	}
	
	for(Integer i : numbers){
		if((i % 2) == 0){
			System.out.print(i + ", ");
		}
	}
}
}
