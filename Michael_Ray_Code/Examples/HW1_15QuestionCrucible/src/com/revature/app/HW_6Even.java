package com.revature.app;

public class HW_6Even {
public static void main(String[] args) {
	System.out.println(CheckIfEven(1942435));
}

static boolean CheckIfEven(float num){
	boolean isEven = true;
	
	float numCheck = num / 2;
	int intNumCheck = (int)numCheck;
	
	float finalCheck = numCheck - intNumCheck;
	
	//System.out.println(numCheck);
	
	if(finalCheck > 0){
		isEven = false;
	}
	
	return isEven;
}
}
