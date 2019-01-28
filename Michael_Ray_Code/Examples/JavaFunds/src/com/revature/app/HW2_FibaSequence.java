package com.revature.app;

import java.util.ArrayList;
import java.util.List;

public class HW2_FibaSequence {
public static void main(String[] args) {
	//int fib = GetFibSequenceNum(2);	
	//System.out.println(fib);
	
	for(int i = 0; i < 25; i++){
		int fib = GetFibSequenceNum(i);	
		System.out.print(fib +", ");
	}
}
static List<Integer> memo;
static int highestFibNum = 25;

static{
	memo = new ArrayList<Integer>();
	memo.add(0);
	memo.add(1);
	GetFibSequenceNum(25);
}

static int GetFibSequenceNum(int num){
	int finalNum = 0;
	
	if(num <= 0){
		return finalNum;
	}
	
	int memSize = memo.size() - 1;
	int numCheck = num - 1;
	
	if(num > memSize){
		for(int i = memSize; i < numCheck; i++){
			int newNum = memo.get(i) + memo.get(i - 1);			
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
