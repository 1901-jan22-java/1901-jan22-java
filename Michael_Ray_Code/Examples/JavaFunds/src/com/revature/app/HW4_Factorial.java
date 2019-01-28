package com.revature.app;

import java.util.ArrayList;
import java.util.List;

public class HW4_Factorial {
public static void main(String[] args) {
	//int fib = GetFacSequenceNum(2);	
	//System.out.println(fib);
		
		for(int i = 0; i < 13; i++){
			int fib = GetFacSequenceNum(i);	
			System.out.print(i + "~" + fib +", ");
		}
		String pizza = "pizza";
}

static List<Integer> memo;
static int highestFacNum = 25;

static{
	memo = new ArrayList<Integer>();
	memo.add(0);
	memo.add(1);
	GetFacSequenceNum(25);
}

static int GetFacSequenceNum(int num){
	int finalNum = 0;
	
	if(num <= 0){
		return finalNum;
	}
	
	int memSize = memo.size();
	int numCheck = num + 1;
	
	if(num > memSize){
		for(int i = memSize; i < numCheck; i++){
			int newNum = memo.get(i-1) * (i);			
			memo.add(newNum);
			finalNum = newNum;
		}
	}
	else{
		finalNum = memo.get(num);
	}
	return finalNum;
}

}
